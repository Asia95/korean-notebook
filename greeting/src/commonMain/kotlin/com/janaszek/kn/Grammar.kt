package com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class Grammar(
        val grammar: List<GrammarEntry>
)