package com.mycelium.commands

import com.mycelium.Minecraftable
import com.mycelium.arguments.vec.Vector3
import com.mycelium.target.TargetSelector

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

class PlaysoundCommand(private val sound: String) : BaseCommand("playsound") {
    private var source: SoundSource? = null;
    private var target: TargetSelector? = null;
    private var pos: Vector3<Double>? = null;
    private var volume: Float? = null;
    private var pitch: Float? = null;
    private var minVolume: Float? = null;

    fun source(source: SoundSource): PlaysoundCommand {
        this.source = source
        return this
    }

    fun target(target: TargetSelector): PlaysoundCommand {
        this.target = target
        return this
    }

    fun pos(pos: Vector3<Double>): PlaysoundCommand {
        this.pos = pos
        return this
    }
    fun volume(volume: Float): PlaysoundCommand {
        this.volume = volume
        return this
    }
    fun pitch(pitch: Float): PlaysoundCommand {
        this.pitch = pitch
        return this
    }
    fun minVolume(minVolume: Float): PlaysoundCommand {
        this.minVolume = minVolume
        return this
    }

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