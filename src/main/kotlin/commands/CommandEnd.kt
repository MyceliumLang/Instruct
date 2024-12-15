package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable

open class CommandEnd(private val command: Commandable, vararg val arguments: String) : Minecraftable {
    override fun toMinecraft(): String {
        return "${command.toMinecraft()} ${arguments.joinToString(" ")}"
    }
}