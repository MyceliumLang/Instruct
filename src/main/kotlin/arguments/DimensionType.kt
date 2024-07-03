package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class DimensionType(private val mcName: String) : Minecraftable {
    Overworld("minecraft:overworld"),
    Nether("minecraft:the_nether"),
    End("minecraft:the_end");

    override fun toMinecraft() = mcName
}