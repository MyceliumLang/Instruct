package com.mycelium.commands

import com.mycelium.target.TargetSelector

class OpCommand(private val target: TargetSelector) : BaseCommand("op") {
    override fun toMinecraft(): String {
        addArgument(target.toMinecraft())

        return super.toMinecraft()
    }
}