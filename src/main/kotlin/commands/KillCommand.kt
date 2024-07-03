package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class KillCommand(private val entity: TargetSelector) : BaseCommand("kill") {
    override fun toMinecraft(): String {
        addArgument(entity)
        return super.toMinecraft()
    }
}