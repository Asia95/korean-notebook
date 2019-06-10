package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class VocabularyEntry (
        val idvocabulary_entry: Int,
        val description: String,
        val title: String,
        val vocabulary: Vocabulary
){
    @Transient
    val label: String
        get() {
            return "N°$title\t\t$description"
        }
}