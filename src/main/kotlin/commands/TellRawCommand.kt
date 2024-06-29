package com.mycelium.commands

import com.mycelium.InstructJson
import com.mycelium.components.text.JsonComponent
import com.mycelium.target.TargetSelector
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.buildJsonArray

class TellRawCommand<in T>(private val target: TargetSelector, private val message: T) : BaseCommand("tellraw")
        where T : JsonComponent,
              T: List<JsonComponent> {

    override fun toMinecraft(): String {
        addArgument(target)
        addArgument(InstructJson.jsonInline.encodeToString(buildJsonArray {
            for(component in message) add(component.toJson())
        }))

        return super.toMinecraft()
    }

}