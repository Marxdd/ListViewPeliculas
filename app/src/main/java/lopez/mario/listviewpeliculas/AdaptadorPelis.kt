package lopez.mario.listviewpeliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorPelis: BaseAdapter {
    lateinit var context: Context
    var peliculas: ArrayList<Pelicula> = ArrayList()

    constructor(context: Context, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(p0: Int): Any {
        return peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.pelicula_view,null)

        var iv_img: ImageView = vista.findViewById(R.id.img_view)
        var tv_nombre: TextView = vista.findViewById(R.id.tv_nombre)

        var peli: Pelicula = peliculas[p0]

        iv_img.setImageResource(peli.img)
        tv_nombre.setText(peli.nombre)

        vista.setOnClickListener{
            val intent: Intent = Intent(context,PeliculaActivity::class.java)
            intent.putExtra("nombre",peli.nombre)
            intent.putExtra("desc",peli.sinopsis)
            intent.putExtra("img",peli.img)
            context.startActivity(intent)

        }
        return vista

    }
}