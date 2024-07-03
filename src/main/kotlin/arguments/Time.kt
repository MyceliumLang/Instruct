package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class Time(private val mcName: String) : Minecraftable {
    Day("day"),
    Night("night"),
    Noon("noon"),
    Midnight("midnight");

    override fun toMinecraft(): String {
        return mcName
    }
}