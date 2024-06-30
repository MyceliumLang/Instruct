package com.mycelium.commands

import com.mycelium.Minecraftable

open class SubCommand(val parent: Commandable, subCommandName: String?=null) : Commandable {
    override val name: String? = subCommandName

    private val arguments: MutableList<String> = mutableListOf()

    fun addArgument(argument: Minecraftable): SubCommand {
        return addArgument(argument.toMinecraft())
    }

    fun addArgument(argument: String): SubCommand {
        arguments.add(argument)
        return this
    }

    override fun toMinecraft(): String {
        return "${parent.toMinecraft()} ${if(name != null) name else "\b"}${if(arguments.isNotEmpty()) " ${arguments.joinToString(" ")}" else ""}"
    }
}