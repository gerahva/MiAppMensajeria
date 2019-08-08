package org.mensajeria.cotizacion

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.activity_mensajeria.*




class TareaEnviarMensaje(private var ctx: Context?,
                         private var activity:ActivityMensajeria?)
    : AsyncTask<Void, Void, Void>() {


    var estatus=Estatus()
    var mensaje:String?=null
    var nickname:String?=null


    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra visita del MainActivity
        //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c
   Toast.makeText(ctx,"Mensaje enviado", Toast.LENGTH_LONG).show()
    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO quitarlos de aqui y ponerlo en menuactivity previo a invocar el excute

        nickname=Globales.usuarioMensaje?.nickname
        mensaje=activity?.cuerpomensaje?.text.toString()


    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
            var servicioRedSocial = retrofit.create(ServicioRedSocial::class.java)

            var envio = servicioRedSocial.enviarMensaje(nickname,mensaje)

            estatus = envio.execute().body()!!


        } catch (t: Throwable) {
            println("ERROR" + t.message)
        }
        return null

    }
}
















