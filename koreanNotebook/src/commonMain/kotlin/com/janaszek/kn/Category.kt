package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class Category(
        val idcategory: Int,
        val category: String
)