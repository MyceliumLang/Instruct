package com.mycelium.commands

import com.mycelium.target.TargetSelector

class BanCommand(private val targets: TargetSelector, private val reason: String?=null) : BaseCommand("ban") {
    override fun toMinecraft(): String {
        addArgument(targets)
        if(reason != null) addArgument(reason)
        return super.toMinecraft()
    }
}