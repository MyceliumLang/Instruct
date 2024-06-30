package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class Gamemode(private val mcName: String) : Minecraftable {
    Spectator("spectator"),
    Survival("survival"),
    Creative("creative"),
    Adventure("adventure");

    override fun toMinecraft(): String {
        return mcName
    }
}