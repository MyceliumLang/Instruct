package com.mycelium.commands

import com.mycelium.target.TargetSelector

class KillCommand(private val entity: TargetSelector) : BaseCommand("kill") {
    override fun toMinecraft(): String {
        addArgument(entity)
        return super.toMinecraft()
    }
}