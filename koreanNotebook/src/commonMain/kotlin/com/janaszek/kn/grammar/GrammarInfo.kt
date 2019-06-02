package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Serializable

@Serializable
data class GrammarInfo(
        val title: String,
        val body: String
)