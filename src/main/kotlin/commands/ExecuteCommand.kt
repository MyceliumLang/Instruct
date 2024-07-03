package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.*
import io.github.myceliumlang.arguments.vec.Vector2
import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.target.TargetSelector

class ExecuteFacing(private val execute: ExecuteCommand) {
    operator fun invoke(position: Vector3<Double>): ExecuteCommand {
        execute.addArgument("facing")
        execute.addArgument(position)
        return execute
    }

    fun entity(target: TargetSelector, anchor: EntityAnchor): ExecuteCommand {
        execute.addArgument("facing")
        execute.addArgument("entity")
        execute.addArgument(target)
        execute.addArgument(anchor)
        return execute
    }
}

class ExecuteRotated(private val execute: ExecuteCommand) {
    operator fun invoke(rot: Vector2<Double>): ExecuteCommand {
        execute.addArgument("rotated")
        execute.addArgument(rot)
        return execute
    }

    fun rotatedAs(target: TargetSelector): ExecuteCommand {
        execute.addArgument("rotated")
        execute.addArgument("as")
        execute.addArgument(target)
        return execute
    }
}

class ExecutePositioned(private val execute: ExecuteCommand) {
    operator fun invoke(pos: Vector3<Double>): ExecuteCommand {
        execute.addArgument("positioned")
        execute.addArgument(pos)
        return execute
    }

    fun _as(target: TargetSelector): ExecuteCommand {
        execute.addArgument("positioned")
        execute.addArgument(target)
        return execute
    }

    fun over(heightmap: Heightmap): ExecuteCommand {
        execute.addArgument("positioned")
        execute.addArgument(heightmap)
        return execute
    }
}

class ExecuteStore(private val execute: ExecuteCommand) {
    class Subcommand(private val execute: ExecuteCommand, private val name: String) {
        fun block(targetPosition: Vector3<Int>, path: String, type: DataType, scale: Double): ExecuteCommand {
            execute.addArgument("store")
            execute.addArgument(name)
            execute.addArgument(targetPosition)
            execute.addArgument(path)
            execute.addArgument(type)
            execute.addArgument(scale.toString())
            return execute
        }

        fun bossbar(id: String, override: BossbarOverride): ExecuteCommand {
            execute.addArgument("store")
            execute.addArgument(name)
            execute.addArgument(id)
            execute.addArgument(override)
            return execute
        }

        fun entity(target: TargetSelector, path: String, type: DataType, scale: Double): ExecuteCommand {
            execute.addArgument("store")
            execute.addArgument(name)
            execute.addArgument(target)
            execute.addArgument(path)
            execute.addArgument(type)
            execute.addArgument(scale.toString())
            return execute
        }

        fun score(target: TargetSelector, objective: String): ExecuteCommand {
            execute.addArgument("store")
            execute.addArgument(name)
            execute.addArgument(target)
            execute.addArgument(objective)
            return execute
        }

        fun storage(target: String, path: String, type: DataType, scale: Double): ExecuteCommand {
            execute.addArgument(type)
            execute.addArgument("store")
            execute.addArgument(name)
            execute.addArgument(target)
            execute.addArgument(path)
            execute.addArgument(type)
            execute.addArgument(scale.toString())
            return execute
        }
    }

    val result = Subcommand(execute, "result")
    val success = Subcommand(execute, "success")
}

class ExecuteCondition(private val execute: ExecuteCommand, private val name: String) {
    class ExecuteConditionItems(private val name: String, private val execute: ExecuteCommand) {
        fun block(sourcePos: Vector3<Int>, slots: String, itemPredicate: String): ExecuteCommand {
            execute.addArgument(name)
            execute.addArgument("items")
            execute.addArgument("block")
            execute.addArgument(sourcePos)
            execute.addArgument(slots)
            execute.addArgument(itemPredicate)
            return execute
        }

        fun entity(source: TargetSelector, slots: String, itemPredicate: String): ExecuteCommand {
            execute.addArgument(name)
            execute.addArgument("items")
            execute.addArgument("entity")
            execute.addArgument(source)
            execute.addArgument(slots)
            execute.addArgument(itemPredicate)
            return execute
        }
    }

    class ExecuteConditionData(private val name: String, private val execute: ExecuteCommand) {
        fun block(pos: Vector3<Int>, path: String): ExecuteCommand {
            execute.addArgument(name)
            execute.addArgument("data")
            execute.addArgument("block")
            execute.addArgument(pos)
            execute.addArgument(path)
            return execute
        }

        fun entity(target: TargetSelector, path: String): ExecuteCommand {
            execute.addArgument(name)
            execute.addArgument("data")
            execute.addArgument("entity")
            execute.addArgument(target)
            execute.addArgument(path)
            return execute
        }

        fun storage(source: String, path: String): ExecuteCommand {
            execute.addArgument(name)
            execute.addArgument("data")
            execute.addArgument("storage")
            execute.addArgument(source)
            execute.addArgument(path)
            return execute
        }
    }

    val items = ExecuteConditionItems(name, execute)
    val data = ExecuteConditionData(name, execute)

    // TODO: Make Resource or Tag type to replace the string type for biome.
    fun biome(pos: Vector3<Int>, biome: String): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("biome")
        execute.addArgument(pos)
        execute.addArgument(biome)
        return execute
    }

    // TODO: Make Block predicate.
    fun block(pos: Vector3<Int>, block: String): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("block")
        execute.addArgument(pos)
        execute.addArgument(block)
        return execute
    }

    fun blocks(start: Vector3<Int>, end: Vector3<Int>, destination: Vector3<Int>, scanMode: BlockScanMode): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("blocks")
        execute.addArgument(start)
        execute.addArgument(end)
        execute.addArgument(destination)
        execute.addArgument(scanMode)
        return execute
    }

    fun dimension(dimension: DimensionType): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("dimension")
        execute.addArgument(dimension)
        return execute
    }

    fun entity(entities: TargetSelector): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("entity")
        execute.addArgument(entities)
        return execute
    }

    fun function(function: String): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("function")
        execute.addArgument(function)
        return execute
    }

    fun loaded(pos: Vector3<Int>): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("loaded")
        execute.addArgument(pos)
        return execute
    }

    fun predicate(predicate: String): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("predicate")
        execute.addArgument(predicate)
        return execute
    }

    fun score(target: TargetSelector, targetObjective: String, operation: ScoreboardCompareOperation, source: TargetSelector, sourceObjective: String): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("score")
        execute.addArgument(target)
        execute.addArgument(targetObjective)
        execute.addArgument(operation)
        execute.addArgument(source)
        execute.addArgument(sourceObjective)
        return execute
    }

    fun scoreMatches(target: TargetSelector, targetObjective: String, range: Range<Int>): ExecuteCommand {
        execute.addArgument(name)
        execute.addArgument("score")
        execute.addArgument(target)
        execute.addArgument(targetObjective)
        execute.addArgument("matches")
        execute.addArgument(range)
        return execute
    }
}

class ExecuteCommand : BaseCommand("execute") {
    val facing = ExecuteFacing(this)
    val rotated = ExecuteRotated(this)
    val positioned = ExecutePositioned(this)

    val store = ExecuteStore(this)
    val _if = ExecuteCondition(this, "if")
    val unless = ExecuteCondition(this, "unless")

    fun _as(target: TargetSelector): ExecuteCommand {
        addArgument("as")
        addArgument(target)
        return this
    }

    fun at(target: TargetSelector): ExecuteCommand {
        addArgument("at")
        addArgument(target)
        return this
    }

    fun _in(dimension: DimensionType): ExecuteCommand {
        addArgument("in")
        addArgument(dimension)
        return this
    }

    fun on(relation: EntityRelation): ExecuteCommand {
        addArgument("on")
        addArgument(relation)
        return this
    }

    fun summon(entity: EntityType): ExecuteCommand {
        addArgument("summon")
        addArgument(entity)
        return this
    }

    fun anchored(anchor: EntityAnchor): ExecuteCommand {
        addArgument("anchored")
        addArgument(anchor)
        return this
    }

    fun align(text: String): ExecuteCommand {
        Swizzle.xyz.verify(text)

        addArgument("align")
        addArgument(text)
        return this
    }

    fun run(command: Commandable): CommandEnd {
        return CommandEnd(this, "run", command.toMinecraft())
    }

    fun run(command: CommandEnd): CommandEnd {
        return CommandEnd(this, "run", command.toMinecraft())
    }
}