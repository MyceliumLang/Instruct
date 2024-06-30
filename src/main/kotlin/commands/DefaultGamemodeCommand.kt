package com.mycelium.commands

import com.mycelium.arguments.Gamemode

class DefaultGamemodeCommand(private val gamemode: Gamemode) : BaseCommand("defaultgamemode") {
    override fun toMinecraft(): String {
        addArgument(gamemode.toMinecraft())

        return super.toMinecraft()
    }
}