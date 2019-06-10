package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class GrammarEntry (
        val idgrammar_entry: Int,
        val body: String,
        val title: String,
        val grammar: Grammar
){
    @Transient
    val label: String
        get() {
            return "N°$title\t\t$body"
        }
}