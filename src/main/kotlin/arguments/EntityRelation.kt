package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class EntityRelation(private val mcName: String) : Minecraftable {
    Attacker("attacker"),
    Controller("controller"),
    Leasher("leasher"),
    Origin("origin"),
    Owner("owner"),
    Passengers("passengers"),
    Target("target"),
    Vehicle("vehicle");

    override fun toMinecraft() = mcName
}