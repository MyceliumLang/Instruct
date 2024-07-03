package io.github.myceliumlang

import kotlinx.serialization.json.Json

class InstructJson {
    companion object {
        val jsonInline = Json {
            prettyPrint = false
        }
    }
}