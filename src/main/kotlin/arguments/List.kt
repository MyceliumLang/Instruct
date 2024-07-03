package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

class List<T : Minecraftable> : Minecraftable {
    private val scores: MutableList<T> = mutableListOf()

    operator fun plusAssign(value: Any) {
        @Suppress("UNCHECKED_CAST")
        scores.add(value as T)
    }

    operator fun plusAssign(value: T) {
        scores.add(value)
    }

    override fun toMinecraft(): String {
        return "{${scores.joinToString(",") { c -> c.toMinecraft() }}}}"
    }
}