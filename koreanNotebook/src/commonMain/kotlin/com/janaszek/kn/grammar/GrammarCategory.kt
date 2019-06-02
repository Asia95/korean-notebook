package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Decoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray

@Serializable
data class GrammarCategory (
        val category: JsonArray
)