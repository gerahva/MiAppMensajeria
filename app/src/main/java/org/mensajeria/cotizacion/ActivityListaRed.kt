package org.mensajeria.cotizacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ActivityListaRed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_red)


        //Primero obtenemos todos los usuarios de REdSocial de la siguiente tarea que se conecta al backend
        TareaLeerTodos(this,this).execute().get()
        //Ahora si con esta variable usuariosRed llenaremos nuestro listado
        val usuariosRed=Globales.usuariosRed


        val lv = findViewById<ListView>(R.id.lista_redsocial)
        val redSocialAdapter = RedSocialAdapter(usuariosRed,this)
        lv.adapter = redSocialAdapter
        lv.dividerHeight = 2


        lv.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            Toast.makeText(this@ActivityListaRed,
                "Seleccionaste "+ usuariosRed?.get(i)?.nickname ,
                Toast.LENGTH_LONG).show()

            //El siguiente usuario de red es el que seleccionamos
            Globales.usuarioMensaje= usuariosRed?.get(i)
            //Navegamos al mensaje a enviarse
            var i= Intent(this, ActivityMensajeria::class.java)
            startActivity(i)


        }


    }
}
