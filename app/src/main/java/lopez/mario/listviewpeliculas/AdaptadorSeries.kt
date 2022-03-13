package lopez.mario.listviewpeliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorSeries: BaseAdapter {
    lateinit var context: Context
    var series: ArrayList<Serie> = ArrayList()

    constructor(context: Context, series: ArrayList<Serie>){
        this.context = context
        this.series = series
    }

    override fun getCount(): Int {
        return series.size
    }

    override fun getItem(p0: Int): Any {
        return series[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.pelicula_view,null)

        var iv_img: ImageView = vista.findViewById(R.id.img_view)
        var tv_nombre: TextView = vista.findViewById(R.id.tv_nombre)

        var serie: Serie = series[p0]

        iv_img.setImageResource(serie.img)
        tv_nombre.setText(serie.nombre)

        vista.setOnClickListener{
            val intent: Intent = Intent(context,PeliculaActivity::class.java)
            intent.putExtra("nombre",serie.nombre)
            intent.putExtra("desc",serie.sinopsis)
           intent.putExtra("img",serie.img)
            context.startActivity(intent)

        }
        return vista

    }
}