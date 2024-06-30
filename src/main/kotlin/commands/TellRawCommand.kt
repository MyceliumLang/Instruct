package com.mycelium.commands

import com.mycelium.InstructJson
import com.mycelium.components.text.JsonComponent
import com.mycelium.target.TargetSelector
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.buildJsonArray

class TellRawCommand(private val target: TargetSelector, vararg val message: JsonComponent) : BaseCommand("tellraw") {
    override fun toMinecraft(): String {
        addArgument(target)

        if(message.size > 1) {
            addArgument(InstructJson.jsonInline.encodeToString(buildJsonArray {
                for (component in message) add(component.toJson())
            }))
        } else {
            addArgument(InstructJson.jsonInline.encodeToString(message[0].toJson()))
        }

        return super.toMinecraft()
    }

}