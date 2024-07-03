package io.github.myceliumlang

import io.github.myceliumlang.arguments.EntityType
import io.github.myceliumlang.arguments.Range
import io.github.myceliumlang.commands.*
import io.github.myceliumlang.target.Selector
import io.github.myceliumlang.target.TargetSelector

fun main() {
    val allCreepersWithinABlock = Selector.AllEntities.new()
    allCreepersWithinABlock.distance += Range(0.0, 1.0)
    allCreepersWithinABlock.type += EntityType.Creeper
    allCreepersWithinABlock.limit += 10

    println(ExecuteCommand()._if.score(TargetSelector("#reg1"), "registers", ScoreboardCompareOperation.Equal, TargetSelector("#reg2"), "registers").run(
        ReturnCommand().run(FunctionCommand("example:if0"))
    ).toMinecraft())
}