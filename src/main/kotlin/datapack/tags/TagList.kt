package io.github.myceliumlang.datapack.tags

import kotlinx.serialization.Serializable

@Serializable
data class TagList(var values: List<String>)