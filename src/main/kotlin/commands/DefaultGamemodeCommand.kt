package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.Gamemode

class DefaultGamemodeCommand(private val gamemode: Gamemode) : BaseCommand("defaultgamemode") {
    override fun toMinecraft(): String {
        addArgument(gamemode.toMinecraft())

        return super.toMinecraft()
    }
}