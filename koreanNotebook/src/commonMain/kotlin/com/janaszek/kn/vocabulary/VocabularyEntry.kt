package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class VocabularyEntry (
        @SerialName("explanation")
        val explanation: String,
        val title: String
){
    constructor(idvocabulary_entry: Int, explanation: String, title: String, vocabulary: Vocabulary) : this(explanation, title)

    @Transient
    val label: String
        get() {
            return "N°$title\t\t$explanation"
        }
}