package lopez.mario.listviewpeliculas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import lopez.mario.listviewpeliculas.AdaptadorPelis
import lopez.mario.listviewpeliculas.Pelicula
import lopez.mario.listviewpeliculas.R
import lopez.mario.listviewpeliculas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var peliculas: ArrayList<Pelicula> = ArrayList()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
         //   textView.text = it
       // }
        llenarPeliculas()
        var adaptador = AdaptadorPelis(root.context,peliculas)
        var listview: ListView = binding.listviewPelis

        listview.adapter = adaptador
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun llenarPeliculas(){
        val peli1 = Pelicula(1,getString(R.string.peli1),getString(R.string.desc1), 160, R.drawable.morbius)
        peliculas.add(peli1)

        val peli2 = Pelicula(2,getString(R.string.peli2),getString(R.string.desc2),114, R.drawable.scream)
        peliculas.add(peli2)

        val peli3 = Pelicula(3,getString(R.string.peli3),getString(R.string.desc3),116, R.drawable.uncharted)
        peliculas.add(peli3)

        val peli4 = Pelicula(4,getString(R.string.peli4),getString(R.string.desc4),176, R.drawable.batman)
        peliculas.add(peli4)

        val peli5 = Pelicula(5,getString(R.string.peli5),getString(R.string.desc5),121, R.drawable.sonicdos)
        peliculas.add(peli5)
    }
}