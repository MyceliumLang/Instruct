package io.github.myceliumlang.datapack

import io.github.myceliumlang.InstructJson
import io.github.myceliumlang.datapack.tags.TagList
import kotlinx.serialization.encodeToString
import java.io.File

class Datapack(val name: String, val namespace: String, val description: String, val version: Int=MCMeta.Pack.LATEST) {
    private var outputPath: String = ""
    private var functions: MutableList<MCFunction> = mutableListOf()

    fun compile(outputPath: String) {
        this.outputPath = outputPath

        File("$outputPath/$name/pack.mcmeta").printWriter().use { out ->
            val meta = InstructJson.json.encodeToString(MCMeta.Pack(version, description).toJson())
            out.println(meta)
        }

        File("$outputPath/$name/data/$namespace").mkdirs()
        File("$outputPath/$name/data/minecraft").mkdirs()

        val functionLocation = makeNamespaceFeature("function")
        val functionTagLocation = makeNamespaceFeature("tags/function", "minecraft")

        for(func in functions) {
            File("$functionLocation/${func.name}.mcfunction").printWriter().use { out ->
                out.println(func.compile())
            }
        }

        File("$functionTagLocation/tick.json").printWriter().use { out ->
            val tick = InstructJson.json.encodeToString(TagList(functions.filter { func -> func.tags.contains(MCFunction.Tag.Tick) }.map { func -> "$namespace:${func.name}" }))
            out.println(tick)
        }
        File("$functionTagLocation/load.json").printWriter().use { out ->
            val load = InstructJson.json.encodeToString(TagList(functions.filter { func -> func.tags.contains(MCFunction.Tag.Load) }.map { func -> "$namespace:${func.name}" }))
            out.println(load)
        }
    }

    fun addFunction(mcFunction: MCFunction) {
        functions.add(mcFunction)
    }

    fun makeNamespaceFeature(featureName: String, namespace: String=this.namespace): String {
        val location = "$outputPath/$name/data/$namespace/$featureName"
        File(location).mkdirs()
        return location
    }
}