package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.arguments.Time

enum class TimeQuery(private val mcName: String) : Minecraftable {
    Daytime("daytime"),
    Gametime("gametime"),
    Day("day");

    override fun toMinecraft(): String {
        return mcName
    }
}

class TimeCommand : BaseCommand("time") {
    fun add(time: Float) : CommandEnd {
        return CommandEnd(this,  "add", time.toString())
    }

    fun query(query: TimeQuery) : CommandEnd {
        return CommandEnd(this, "query", query.toMinecraft())
    }

    fun set(time: Time) : CommandEnd {
        return CommandEnd(this, "set", time.toMinecraft())
    }

    fun set(time: Float) : CommandEnd {
        return CommandEnd(this, "set", time.toString())
    }
}