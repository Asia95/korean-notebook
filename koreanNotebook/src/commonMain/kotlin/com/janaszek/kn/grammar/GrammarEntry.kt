package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class GrammarEntry (
    val body: String,
    val title: String
){
    @Transient
    val label: String
        get() {
            return "N°$title\t\t$body"
        }
}