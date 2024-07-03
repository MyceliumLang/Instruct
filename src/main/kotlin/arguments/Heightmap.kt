package io.github.myceliumlang.arguments

import io.github.myceliumlang.Minecraftable

enum class Heightmap(private val mcName: String) : Minecraftable {
    WorldSurface("world_surface"),
    MotionBlocking("motion_blocking"),
    MotionBlockingNoLeaves("motion_blocking_no_leaves"),
    OceanFloor("ocean_floor");

    override fun toMinecraft() = mcName
}