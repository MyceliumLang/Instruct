package com.mycelium.commands

import com.mycelium.target.TargetSelector

class DeopCommand(private val target: TargetSelector): BaseCommand("deop") {
    override fun toMinecraft(): String {
        addArgument(target.toMinecraft())

        return super.toMinecraft()
    }
}