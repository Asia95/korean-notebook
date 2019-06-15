package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class VocabularyEntry (
        val description: String,
        val title: String
){
    constructor(idvocabulary_entry: Int, description: String, title: String, vocabulary: Vocabulary) : this(description, title)

    @Transient
    val label: String
        get() {
            return "N°$title\t\t$description"
        }
}