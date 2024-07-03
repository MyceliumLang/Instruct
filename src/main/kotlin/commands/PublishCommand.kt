package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.Gamemode

class PublishCommand(private val allowCommands: Boolean? = null, private val gamemode: Gamemode? = null,
                     private val port: Int? = null /* docs say this should be an Int, but ports are technically UShorts */) : BaseCommand("publish") {

    override fun toMinecraft(): String {
        allowCommands?.toString()?.let{ addArgument(it) }
        gamemode?.toMinecraft()?.let{ addArgument(it) }
        port?.toString()?.let{ addArgument(it) }

        return super.toMinecraft()
    }
}