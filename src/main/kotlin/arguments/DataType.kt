package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class DataType(private val mcName: String) : Minecraftable {
    Byte("byte"),
    Short("short"),
    Int("int"),
    Long("long"),
    Float("float"),
    Double("double");

    override fun toMinecraft() = mcName
}