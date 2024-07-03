package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class EntityAnchor(private val mcName: String) : Minecraftable {
    Eyes("eyes"),
    Feet("feet");

    override fun toMinecraft() = mcName
}