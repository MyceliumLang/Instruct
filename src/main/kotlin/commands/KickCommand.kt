package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class KickCommand(private val targets: TargetSelector, private val reason: String?=null) : BaseCommand("kick") {
    override fun toMinecraft(): String {
        addArgument(targets)
        if(reason != null) addArgument(reason)
        return super.toMinecraft()
    }
}