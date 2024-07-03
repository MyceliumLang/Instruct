package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class WeatherType(private val mcName: String) : Minecraftable {
    Clear("clear"),
    Rain("rain"),
    Thunder("thunder");

    override fun toMinecraft(): String {
        return mcName
    }
}