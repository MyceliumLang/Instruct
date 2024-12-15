package io.github.myceliumlang.datapack

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import org.apache.hc.core5.annotation.Internal

class MCMeta {
    @Internal
    class Pack(val version: Int, val description: String) {
        companion object {
            val LATEST = 61
        }

        fun toJson(): JsonObject {
            return buildJsonObject {
                putJsonObject("pack") {
                    put("pack_format", version)
                    put("description", description)
                }
                put("credits", "Made with <3 from Instruct.")
            }
        }
    }
}