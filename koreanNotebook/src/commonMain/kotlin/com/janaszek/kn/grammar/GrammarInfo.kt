package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class GrammarInfo(
        val title: String,
        val body: String
)