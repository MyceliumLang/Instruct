package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.target.TargetSelector

class TeleportCommand {
    constructor(destination: TargetSelector) {}
    constructor(target: TargetSelector, destination: TargetSelector) {}
    constructor(location: Vector3<Double>) {}
    constructor(target: TargetSelector, location: Vector3<Double>) {}
    constructor(target: TargetSelector, location: Vector3<Double>, rotation: Vector3<Double>) {}
    
}