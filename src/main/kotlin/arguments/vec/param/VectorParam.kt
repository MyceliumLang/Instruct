package io.github.myceliumlang.arguments.vec.param

import io.github.myceliumlang.Minecraftable

open class VectorParam<T>(val x: T) : Minecraftable {
    override fun toMinecraft(): String {
        return x.toString()
    }
}