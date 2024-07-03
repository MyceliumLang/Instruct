package io.github.myceliumlang.target

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.arguments.List
import io.github.myceliumlang.arguments.Opposable

class SelectorArgument<T>(owner: Selector, private val argument: String) : Minecraftable {
    var value: T? = null

    init {
        owner.addArgument(this)
    }

    fun getSelectorValue(): T? {
        return value
    }

    operator fun <V> plusAssign(value: V) {
        @Suppress("UNCHECKED_CAST")
        this.value = value as T

        // Custom operations on +=
        when(this.value!!::class) {
            Opposable::class -> {
                @Suppress("UNCHECKED_CAST")
                this.value = Opposable(value) as T
            }
            List::class -> {
                (this.value as List<*>) += value as Any
            }
        }
    }

    override fun toMinecraft(): String {
        if(value == null) return ""
        return "$argument=${if(value is Minecraftable) (value as Minecraftable).toMinecraft() else value.toString()}"
    }
}