package lopez.mario.listviewpeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)


        val tv_nombre: TextView = findViewById(R.id.tv_titulo)
        val tv_desc: TextView = findViewById(R.id.tv_desc)
        val iv_img: ImageView = findViewById(R.id.img_view)

        val bundle =intent.extras

        if (bundle != null){
            var nombre: String = bundle.getString("nombre","")
            var desc: String = bundle.getString("desc","")
            var img: Int = bundle.getInt("img")


            tv_nombre.setText(nombre)
            tv_desc.setText(desc)
            iv_img.setImageResource(img)
        }
    }
}