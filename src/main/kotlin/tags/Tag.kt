package com.mycelium.tags

import com.mycelium.Minecraftable

class Tag(private val location: String) : Minecraftable {
    override fun toMinecraft(): String {
        return "#$location"
    }
}