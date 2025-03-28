package com.example.comestt

import java.time.LocalDate

data class Repas(
    val id: Int,
    val date: LocalDate,
    val nbCouverts: Int,
    val specialite: SpecialiteCulinaire,
    val hote: Utilisateur ,
    val convives: MutableList<Utilisateur> = mutableListOf()
){

    fun inscrire( utilisateur: Utilisateur ) {
        convives.add( utilisateur )
    }

    fun getNbPlacesLibres(): Int {
        return nbCouverts - convives.size
    }

    fun encoreDeLaPlace(): Boolean {
        if( nbCouverts > convives.size ){
            return true
        }
        return false
    }

    fun estConvive( idUtilisateur: Int ): Boolean {
        for( convive in convives ){
            if( convive.id == idUtilisateur ){
                return true
            }
        }
        return false
    }

    fun estHote( idUtilisateur: Int ): Boolean {
        if( idUtilisateur == hote.id ){
            return true
        }
        return false
    }
}

