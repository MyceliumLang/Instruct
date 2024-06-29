package com.mycelium.target

import com.mycelium.Minecraftable
import com.mycelium.arguments.Opposable
import com.mycelium.arguments.Range
import com.mycelium.arguments.ScoreList
import com.mycelium.EntityType
import com.mycelium.Gamemode
import com.mycelium.arguments.SortTypes
import com.mycelium.target.argument.SelectorArgument

class Selector(private val selectorType: Type) : Minecraftable {
    enum class Type(val char: Char) {
        Self('s'),
        NearestPlayer('p'),
        RandomPlayer('r'),
        AllPlayers('a'),
        AllEntities('e'),
        NearestEntity('n')
    }

    // Spatial Properties
    val x: SelectorArgument<Double> = SelectorArgument(this, "x")
    val y: SelectorArgument<Double> = SelectorArgument(this, "y")
    val z: SelectorArgument<Double> = SelectorArgument(this, "z")

    val distance: SelectorArgument<Range<Double>> = SelectorArgument(this, "distance")

    val dx: SelectorArgument<Double> = SelectorArgument(this, "dx")
    val dy: SelectorArgument<Double> = SelectorArgument(this, "dy")
    val dz: SelectorArgument<Double> = SelectorArgument(this, "dz")

    val xRotation: SelectorArgument<Double> = SelectorArgument(this, "x_rotation")
    val yRotation: SelectorArgument<Double> = SelectorArgument(this, "y_rotation")

    // Scoreboard Values

    val scores: SelectorArgument<ScoreList> = SelectorArgument(this, "scores")
    val tag: SelectorArgument<Opposable<String?>> = SelectorArgument(this, "tag")
    val team: SelectorArgument<Opposable<String?>> = SelectorArgument(this, "team")

    // Entity Species

    val name: SelectorArgument<String> = SelectorArgument(this, "name")
    val type: SelectorArgument<Opposable<EntityType>> = SelectorArgument(this, "type")
    val predicate: SelectorArgument<String> = SelectorArgument(this, "predicate")

    // Entity Data

    val nbt: SelectorArgument<> = SelectorArgument(this, "nbt")

    // Player Data

    val level: SelectorArgument<Range<Int>> = SelectorArgument(this, "level")
    val gamemode: SelectorArgument<Opposable<Gamemode>> = SelectorArgument(this, "gamemode")
    val advancements: SelectorArgument<Advancement> = SelectorArgument(this, "advancements")

    // Traits

    val limit: SelectorArgument<Int> = SelectorArgument(this, "limit")
    val sort: SelectorArgument<SortTypes> = SelectorArgument(this, "limit")

    override fun toMinecraft(): String {
        return "@${selectorType.char}"
    }
}