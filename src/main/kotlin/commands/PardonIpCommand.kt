package com.mycelium.commands

import com.mycelium.target.TargetSelector

class PardonIpCommand(private val targets: TargetSelector) : BaseCommand("pardon-ip") {
    override fun toMinecraft(): String {
        addArgument(targets)
        return super.toMinecraft()
    }
}