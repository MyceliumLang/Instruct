package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

class Range<T>(private val min: T?=null, private val max: T?=null) : Minecraftable {
    companion object {
        fun <T> from(min: T, max: T): Range<T> {
            return Range(min, max)
        }

        fun <T> exact(value: T): Range<T> {
            return Range(value, value)
        }
    }

    override fun toMinecraft(): String {
        if(min == null && max == null) throw Exception("Missing a min value or a max value.")
        if(min == max) return "$min"
        return "${min ?: ""}..${max ?: ""}"
    }
}