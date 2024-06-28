package mx.edu.uthermosillo.a19311900.asesoria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.edu.uthermosillo.a19311900.asesoria.databinding.FragmentWalletBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.edu.uthermosillo.a19311900.asesoria.ui.adapters.MovementsAdapter
import mx.edu.uthermosillo.a19311900.asesoria.data.models.Movimiento


class WalletFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovementsAdapter
    private lateinit var movimientos: List<Movimiento>
    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        movimientos = listOf(
            Movimiento("Compra en supermercado", "2024-06-01", -50.75),
            Movimiento("Compra en supermercado", "2024-06-01", -50.75),
            Movimiento("Compra en supermercado", "2024-06-01", -50.75),
            Movimiento("Pago de nómina", "2024-06-05", 1500.00)
            // Añade más movimientos según necesites
        )

        adapter = MovementsAdapter(movimientos)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

