package org.mensajeria.cotizacion

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*




class TareaGuardarRedSocial(private var ctx: Context?, private var token:String?,
                          private var activity:MainActivity?)
    : AsyncTask<Void, Void, Void>() {

    var estatus = Estatus()
    var redSocial = RedSocial()


    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra visita del MainActivity
        //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c
        Toast.makeText(ctx, estatus.mensaje, Toast.LENGTH_LONG).show()


    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO quitarlos de aqui y ponerlo en menuactivity previo a invocar el excute
        redSocial.nickname = activity?.txtnickname?.text.toString()
        redSocial.token = token


    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
            var servicioRedSocial = retrofit.create(ServicioRedSocial::class.java)

            var envio = servicioRedSocial.guardarRedSocial(redSocial)

            estatus = envio.execute().body()!!

        } catch (t: Throwable) {
            println("ERROR" + t.message)
        }
        return null

    }
}
















