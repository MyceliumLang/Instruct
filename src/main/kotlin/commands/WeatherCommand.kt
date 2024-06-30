package com.mycelium.commands

import com.mycelium.arguments.WeatherType

class WeatherCommand(private val type: WeatherType, private val duration: Float? = null) : BaseCommand("weather") {
    override fun toMinecraft(): String {
        addArgument(type.toMinecraft())
        if (duration != null) addArgument(duration.toString())

        return super.toMinecraft()
    }
}
