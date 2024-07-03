package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class BossbarOverride(private val mcName: String) : Minecraftable {
    Max("max"),
    Value("value");

    override fun toMinecraft() = mcName
}