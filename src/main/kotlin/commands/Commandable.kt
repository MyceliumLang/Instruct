package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable

interface Commandable : Minecraftable {
    val name: String?
}