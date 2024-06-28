package com.mycelium.components.text

import com.mycelium.target.TargetSelector
import kotlinx.serialization.json.*

class JsonScoreComponent(private val target: TargetSelector?,
                         private val scoreboard: String?,
                         color: String?,
                         font: String?,
                         bold: Boolean?,
                         italic: Boolean?,
                         underlined: Boolean?,
                         strikethrough: Boolean?,
                         obfuscated: Boolean?,
                         extra: MutableList<JsonComponent>?) : JsonComponent(color,
    font,
    bold,
    italic,
    underlined,
    strikethrough,
    obfuscated,
    extra)  {
    class Builder : BaseBuilder<JsonScoreComponent>() {
        var target: TargetSelector? = null
            private set
        var scoreboard: String? = null
            private set

        fun target(target: TargetSelector) = apply { this.target = target }

        fun scoreboard(scoreboard: String) = apply { this.scoreboard = scoreboard }

        override fun build() = JsonScoreComponent(this)
    }

    private constructor(builder: Builder) : this(builder.target, builder.scoreboard, builder.color, builder.font, builder.bold, builder.italic, builder.underlined, builder.strikethrough, builder.obfuscated, builder.extra)

    override fun toJson(): JsonElement {
        if(target == null || scoreboard == null) {
            throw Exception("You must have a target and scoreboard to create a score component.")
        }

        return buildJsonObject {
            put("score", buildJsonObject {
                put("name", target.toScoreHolder())
                put("objective", scoreboard)
            })
            for(pair in getFormatting()) {
                when (pair.second) {
                    is JsonObject -> put(pair.first, pair.second as JsonObject)
                    is JsonArray -> put(pair.first, pair.second as JsonArray)
                    is Int -> put(pair.first, pair.second as Int)
                    is Float -> put(pair.first, pair.second as Float)
                    is Double -> put(pair.first, pair.second as Double)
                    is String -> put(pair.first, pair.second as String)
                    is Boolean -> put(pair.first, pair.second as Boolean)
                }
            }
        }
    }
}