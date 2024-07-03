package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable

enum class DatapackPriority(private val mcName: String) : Minecraftable {
    First("first"),
    Last("last");

    override fun toMinecraft(): String {
        return mcName
    }
}

enum class RelativeDatapackPriority(private val mcName: String) : Minecraftable {
    Before("before"),
    After("after");

    override fun toMinecraft(): String {
        return mcName
    }
}

enum class DatapackType(private val mcName: String) : Minecraftable {
    Available("available"),
    Enabled("enabled");

    override fun toMinecraft(): String {
        return mcName
    }
}

class DatapackCommand : BaseCommand("datapack") {
    fun disable(name: String): CommandEnd {
        return CommandEnd(this, "disable", name)
    }

    fun enable(name: String): CommandEnd {
        return CommandEnd(this, "enable", name)
    }

    fun enable(name: String, priority: DatapackPriority): CommandEnd {
        return CommandEnd(this, "enable", name, priority.toMinecraft())
    }

    fun enable(name: String, relativePriority: RelativeDatapackPriority, existing: String): CommandEnd {
        return CommandEnd(this, "enable", name, relativePriority.toMinecraft(), existing)
    }

    fun list(type: DatapackType): CommandEnd {
        return CommandEnd(this, "list", type.toMinecraft())
    }
}