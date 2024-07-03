package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class PardonCommand(private val targets: TargetSelector) : BaseCommand("pardon") {
    override fun toMinecraft(): String {
        addArgument(targets)
        return super.toMinecraft()
    }
}