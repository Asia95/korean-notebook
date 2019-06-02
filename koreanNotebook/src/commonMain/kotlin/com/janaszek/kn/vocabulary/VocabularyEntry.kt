package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class VocabularyEntry (
        val word: String,
        val description: String
){
    @Transient
    val label: String
        get() {
            return "N°$word\t\t$description"
        }
}