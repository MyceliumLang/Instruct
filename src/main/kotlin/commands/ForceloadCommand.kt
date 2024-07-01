package com.mycelium.commands

import com.mycelium.arguments.vec.Vector2

class ForceloadCommand : BaseCommand("forceload") {
    fun add(from: Vector2<Int>, to: Vector2<Int>? = null) : CommandEnd {
        return CommandEnd(this, "add", from.toMinecraft(), to?.toMinecraft() ?: "")
    }

    fun remove(from: Vector2<Int>, to: Vector2<Int>? = null) : CommandEnd {
        return CommandEnd(this, "remove", from.toMinecraft(), to?.toMinecraft() ?: "")
    }

    fun removeAll() : CommandEnd {
        return CommandEnd(this, "remove", "all")
    }

    fun query(pos: Vector2<Int>? = null) : CommandEnd {
        return CommandEnd(this, "query", pos?.toMinecraft() ?: "")
    }
}