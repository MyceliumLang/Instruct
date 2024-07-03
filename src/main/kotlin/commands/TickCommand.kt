package io.github.myceliumlang.commands

class TickCommand : BaseCommand("tick") {
    fun query(): CommandEnd {
        return CommandEnd(this, "query")
    }

    fun rate(rate: Float): CommandEnd {
        return CommandEnd(this, "rate", rate.toString())
    }

    fun freeze(): CommandEnd {
        return CommandEnd(this, "freeze")
    }

    fun unfreeze(): CommandEnd {
        return CommandEnd(this, "unfreeze")
    }

    fun step(): CommandEnd {
        return CommandEnd(this, "step")
    }

    fun step(time: Float): CommandEnd {
        return CommandEnd(this, "step", time.toString())
    }

    fun stepStop() : CommandEnd {
        return CommandEnd(this, "step", "stop")
    }

    fun sprint(time: Float): CommandEnd {
        return CommandEnd(this, "sprint", time.toString())
    }

    fun sprintStop(): CommandEnd {
        return CommandEnd(this, "sprint", "stop")
    }
}