package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class BlockScanMode(private val mcName: String) : Minecraftable {
    All("all"),
    Masked("masked");

    override fun toMinecraft() = mcName
}