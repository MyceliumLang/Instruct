package com.mycelium.target

import com.mycelium.Minecraftable

class Selector(private val type: Type) : Minecraftable {
    enum class Type(val char: Char) {
        Self('s'),
        NearestPlayer('p'),
        RandomPlayer('r'),
        AllPlayers('a'),
        AllEntities('e'),
        NearestEntity('n')
    }

    override fun toMinecraft(): String {
        return "@${type.char}"
    }
}