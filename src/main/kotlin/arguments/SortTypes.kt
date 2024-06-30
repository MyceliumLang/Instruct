package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class SortTypes(private val mcName: String) : Minecraftable {
    Nearest("nearest"),
    Furthest("furthest"),
    Random("random"),
    Arbitrary("arbitrary");

    override fun toMinecraft(): String {
        return mcName
    }
}