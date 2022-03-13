package lopez.mario.listviewpeliculas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import lopez.mario.listviewpeliculas.*
import lopez.mario.listviewpeliculas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    var series: ArrayList<Serie> = ArrayList()
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // val textView: TextView = binding.textGallery
      //  galleryViewModel.text.observe(viewLifecycleOwner) {
      //      textView.text = it
      //  }
        llenarSeries()
        var adaptador = AdaptadorSeries(root.context,series)
        var listview: ListView = binding.listviewSeries

        listview.adapter = adaptador
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarSeries(){
        val peli1 = Serie(1,getString(R.string.serie1),getString(R.string.trama1), R.drawable.gooddoctor)
        series.add(peli1)

        val peli2 = Serie(2,getString(R.string.serie2),getString(R.string.trama2), R.drawable.harina)
        series.add(peli2)

        val peli3 = Serie(3,getString(R.string.serie3),getString(R.string.trama3), R.drawable.betty)
        series.add(peli3)

        val peli4 = Serie(4,getString(R.string.serie4),getString(R.string.trama4), R.drawable.formula)
        series.add(peli4)

        val peli5 = Serie(5,getString(R.string.serie5),getString(R.string.trama5), R.drawable.casapapel)
        series.add(peli5)
    }
}