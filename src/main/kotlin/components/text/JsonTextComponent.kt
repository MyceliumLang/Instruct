package io.github.myceliumlang.components.text

import kotlinx.serialization.json.*

class JsonTextComponent(private val text: String,
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
    extra
) {
    class Builder : BaseBuilder<JsonTextComponent>() {
        var text: String = ""
            private set

        fun text(text: String) = apply { this.text = text }

        override fun build() = JsonTextComponent(this)
    }

    private constructor(builder: Builder) : this(builder.text, builder.color, builder.font, builder.bold, builder.italic, builder.underlined, builder.strikethrough, builder.obfuscated, builder.extra)

    override fun toJson(): JsonElement {
        if(getFormatting().isEmpty()) {
            return JsonPrimitive(text)
        }
        return buildJsonObject {
            put("text", text)
            for(pair in getFormatting()) {
                when (pair.second) {
                    is JsonObject -> put(pair.first, pair.second as JsonObject)
                    is JsonArray -> put(pair.first, pair.second as JsonArray)
                    is Int -> put(pair.first, pair.second as Int)
                    is Float -> put(pair.first, pair.second as Float)
                    is Double -> put(pair.first, pair.second as Double)
                    is String -> put(pair.first, pair.second as String)
                }
            }
        }
    }
}