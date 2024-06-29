package com.mycelium.arguments

import com.mycelium.Minecraftable

class Opposable<T>(val name: T) : Minecraftable {
    private var oppose: Boolean = false

    fun oppose(): Opposable<T> {
        this.oppose = !this.oppose
        return this
    }

    override fun toMinecraft(): String {
        if(name == null) return if(oppose) "!" else ""

        return "${if(oppose) "!" else ""}${if(name is Minecraftable) name.toMinecraft() else name.toString()}"
    }
}