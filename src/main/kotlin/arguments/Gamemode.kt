package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class Gamemode(private val mcName: String) : Minecraftable {
    Spectator("spectator"),
    Survival("survival"),
    Creative("creative"),
    Adventure("adventure");

    override fun toMinecraft(): String {
        return mcName
    }
}