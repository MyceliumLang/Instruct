package com.mycelium.commands

import com.mycelium.target.TargetSelector

class WhitelistCommand : BaseCommand("whitelist") {
    fun add(target: TargetSelector): CommandEnd {
        return CommandEnd(this, "add", target.toMinecraft())
    }

    fun list(): CommandEnd {
        return CommandEnd(this, "list")
    }

    fun off(): CommandEnd {
        return CommandEnd(this, "off")
    }

    fun on(): CommandEnd {
        return CommandEnd(this, "on")
    }

    fun reload(): CommandEnd {
        return CommandEnd(this, "reload")
    }

    fun remove(target: TargetSelector): CommandEnd {
        return CommandEnd(this, "remove", target.toMinecraft())
    }
}