package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class SortTypes(private val mcName: String) : Minecraftable {
    Nearest("nearest"),
    Furthest("furthest"),
    Random("random"),
    Arbitrary("arbitrary");

    override fun toMinecraft(): String {
        return mcName
    }
}