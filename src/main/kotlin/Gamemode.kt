package com.mycelium

enum class Gamemode(name: String) : Minecraftable {
    Spectator("spectator"),
    Survival("spectator"),
    Creative("spectator"),
    Adventure("spectator");

    override fun toMinecraft(): String {
        return name
    }
}