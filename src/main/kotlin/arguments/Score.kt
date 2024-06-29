package com.mycelium.arguments

import com.mycelium.Minecraftable

class ScoreList : Minecraftable {
    private val scores: MutableList<Score> = mutableListOf()

    operator fun plusAssign(value: Score) {
        scores.add(value)
    }

    override fun toMinecraft(): String {
        return "{${scores.joinToString(",") { score -> score.toMinecraft() }}}}"
    }
}

class Score(private val objective: String, private val value: Range<Int>) : Minecraftable {
    override fun toMinecraft(): String {
        return "$objective=$value"
    }
}