package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class WeatherType(private val mcName: String) : Minecraftable {
    Clear("clear"),
    Rain("rain"),
    Thunder("thunder");

    override fun toMinecraft(): String {
        return mcName
    }
}