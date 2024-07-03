package io.github.myceliumlang.components.text

import kotlinx.serialization.json.*

class JsonNbtComponent(private val nbt: String?,
                       private val storage: String?,
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
    extra) {
    class Builder : BaseBuilder<JsonNbtComponent>() {
        var nbt: String? = null
            private set
        var storage: String? = null
            private set

        fun nbt(nbt: String) = apply { this.nbt = nbt }

        fun storage(storage: String) = apply { this.storage = storage }

        override fun build() = JsonNbtComponent(this)
    }

    private constructor(builder: Builder) : this(builder.nbt, builder.storage, builder.color, builder.font, builder.bold, builder.italic, builder.underlined, builder.strikethrough, builder.obfuscated, builder.extra)


    override fun toJson(): JsonElement {
        if(nbt == null || storage == null) {
            throw Exception("You must have a target and scoreboard to create a score component.")
        }

        return buildJsonObject {
            put("nbt", nbt)
            put("storage", storage)
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