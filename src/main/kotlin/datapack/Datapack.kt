package io.github.myceliumlang.datapack

import io.github.myceliumlang.InstructJson
import io.github.myceliumlang.datapack.tags.TagList
import kotlinx.serialization.encodeToString
import java.io.File

class Datapack(val name: String, val namespace: String, val description: String, val version: Int=LATEST) {
    companion object {
        const val LATEST = 61
    }

    private var outputPath: String = ""
    private var functions: MutableList<MCFunction> = mutableListOf()

    fun compile(outputPath: String) {
        this.outputPath = outputPath
        File("$outputPath/$name/data/$namespace").mkdirs()

        val functionLocation = makeNamespaceFeature("function")
        val functionTagLocation = makeNamespaceFeature("tags/function")

        for(func in functions) {
            File("$functionLocation/${func.name}.mcfunction").printWriter().use { out ->
                out.println(func.compile())
            }
        }

        File("$functionTagLocation/tick.json").printWriter().use { out ->
            val tick = InstructJson.jsonInline.encodeToString(TagList(functions.filter { func -> func.tags.containsKey(MCFunction.Tag.Tick) }.map { func -> "$namespace:${func.name}" }))
            out.println(tick)
        }
        File("$functionTagLocation/load.json").printWriter().use { out ->
            val load = InstructJson.jsonInline.encodeToString(TagList(functions.filter { func -> func.tags.containsKey(MCFunction.Tag.Load) }.map { func -> "$namespace:${func.name}" }))
            out.println(load)
        }
    }

    fun addFunction(mcFunction: MCFunction) {
        functions.add(mcFunction)
    }

    fun makeNamespaceFeature(featureName: String): String {
        val location = "$outputPath/$name/data/$namespace/$featureName"
        File(location).mkdirs()
        return location
    }
}