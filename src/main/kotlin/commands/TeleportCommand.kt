package com.mycelium.commands

import com.mycelium.arguments.Vector3
import com.mycelium.target.TargetSelector

class TeleportCommand {
    constructor(destination: TargetSelector) {};
    constructor(target: TargetSelector, destination: TargetSelector) {};
    constructor(location: Vector3) {};
    constructor(target: TargetSelector, location: Vector3) {};
    constructor(target: TargetSelector, location: Vector3, rotation: Vector3) {};
    
}