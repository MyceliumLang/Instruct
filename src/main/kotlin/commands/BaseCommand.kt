package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable

open class BaseCommand(baseCommandName: String) : Commandable {
    override val name: String = baseCommandName

    private val arguments: MutableList<String> = mutableListOf()

    fun addArgument(argument: Minecraftable): BaseCommand {
        return addArgument(argument.toMinecraft())
    }

    fun addArgument(argument: String): BaseCommand {
        arguments.add(argument)
        return this
    }

    override fun toMinecraft(): String {
        return "$name${if(arguments.isNotEmpty()) " ${arguments.joinToString(" ")}" else ""}"
    }
}