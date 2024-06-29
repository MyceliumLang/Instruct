package com.mycelium.commands

import com.mycelium.Minecraftable

open class BaseCommand(val name: String) : Minecraftable {
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