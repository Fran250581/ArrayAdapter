package com.example.fran.arrayadapterpersonalizado

import android.os.Bundle
import android.app.ListActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.ViewGroup
import android.widget.ImageView

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = AdaptadorConIcono()
    }

    companion object {
        private val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
                "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un",
                "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín",
                "flaco", "y", "galgo", "corredor")
    }

    internal inner class AdaptadorConIcono() : ArrayAdapter<String>(this@MainActivity, R.layout.fila, R.id.etiqueta, items){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val fila = super.getView(position, convertView, parent)
            val icon = fila.findViewById<View>(R.id.icono) as ImageView

            if (items[position].length > 4) {
                icon.setImageResource(android.R.drawable.btn_star_big_off)
            } else {
                icon.setImageResource(android.R.drawable.btn_star_big_on)
            }

            val tamanyo = fila.findViewById<View>(R.id.tamanyo) as TextView
            tamanyo.text = String.format(getString(R.string.tamanyo_template), items[position].length)
            return fila
        }
    }

}


