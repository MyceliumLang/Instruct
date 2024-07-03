package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

class Score(private val objective: String, private val value: Range<Int>) : Minecraftable {
    override fun toMinecraft(): String {
        return "$objective=$value"
    }
}