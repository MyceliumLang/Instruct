package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class Gamemode(private val mcName: String) : Minecraftable {
    Spectator("spectator"),
    Survival("spectator"),
    Creative("spectator"),
    Adventure("spectator");

    override fun toMinecraft(): String {
        return mcName
    }
}