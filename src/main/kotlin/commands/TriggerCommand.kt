package com.mycelium.commands

class TriggerCommand(private val objective: String) : BaseCommand("trigger") {
    fun add(value: Int): CommandEnd {
        return CommandEnd(this, "add", value.toString())
    }

    fun set(value: Int): CommandEnd {
        return CommandEnd(this, "set", value.toString())
    }

    override fun toMinecraft(): String {
        addArgument(objective)
        return super.toMinecraft()
    }
}