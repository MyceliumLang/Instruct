package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.target.TargetSelector

class SpawnpointCommand(private var target: TargetSelector? = null, private var pos: Vector3<Int>? = null, private var angle: Vector3<Float>? = null) : BaseCommand("spawnpoint") {
    override fun toMinecraft(): String {
        target?.toMinecraft()?.let{ addArgument(it) }
        pos?.toMinecraft()?.let{ addArgument(it) }
        angle?.toMinecraft()?.let{ addArgument(it) }

        return super.toMinecraft()
    }
}