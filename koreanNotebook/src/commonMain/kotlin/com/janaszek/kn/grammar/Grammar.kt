package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Serializable
import org.koreanNotebook.com.janaszek.kn.Category

@Serializable
data class Grammar(
        val idgrammar: Int,
        val category: Category
)