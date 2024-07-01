package com.mycelium.commands

class ListCommand(private val listUUIDS: Boolean = false) : BaseCommand("list") {
    override fun toMinecraft(): String {
        if (listUUIDS) addArgument("uuids")
        return super.toMinecraft()
    }
}
