package com.mycelium.commands

import com.mycelium.arguments.Gamemode

class PublishCommand() : BaseCommand("publish") {
    private var allowCommands: Boolean? = null
    private var gamemode: Gamemode? = null
    private var port: Int? = null // docs say this should be an Int, but ports are technically UShorts

    fun allowCommands(allow: Boolean): PublishCommand {
        allowCommands = allow
        return this
    }

    fun gamemode(mode: Gamemode): PublishCommand {
        gamemode = mode
        return this
    }

    fun port(port: Int): PublishCommand {
        this.port = port
        return this
    }

    override fun toMinecraft(): String {
        allowCommands?.toString()?.let{ addArgument(it) }
        gamemode?.toMinecraft()?.let{ addArgument(it) }
        port?.toString()?.let{ addArgument(it) }

        return super.toMinecraft()
    }
}