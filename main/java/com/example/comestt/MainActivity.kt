package com.example.comestt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val saisieEmail : TextView = findViewById( R.id.email )
        val saisieMdp : TextView = findViewById( R.id.mdp )

        val boutonConnecter : Button = findViewById( R.id.connecter)

        boutonConnecter.setOnClickListener{
            val email : String = saisieEmail.text.toString()
            val mdp : String = saisieMdp.text.toString()

            Log.d( "ACCT_CONN", "Connexion : $email/$mdp" )

            val utilisateur = Modele.findUtilisateur( email , mdp )

            if( utilisateur != null ) {
                Session.ouvrir( utilisateur )
                val intent = Intent(this, MenuRepasActivity::class.java)
                startActivity( intent)
            }
            else {
                Toast.makeText(this, "Identifiants incorrects", Toast.LENGTH_LONG).show()
                saisieEmail.text = ""
                saisieMdp.text = ""
            }
        }

        val boutonAnnuler : Button = findViewById( R.id.annuler)

        boutonAnnuler.setOnClickListener{
            saisieEmail.text = ""
            saisieMdp.text = ""

            Log.d( "ACC_CONN", "Annulation")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}