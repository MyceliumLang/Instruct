package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class OpCommand(private val target: TargetSelector) : BaseCommand("op") {
    override fun toMinecraft(): String {
        addArgument(target.toMinecraft())

        return super.toMinecraft()
    }
}