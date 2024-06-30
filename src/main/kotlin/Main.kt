package com.mycelium

import com.mycelium.arguments.EntityType
import com.mycelium.arguments.Range
import com.mycelium.commands.DataCommand
import com.mycelium.target.Selector

fun main() {
    val allCreepersWithinABlock = Selector.AllEntities.new()
    allCreepersWithinABlock.distance += Range(0.0, 1.0)
    allCreepersWithinABlock.type += EntityType.Creeper
    allCreepersWithinABlock.limit += 10

//    println(KillCommand(allCreepersWithinABlock.target()).toMinecraft())
//    println(ScoreboardCommand().objectives.add("registers", Criteria.Dummy).toMinecraft())
//    println(ScoreboardCommand().objectives.modify("registers").displayName(JsonTextComponent.Builder().text("Registers").build()).toMinecraft())

    println(DataCommand().get.storage("example:__globals__0")("variables.b", 0.1).toMinecraft())
}