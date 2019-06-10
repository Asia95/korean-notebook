package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.Serializable
import org.koreanNotebook.com.janaszek.kn.Category

@Serializable
data class Vocabulary (
        val idvocabulary: Int,
        val category: Category
)