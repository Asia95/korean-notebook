package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class VocabularyCategory (
        val category: JsonArray
)