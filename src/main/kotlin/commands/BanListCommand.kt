package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable

enum class BanListType(private val mcName: String) : Minecraftable {
    Ips("ips"),
    Players("players");

    override fun toMinecraft() = mcName
}

class BanListCommand(private val type: BanListType?=null) : BaseCommand("banlist") {
    override fun toMinecraft(): String {
        if(type != null) addArgument(type)
        return super.toMinecraft()
    }
}