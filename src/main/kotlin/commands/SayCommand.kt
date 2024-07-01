package com.mycelium.commands

class SayCommand(private val message: String) : BaseCommand("say") {
    override fun toMinecraft(): String {
        addArgument(message)
        return super.toMinecraft()
    }
}