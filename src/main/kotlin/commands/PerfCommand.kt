package com.mycelium.commands

class PerfCommand : BaseCommand("perf") {
    fun start(): CommandEnd {
        return CommandEnd(this, "start")
    }

    fun stop(): CommandEnd {
        return CommandEnd(this, "stop")
    }
}