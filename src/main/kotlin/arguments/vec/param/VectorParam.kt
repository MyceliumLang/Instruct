package com.mycelium.arguments.vec.param

import com.mycelium.Minecraftable

open class VectorParam<T>(val x: T) : Minecraftable {
    override fun toMinecraft(): String {
        return x.toString()
    }
}