package com.mycelium.arguments

import com.mycelium.Minecraftable

class Score(private val objective: String, private val value: Range<Int>) : Minecraftable {
    override fun toMinecraft(): String {
        return "$objective=$value"
    }
}