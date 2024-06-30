package com.mycelium.commands

import com.mycelium.arguments.vec.Vector3
import com.mycelium.nbt.NBT
import com.mycelium.target.TargetSelector

interface DataTarget<out T> {
    fun block(targetPosition: Vector3<Int>): T
    fun entity(target: TargetSelector): T
    fun storage(source: String): T
}

interface DataModification<out T> {
    fun append(): T
    fun insert(index: Int): T
    fun merge(): T
    fun prepend(): T
    fun set(): T
}

interface DataSource<out T> {
    fun block(sourcePosition: Vector3<Int>): T
    fun entity(source: TargetSelector): T
    fun storage(source: String): T
}

class DataSubcommand<T>(parent: DataCommand, name: String, private val command: Class<T>) : SubCommand(parent, name), DataTarget<T> {
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

class DataModify(parent: DataSubcommand<DataModify>) : SubCommand(parent) {
    
}

class DataRemove(parent: DataSubcommand<DataRemove>) : SubCommand(parent) {
    operator fun invoke(path: String): CommandEnd {
        return CommandEnd(this, path)
    }
}

class DataCommand : BaseCommand("data") {
    val get = DataSubcommand(this, "get", DataGet::class.java)
    val merge = DataSubcommand(this, "merge", DataMerge::class.java)
    val modify = DataSubcommand(this, "modify", DataModify::class.java)
    val remove = DataSubcommand(this, "remove", DataRemove::class.java)
}