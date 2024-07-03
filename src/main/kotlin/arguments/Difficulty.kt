package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class Difficulty(private val mcName: String) : Minecraftable {
    Peaceful("peaceful"),
    Easy("easy"),
    Normal("normal"),
    Hard("hard");

    override fun toMinecraft(): String {
        return mcName
    }
}