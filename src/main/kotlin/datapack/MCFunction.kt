package io.github.myceliumlang.datapack

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.commands.CommandEnd
import io.github.myceliumlang.commands.Commandable
import io.github.myceliumlang.commands.FunctionCommand

class MCFunction(val name: String, var tags: Set<Tag> = setOf()) {
    enum class Tag {
        Tick,
        Load
    }

    val members: MutableList<Minecraftable> = mutableListOf()

    fun addCommand(command: Commandable) {
        members.add(command)
    }

    fun addCommand(command: CommandEnd) {
        members.add(command)
    }

    fun compile(): String {
        val contents = StringBuilder()

        for(command in members)
            contents.appendLine(command.toMinecraft())

        return contents.toString()
    }

    fun call(datapack: Datapack): FunctionCommand {
        return FunctionCommand("${datapack.namespace}:$name")
    }
}