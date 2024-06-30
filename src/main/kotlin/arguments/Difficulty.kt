package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class Difficulty(private val mcName: String) : Minecraftable {
    Peaceful("peaceful"),
    Easy("easy"),
    Normal("normal"),
    Hard("hard");

    override fun toMinecraft(): String {
        return mcName
    }
}