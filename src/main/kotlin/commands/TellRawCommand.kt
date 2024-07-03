package io.github.myceliumlang.commands

import io.github.myceliumlang.InstructJson
import io.github.myceliumlang.components.text.JsonComponent
import io.github.myceliumlang.target.TargetSelector
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