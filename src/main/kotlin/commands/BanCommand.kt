package io.github.myceliumlang.commands

import io.github.myceliumlang.target.TargetSelector

class BanCommand(private val targets: TargetSelector, private val reason: String?=null) : BaseCommand("ban") {
    override fun toMinecraft(): String {
        addArgument(targets)
        if(reason != null) addArgument(reason)
        return super.toMinecraft()
    }
}