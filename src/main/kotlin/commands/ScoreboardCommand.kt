package io.github.myceliumlang.commands

import io.github.myceliumlang.InstructJson
import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.components.text.JsonTextComponent
import io.github.myceliumlang.target.TargetSelector
import kotlinx.serialization.encodeToString

enum class RenderType(private val mcName: String) : Minecraftable {
    Hearts("hearts"),
    Integer("integer");

    override fun toMinecraft(): String {
        return mcName
    }
}

class ScoreboardObjectiveModify(parent: ScoreboardObjectives, private val objective: String) : SubCommand(parent, "modify") {
    init {
        addArgument(objective)
    }

    fun displayName(displayName: JsonTextComponent): Minecraftable {
        return CommandEnd(this,"displayname", InstructJson.jsonInline.encodeToString(displayName.toJson()))
    }

    fun renderType(renderType: RenderType): Minecraftable {
        return CommandEnd(this,"rendertype", renderType.toMinecraft())
    }
}

class ScoreboardObjectives(parent: ScoreboardCommand) : SubCommand(parent, "objectives") {
    fun list(): Minecraftable {
        return CommandEnd(this,"list")
    }

    fun add(objective: String, criteria: Criteria, displayName: JsonTextComponent?=null): Minecraftable {
        return CommandEnd(this,"add", objective, criteria.toMinecraft(), if(displayName == null) "\b" else InstructJson.jsonInline.encodeToString(displayName.toJson()))
    }

    fun remove(objective: String): Minecraftable {
        return CommandEnd(this,"remove", objective)
    }

    fun setDisplay(slot: DisplaySlot, objective: String): Minecraftable {
        return CommandEnd(this, "setdisplay", slot.toMinecraft(), objective)
    }

    fun modify(objective: String): ScoreboardObjectiveModify {
        return ScoreboardObjectiveModify(this, objective)
    }
}

class ScoreboardPlayers(parent: ScoreboardCommand) : SubCommand(parent, "players") {
    fun list(target: TargetSelector?=null): CommandEnd {
        return CommandEnd(this, "list", target?.toMinecraft() ?: "\b")
    }

    fun get(target: TargetSelector, objective: String): CommandEnd {
        return CommandEnd(this, "get", target.toMinecraft(), objective)
    }

    fun set(target: TargetSelector, objective: String, score: Int): CommandEnd {
        return CommandEnd(this, "set", target.toMinecraft(), objective, score.toString())
    }

    fun add(target: TargetSelector, objective: String, amount: Int): CommandEnd {
        return CommandEnd(this, "add", target.toMinecraft(), objective, amount.toString())
    }

    fun remove(target: TargetSelector, objective: String, amount: Int): CommandEnd {
        return CommandEnd(this, "remove", target.toMinecraft(), objective, amount.toString())
    }

    fun reset(target: TargetSelector, objective: String?=null): CommandEnd {
        return CommandEnd(this, "remove", target.toMinecraft(), objective ?: "\b")
    }

    fun enable(target: TargetSelector, objective: String): CommandEnd {
        return CommandEnd(this, "enable", target.toMinecraft(), objective)
    }

    fun operation(target: TargetSelector, objective: String, operation: ScoreboardOperation, source: TargetSelector, sourceObjective: String): CommandEnd {
        return CommandEnd(this, "operation", target.toMinecraft(), objective, operation.toMinecraft(), source.toMinecraft(), sourceObjective)
    }
}

enum class ScoreboardCompareOperation(private val mcName: String) : Minecraftable {
    Less("<"),
    LessEqual("<="),
    Equal("="),
    Greater(">"),
    GreaterEqual(">=");

    override fun toMinecraft(): String {
        return mcName
    }
}

enum class ScoreboardOperation(private val mcName: String) : Minecraftable {
    Addition("+="),
    Subtraction("-="),
    Multiplication("*="),
    Division("/="),
    Modulus("%="),
    Assign("="),
    Min("<"),
    Max(">"),
    Swap("><");

    override fun toMinecraft(): String {
        return mcName
    }
}

enum class Criteria(private val mcName: String) : Minecraftable {
    Dummy("dummy"),
    Trigger("trigger"),
    DeathCount("deathCount"),
    PlayerKillCount("playerKillCount"),
    TotalKillCount("totalKillCount"),
    Health("health"),
    Xp("xp"),
    Experience("xp"),
    Level("level"),
    Food("food"),
    Air("air"),
    Armor("armor");

    override fun toMinecraft(): String {
        return mcName
    }
}

enum class DisplaySlot(private val mcName: String) : Minecraftable {
    List("list"),
    Sidebar("sidebar"),
    SidebarTeamBlack("sidebar.team.black"),
    SidebarTeamDarkBlue("sidebar.team.dark_blue"),
    SidebarTeamDarkGreen("sidebar.team.dark_green"),
    SidebarTeamDarkAqua("sidebar.team.dark_aqua"),
    SidebarTeamDarkRed("sidebar.team.red"),
    SidebarTeamDarkPurple("sidebar.team.dark_purple"),
    SidebarTeamGold("sidebar.team.gold"),
    SidebarTeamGray("sidebar.team.gray"),
    SidebarTeamDarkGray("sidebar.team.dark_gray"),
    SidebarTeamBlue("sidebar.team.blue"),
    SidebarTeamGreen("sidebar.team.green"),
    SidebarTeamAqua("sidebar.team.aqua"),
    SidebarTeamRed("sidebar.team.red"),
    SidebarTeamLightPurple("sidebar.team.light_purple"),
    SidebarTeamYellow("sidebar.team.yellow"),
    SidebarTeamWhite("sidebar.team.white"),
    BelowName("below_name");

    override fun toMinecraft(): String {
        return mcName
    }
}

class ScoreboardCommand : BaseCommand("scoreboard") {
    val objectives = ScoreboardObjectives(this)
    val players = ScoreboardPlayers(this)
}