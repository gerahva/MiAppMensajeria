package org.mensajeria.cotizacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registrar.setOnClickListener {

            //segundo paso obtener token   nnnnnnnnnnnnnnnnnnnn
            var token= FirebaseInstanceId.getInstance().token

                    Toast.makeText(this,"El toke es $token",Toast.LENGTH_LONG).show()

            //El siguiente paso es GUARDAR ese token en tu base de datos a treves de un servicio rest de tu app de heroku
            //paso 3:
        TareaGuardarRedSocial(this,token,this).execute()




        }


        verUsuarios.setOnClickListener {

            var i = Intent(this, ActivityListaRed::class.java)
            startActivity(i)
        }
    }
}
