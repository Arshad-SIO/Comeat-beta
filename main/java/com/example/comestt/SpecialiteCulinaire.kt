package com.example.comestt

data class SpecialiteCulinaire(
    val id: Int,
    val libelle: String
){
    override fun toString(): String {
        return libelle
    }
}
