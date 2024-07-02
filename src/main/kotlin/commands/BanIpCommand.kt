package com.mycelium.commands

import com.mycelium.target.TargetSelector

class BanIpCommand(private val target: TargetSelector, private val reason: String?=null) : BaseCommand("ban-ip") {
    override fun toMinecraft(): String {
        addArgument(target)
        if(reason != null) addArgument(reason)
        return super.toMinecraft()
    }
}