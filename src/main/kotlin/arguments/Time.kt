package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class Time(private val mcName: String) : Minecraftable {
    Day("day"),
    Night("night"),
    Noon("noon"),
    Midnight("midnight");

    override fun toMinecraft(): String {
        return mcName
    }
}