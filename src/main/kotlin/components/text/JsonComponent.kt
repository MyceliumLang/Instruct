package com.mycelium.components.text

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonArray
import java.awt.Color

abstract class JsonComponent(private val color: String?,
                             private val font: String?,
                             private val bold: Boolean?,
                             private val italic: Boolean?,
                             private val underlined: Boolean?,
                             private val strikethrough: Boolean?,
                             private val obfuscated: Boolean?,
                             private val extra: MutableList<JsonComponent>?) {

    companion object {
        val BLACK: Color = Color.decode("#000000")
        val DARK_BLUE: Color = Color.decode("#0000AA")
        val DARK_GREEN: Color = Color.decode("#00AA00")
        val DARK_AQUA: Color = Color.decode("#00AAAA")
        val DARK_RED: Color = Color.decode("#AA0000")
        val DARK_PURPLE: Color = Color.decode("#AA00AA")
        val GOLD: Color = Color.decode("#FFAA00")
        val GRAY: Color = Color.decode("#AAAAAA")
        val DARK_GRAY: Color = Color.decode("#555555")
        val BLUE: Color = Color.decode("#5555FF")
        val GREEN: Color = Color.decode("#55FF55")
        val AQUA: Color = Color.decode("#55FFFF")
        val RED: Color = Color.decode("#FF5555")
        val LIGHT_PURPLE: Color = Color.decode("#FF55FF")
        val YELLOW: Color = Color.decode("#FFFF55")
        val WHITE: Color = Color.decode("#FFFFFF")
    }

    abstract class BaseBuilder<T : JsonComponent> {
        var color: String = "#FFFFFF"
            private set
        var font: String? = null
            private set
        var bold: Boolean? = null
            private set
        var italic: Boolean? = null
            private set
        var underlined: Boolean? = null
            private set
        var strikethrough: Boolean? = null
            private set
        var obfuscated: Boolean? = null
            private set
        var extra: MutableList<JsonComponent> = mutableListOf()
            private set

        fun color(color: String) = apply { this.color = color }
        fun color(color: Color) = apply { this.color= String.format("#%02x%02x%02x".uppercase(), color.red, color.green, color.blue); }
        fun font(font: String) = apply { this.font = font }
        fun bold(bold: Boolean) = apply { this.bold = bold }
        fun italic(italic: Boolean) = apply { this.italic = italic }
        fun underlined(underlined: Boolean) = apply { this.underlined = underlined }
        fun strikethrough(strikethrough: Boolean) = apply { this.strikethrough = strikethrough }
        fun obfuscated(obfuscated: Boolean) = apply { this.obfuscated = obfuscated }

        fun add(component: JsonComponent) = apply { this.extra.add(component) }

        abstract fun build(): T
    }

    fun getFormatting(): List<Pair<String, Any>> {
        val formatting = mutableListOf<Pair<String, Any>>()

        if(color != null) formatting.add(Pair("color", color))
        if(font != null) formatting.add(Pair("font", font))
        if(bold != null) formatting.add(Pair("bold", bold))
        if(italic != null) formatting.add(Pair("italic", italic))
        if(underlined != null) formatting.add(Pair("underlined", underlined))
        if(strikethrough != null) formatting.add(Pair("strikethrough", strikethrough))
        if(obfuscated != null) formatting.add(Pair("obfuscated", obfuscated))
        if(extra?.isNotEmpty() == true) formatting.add(Pair("extra", buildJsonArray {
            for(comp in extra) add(comp.toJson())
        }))

        return formatting
    }

    abstract fun toJson(): JsonElement
}