package org.mensajeria.cotizacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mensajeria.*

class ActivityMensajeria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajeria)
        textoMensaje.setText(Globales.mensaje)
    }
}
