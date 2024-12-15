package io.github.myceliumlang.datapack

import io.github.myceliumlang.commands.Commandable
import io.github.myceliumlang.commands.FunctionCommand

class MCFunction(val name: String, var tags: Map<Tag, Boolean>) {
    enum class Tag {
        Tick,
        Load
    }

    val members: MutableList<Commandable> = mutableListOf()

    fun compile(): String {
        val contents = StringBuilder()

        for(command in members)
            contents.append(command.toMinecraft())

        return contents.toString()
    }

    fun call(datapack: Datapack): FunctionCommand {
        return FunctionCommand("${datapack.namespace}:$name")
    }
}