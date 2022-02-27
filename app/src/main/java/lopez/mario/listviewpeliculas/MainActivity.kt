package lopez.mario.listviewpeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var peliculas: ArrayList<Pelicula> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarPeliculas()
        var adaptador = AdaptadorPelis(this,peliculas)
        var listview: ListView = findViewById(R.id.listview)

        listview.adapter = adaptador
    }


    fun llenarPeliculas(){
        val peli1 = Pelicula(1,getString(R.string.peli1),getString(R.string.desc1), 160,R.drawable.morbius)
        peliculas.add(peli1)

        val peli2 = Pelicula(2,getString(R.string.peli2),getString(R.string.desc2),114,R.drawable.scream)
        peliculas.add(peli2)

        val peli3 = Pelicula(3,getString(R.string.peli3),getString(R.string.desc3),116,R.drawable.uncharted)
        peliculas.add(peli3)

        val peli4 = Pelicula(4,getString(R.string.peli4),getString(R.string.desc4),176,R.drawable.batman)
        peliculas.add(peli4)

        val peli5 = Pelicula(5,getString(R.string.peli5),getString(R.string.desc5),121,R.drawable.sonicdos)
        peliculas.add(peli5)
    }
}