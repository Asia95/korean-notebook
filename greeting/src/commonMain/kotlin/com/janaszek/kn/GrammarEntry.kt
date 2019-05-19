package com.janaszek.kn

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.greeting.com.janaszek.kn.GrammarInfo

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