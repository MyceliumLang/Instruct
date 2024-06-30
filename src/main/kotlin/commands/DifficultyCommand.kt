package com.mycelium.commands

import com.mycelium.arguments.Difficulty

class DifficultyCommand(private val difficulty: Difficulty) : BaseCommand("difficulty") {
    override fun toMinecraft(): String {
        addArgument(difficulty.toMinecraft())

        return super.toMinecraft()
    }
}