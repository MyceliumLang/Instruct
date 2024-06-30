package com.mycelium.commands

import com.mycelium.Minecraftable

interface Commandable : Minecraftable {
    val name: String?
}