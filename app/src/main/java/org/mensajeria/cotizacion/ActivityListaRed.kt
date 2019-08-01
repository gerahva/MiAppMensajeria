package org.mensajeria.cotizacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ActivityListaRed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_red)

        TareaLeerTodos(this,this).execute().get()
        //Ahora si
        val usuariosRed=Globales.usuariosRed


        val lv = findViewById<ListView>(R.id.colocar_redsocial)
        val redSocialAdapter = RedSocialAdapter(usuariosRed,this)
        lv.adapter = redSocialAdapter
        lv.dividerHeight = 2


        lv.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            Toast.makeText(this@ActivityListaRed,
                "Seleccionaste " + (i + 1),
                Toast.LENGTH_LONG).show()
        }


    }
}
