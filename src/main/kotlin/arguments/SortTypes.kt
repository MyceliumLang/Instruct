package com.mycelium.arguments

import com.mycelium.Minecraftable

enum class SortTypes(name: String) : Minecraftable {
    Nearest("nearest"),
    Furthest("furthest"),
    Random("random"),
    Arbitrary("arbitrary");

    override fun toMinecraft(): String {
        return name
    }
}