package mx.edu.uthermosillo.a19311900.asesoria.ui

import DashboardAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import mx.edu.uthermosillo.a19311900.asesoria.R
import mx.edu.uthermosillo.a19311900.asesoria.data.models.DashboardItem
import mx.edu.uthermosillo.a19311900.asesoria.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        val items = listOf(
            DashboardItem("Compras", R.drawable.compras),
            DashboardItem("Saldo", R.drawable.dolar),
            DashboardItem("Pago", R.drawable.pagar)
            // Agrega más ítems según necesites
        )

        val adapter = DashboardAdapter(items)
        binding.recyclerView2.layoutManager = LinearLayoutManager(context)
        binding.recyclerView2.adapter = adapter

        // Configurar datos del usuario
        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        user?.let {
            binding.userName.text = it.displayName
            binding.userEmail.text = it.email
            it.photoUrl?.let { photoUrl ->
                Glide.with(this).load(photoUrl).into(binding.userImg)
            } ?: run {
                Toast.makeText(requireContext(), "No profile image found.", Toast.LENGTH_SHORT).show()
            }
        }

        /*binding.buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, AuthActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
