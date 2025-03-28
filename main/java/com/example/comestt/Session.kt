package com.example.comestt

object Session {
    private var utilisateur : Utilisateur? = null

    fun ouvrir( utilisateur : Utilisateur ) {
        this.utilisateur = utilisateur
    }

    fun fermer(){
        utilisateur = null
    }

    fun getUtilisateur() : Utilisateur? {
        return utilisateur
    }
}