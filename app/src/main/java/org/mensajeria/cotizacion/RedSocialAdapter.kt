package org.mensajeria.cotizacion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class RedSocialAdapter(items: ArrayList<RedSocial>?, ctx: Context) :
    ArrayAdapter<RedSocial>(ctx, R.layout.lista_simple_redsocial, items) {

    //view holder is used to prevent findViewById calls
    private class RedSocialItemViewHolder {

        internal var nickname: TextView? = null
       // internal var momento:TextView?=null
       // internal  var horario:TextView?=null

    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view

        val viewHolder: RedSocialItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.lista_simple_redsocial, viewGroup, false)

            viewHolder = RedSocialItemViewHolder()
            viewHolder.nickname = view!!.findViewById<View>(R.id.txtNickname) as TextView
         //   viewHolder.momento = view!!.findViewById<View>(R.id.momento) as TextView
        //    viewHolder.horario=view!!.findViewById<View>(R.id.horario) as TextView


        } else {
            //no need to call findViewById, can use existing ones from saved view holder
            viewHolder = view.tag as RedSocialItemViewHolder
        }

        val redsocial = getItem(i)
        viewHolder.nickname!!.text = redsocial!!.nickname.toString()
      //  viewHolder.momento!!.text = asistencia!!.momento.toString()
      //  viewHolder.horario!!.text=asistencia!!.horario.toString()


        view.tag = viewHolder

        return view
    }
}

