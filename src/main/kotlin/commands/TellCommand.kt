package com.mycelium.commands

import com.mycelium.target.TargetSelector

class TellCommand(private val target: TargetSelector, private val message: String) : BaseCommand("tell") {
    override fun toMinecraft(): String {
        addArgument(target)
        addArgument(message)

        return super.toMinecraft()
    }
}