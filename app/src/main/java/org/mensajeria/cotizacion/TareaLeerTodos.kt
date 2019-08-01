package org.mensajeria.cotizacion

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*




class TareaLeerTodos(private var ctx: Context?,
                     private var activity:ActivityListaRed?)
    : AsyncTask<Void, Void, Void>() {


    var usuariosRed = ArrayList<RedSocial>()


    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra visita del MainActivity
        //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c



    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO quitarlos de aqui y ponerlo en menuactivity previo a invocar el excute


    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
            var servicioRedSocial = retrofit.create(ServicioRedSocial::class.java)

            var envio = servicioRedSocial.buscarRedSocialTodos()

            usuariosRed = envio.execute().body()!!
            Globales.usuariosRed=usuariosRed

        } catch (t: Throwable) {
            println("ERROR" + t.message)
        }
        return null

    }
}
















