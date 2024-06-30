package com.mycelium.commands

import com.mycelium.Minecraftable

class CommandEnd(private val command: Commandable, vararg val arguments: String) : Minecraftable {
    override fun toMinecraft(): String {
        return "${command.toMinecraft()} ${arguments.joinToString(" ")}"
    }
}