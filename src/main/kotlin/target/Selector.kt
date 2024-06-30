package com.mycelium.target

import com.mycelium.Minecraftable
import com.mycelium.arguments.EntityType
import com.mycelium.arguments.Gamemode
import com.mycelium.arguments.*
import com.mycelium.arguments.List
import com.mycelium.nbt.NBT

class Selector(private val selectorType: Type) : Minecraftable {
    enum class Type(val char: Char) {
        Self('s'),
        NearestPlayer('p'),
        RandomPlayer('r'),
        AllPlayers('a'),
        AllEntities('e'),
        NearestEntity('n');

        fun isPlayer(): Boolean {
            return char == 's' || char == 'p' || char == 'a'
        }
    }

    companion object {
        val Self = Selector(Selector.Type.Self)
        val NearestPlayer = Selector(Selector.Type.NearestPlayer)
        val RandomPlayer = Selector(Selector.Type.RandomPlayer)
        val AllPlayers = Selector(Selector.Type.AllPlayers)
        val AllEntities = Selector(Selector.Type.AllEntities)
        val NearestEntity = Selector(Selector.Type.NearestEntity)
    }

    private val arguments: MutableList<SelectorArgument<*>> = mutableListOf()

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

    val scores: SelectorArgument<List<Score>> = SelectorArgument(this, "scores")
    val tag: SelectorArgument<Opposable<String?>> = SelectorArgument(this, "tag")
    val team: SelectorArgument<Opposable<String?>> = SelectorArgument(this, "team")

    // Entity Species

    val name: SelectorArgument<String> = SelectorArgument(this, "name")
    val type: SelectorArgument<List<Opposable<EntityType>>> = SelectorArgument(this, "type")
    val predicate: SelectorArgument<String> = SelectorArgument(this, "predicate")

    // Entity Data

    val nbt: SelectorArgument<NBT> = SelectorArgument(this, "nbt")

    // Player Data

    val level: SelectorArgument<Range<Int>> = SelectorArgument(this, "level")
    val gamemode: SelectorArgument<Opposable<Gamemode>> = SelectorArgument(this, "gamemode")
    val advancements: SelectorArgument<List<Advancement>> = SelectorArgument(this, "advancements")

    // Traits

    val limit: SelectorArgument<Int> = SelectorArgument(this, "limit")
    val sort: SelectorArgument<SortTypes> = SelectorArgument(this, "sort")

    fun addArgument(selector: SelectorArgument<*>) {
        arguments.add(selector)
    }

    fun target(): TargetSelector {
        return TargetSelector(this)
    }

    fun new(): Selector {
        return Selector(selectorType)
    }

    override fun toMinecraft(): String {
        val arguments = this.arguments.filter { arg -> arg.getSelectorValue() != null }
        val argumentString: String = arguments.joinToString(",") { arg -> arg.toMinecraft() }
        return "@${selectorType.char}${if(arguments.isNotEmpty()) "[${argumentString}]" else ""}"
    }
}