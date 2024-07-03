package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class PardonIpCommand(private val targets: TargetSelector) : BaseCommand("pardon-ip") {
    override fun toMinecraft(): String {
        addArgument(targets)
        return super.toMinecraft()
    }
}