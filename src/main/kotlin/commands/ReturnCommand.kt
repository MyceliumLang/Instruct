package io.github.myceliumlang.commands

class ReturnCommand(private val value: Int?=null) : BaseCommand("return") {
    fun fail(): CommandEnd {
        return CommandEnd(this, "fail")
    }

    fun run(command: Commandable): CommandEnd {
        return CommandEnd(this, "run", command.toMinecraft())
    }

    fun run(command: CommandEnd): CommandEnd {
        return CommandEnd(this, "run", command.toMinecraft())
    }

    override fun toMinecraft(): String {
        if(value != null) addArgument(value.toString())
        return super.toMinecraft()
    }
}