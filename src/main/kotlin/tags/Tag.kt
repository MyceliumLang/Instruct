package io.github.myceliumlang.tags

import io.github.myceliumlang.Minecraftable

class Tag(private val location: String) : Minecraftable {
    override fun toMinecraft(): String {
        return "#$location"
    }
}