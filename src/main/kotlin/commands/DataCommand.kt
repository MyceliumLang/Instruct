package io.github.myceliumlang.commands

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.nbt.NBT
import io.github.myceliumlang.target.TargetSelector

interface DataTarget<out T> {
    fun block(targetPosition: Vector3<Int>): T
    fun entity(target: TargetSelector): T
    fun storage(source: String): T
}

class DataSubcommandEnd(parent: DataSubcommand<*>) : CommandEnd(parent)
class DataSubcommand<T>(parent: Commandable, name: String, private val command: Class<T>) : SubCommand(parent, name), DataTarget<T> {
    override fun block(targetPosition: Vector3<Int>): T {
        addArgument("block")
        addArgument(targetPosition)
        return command.getConstructor(DataSubcommand::class.java).newInstance(this)
    }

    override fun entity(target: TargetSelector): T {
        addArgument("entity")
        addArgument(target)
        return command.getConstructor(DataSubcommand::class.java).newInstance(this)
    }

    override fun storage(source: String): T {
        addArgument("storage")
        addArgument(source)
        return command.getConstructor(DataSubcommand::class.java).newInstance(this)
    }
}

class DataGet(parent: DataSubcommand<DataGet>) : SubCommand(parent) {
    operator fun invoke(): CommandEnd {
        return CommandEnd(this)
    }

    operator fun invoke(path: String): CommandEnd {
        return CommandEnd(this, path)
    }

    operator fun invoke(path: String, scale: Double): CommandEnd {
        return CommandEnd(this, path, scale.toString())
    }
}

class DataMerge(parent: DataSubcommand<DataMerge>) : SubCommand(parent) {
    operator fun invoke(nbt: NBT): CommandEnd {
        return CommandEnd(this, nbt.toMinecraft())
    }
}

class DataRemove(parent: DataSubcommand<DataRemove>) : SubCommand(parent) {
    operator fun invoke(path: String): CommandEnd {
        return CommandEnd(this, path)
    }
}

class DataModify(parent: DataSubcommand<DataModify>) : SubCommand(parent) {
    operator fun invoke(targetPath: String): DataModifyModification {
        addArgument(targetPath)
        return DataModifyModification(this)
    }
}

class DataModifyModification(parent: DataModify) : SubCommand(parent) {
    val append: DataModifyLocation
        get() = DataModifyLocation(this, "append")
    val merge: DataModifyLocation
        get() = DataModifyLocation(this, "merge")
    val prepend: DataModifyLocation
        get() = DataModifyLocation(this, "prepend")
    val set: DataModifyLocation
        get() = DataModifyLocation(this, "set")

    fun insert(index: Int) = DataModifyLocation(this, "insert", "$index")
}

class DataModifyLocation(parent: DataModifyModification, name: String, vararg arguments: String) : SubCommand(parent, name) {
    init {
        for(argument in arguments)
            addArgument(argument)
    }

    val from: DataSubcommand<DataModifyFrom>
        get() = DataSubcommand(this, "from", DataModifyFrom::class.java)
    val string: DataSubcommand<DataModifyString>
        get() = DataSubcommand(this, "string", DataModifyString::class.java)

    fun value(value: Any): CommandEnd {
        return CommandEnd(this, "$value")
    }
}

class DataModifyString(parent: DataSubcommand<DataModifyString>) : SubCommand(parent) {
    operator fun invoke(): CommandEnd {
        return CommandEnd(this)
    }

    operator fun invoke(targetPath: String): CommandEnd {
        return CommandEnd(this, targetPath)
    }

    operator fun invoke(targetPath: String, start: Int): CommandEnd {
        return CommandEnd(this, targetPath, "$start")
    }

    operator fun invoke(targetPath: String, start: Int, end: Int): CommandEnd {
        return CommandEnd(this, targetPath, "$start", "$end")
    }
}

class DataModifyFrom(parent: DataSubcommand<DataModifyFrom>) : SubCommand(parent) {
    operator fun invoke(): CommandEnd {
        return CommandEnd(this)
    }

    operator fun invoke(sourcePath: String): CommandEnd {
        return CommandEnd(this, sourcePath)
    }
}


class DataCommand : BaseCommand("data") {
    val get = DataSubcommand(this, "get", DataGet::class.java)
    val merge = DataSubcommand(this, "merge", DataMerge::class.java)
    val modify = DataSubcommand(this, "modify", DataModify::class.java)
    val remove = DataSubcommand(this, "remove", DataRemove::class.java)
}