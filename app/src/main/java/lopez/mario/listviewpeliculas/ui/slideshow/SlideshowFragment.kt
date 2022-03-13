package lopez.mario.listviewpeliculas.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import lopez.mario.listviewpeliculas.AdaptadorSeries
import lopez.mario.listviewpeliculas.R
import lopez.mario.listviewpeliculas.Serie
import lopez.mario.listviewpeliculas.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {
    var series: ArrayList<Serie> = ArrayList()
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

     //   val textView: TextView = binding.textSlideshow
   //     slideshowViewModel.text.observe(viewLifecycleOwner) {
     //       textView.text = it
        //}

        llenarSeries()
        var adaptador = AdaptadorSeries(root.context,series)
        var listview: ListView = binding.listviewFav

        listview.adapter = adaptador
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarSeries(){
        val peli1 = Serie(1,getString(R.string.fav1),getString(R.string.sinop1), R.drawable.callsaul)
        series.add(peli1)

        val peli2 = Serie(2,getString(R.string.fav2),getString(R.string.sinop2), R.drawable.invencible)
        series.add(peli2)

        val peli3 = Serie(3,getString(R.string.fav3),getString(R.string.sinop3), R.drawable.theboys)
        series.add(peli3)

        val peli4 = Serie(4,getString(R.string.fav4),getString(R.string.sinop4), R.drawable.daredevil)
        series.add(peli4)

        val peli5 = Serie(5,getString(R.string.fav5),getString(R.string.sinop5), R.drawable.bojack)
        series.add(peli5)
    }
}