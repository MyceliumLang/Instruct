package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.target.TargetSelector

enum class SoundSource(private val mcName: String) : Minecraftable {
    Master("master"),
    Music("music"),
    Record("record"),
    Weather("weather"),
    Block("block"),
    Hostile("hostile"),
    Neutral("neutral"),
    Player("player"),
    Ambient("ambient"),
    Voice("voice");

    override fun toMinecraft(): String {
        return mcName
    }
}

class PlaysoundCommand(private val sound: String, private val source: SoundSource? = null, private val target: TargetSelector? = null, private val pos: Vector3<Double>? = null,
                       private val volume: Float? = null, private val pitch: Float? = null, private val minVolume: Float? = null) : BaseCommand("playsound") {

    override fun toMinecraft(): String {
        addArgument(sound)
        source?.toMinecraft()?.let{ addArgument(it) }
        target?.toMinecraft()?.let{ addArgument(it) }
        pos?.toMinecraft()?.let{ addArgument(it) }
        volume?.toString()?.let{ addArgument(it) }
        pitch?.toString()?.let{ addArgument(it) }
        minVolume?.toString()?.let{ addArgument(it) }

        return super.toMinecraft()
    }
}