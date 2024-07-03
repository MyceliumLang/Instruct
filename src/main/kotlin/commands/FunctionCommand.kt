package io.github.myceliumlang.commands

import io.github.myceliumlang.arguments.vec.Vector3
import io.github.myceliumlang.nbt.NBT
import io.github.myceliumlang.target.TargetSelector

class FunctionCommand(private val funcName: String, private val arguments: NBT?=null) : BaseCommand("function") {
    class FunctionWith(private val cmd: FunctionCommand) {
        fun block(sourcePos: Vector3<Int>, path: String?=null): FunctionCommand {
            cmd.addArgument("with")
            cmd.addArgument("block")
            cmd.addArgument(sourcePos)
            if(path != null) cmd.addArgument(path)
            return cmd
        }

        fun entity(source: TargetSelector, path: String?=null): FunctionCommand {
            cmd.addArgument("with")
            cmd.addArgument("entity")
            cmd.addArgument(source)
            if(path != null) cmd.addArgument(path)
            return cmd
        }

        fun storage(source: String, path: String?=null): FunctionCommand {
            cmd.addArgument("with")
            cmd.addArgument("storage")
            cmd.addArgument(source)
            if(path != null) cmd.addArgument(path)
            return cmd
        }
    }

    val with = FunctionWith(this)

    override fun toMinecraft(): String {
        addArgument(funcName)
        if(arguments != null) addArgument(arguments)

        return super.toMinecraft()
    }
}