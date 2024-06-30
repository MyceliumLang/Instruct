package com.mycelium.commands

import com.mycelium.arguments.vec.Vector3
import com.mycelium.target.TargetSelector

class TeleportCommand {
    constructor(destination: TargetSelector) {}
    constructor(target: TargetSelector, destination: TargetSelector) {}
    constructor(location: Vector3<Double>) {}
    constructor(target: TargetSelector, location: Vector3<Double>) {}
    constructor(target: TargetSelector, location: Vector3<Double>, rotation: Vector3<Double>) {}
    
}