package com.mycelium.target.argument

import com.mycelium.Minecraftable
import com.mycelium.target.Selector

class SelectorArgument<T>(private val owner: Selector, private val argument: String) : Minecraftable {
    private var value: T? = null

    operator fun plusAssign(value: T) {
        this.value = value
    }

    override fun toMinecraft(): String {
        if(value == null) return ""
        return "$argument=${if(value is Minecraftable) (value as Minecraftable).toMinecraft() else value.toString()}"
    }
}