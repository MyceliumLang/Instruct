package com.mycelium.commands

import com.mycelium.target.TargetSelector

class PardonCommand(private val targets: TargetSelector) : BaseCommand("pardon") {
    override fun toMinecraft(): String {
        addArgument(targets)
        return super.toMinecraft()
    }
}