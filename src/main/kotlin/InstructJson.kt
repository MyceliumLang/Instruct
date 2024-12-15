package io.github.myceliumlang

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class InstructJson {
    companion object {
        val jsonInline = Json {
            prettyPrint = false
        }
        @OptIn(ExperimentalSerializationApi::class)
        val json = Json {
            prettyPrint = true
            prettyPrintIndent = "\t"
        }
    }
}