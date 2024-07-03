package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.Difficulty

class DifficultyCommand(private val difficulty: Difficulty) : BaseCommand("difficulty") {
    override fun toMinecraft(): String {
        addArgument(difficulty.toMinecraft())

        return super.toMinecraft()
    }
}