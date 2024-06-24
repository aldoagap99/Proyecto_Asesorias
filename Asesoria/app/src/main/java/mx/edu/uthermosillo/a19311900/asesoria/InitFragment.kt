package mx.edu.uthermosillo.a19311900.asesoria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.edu.uthermosillo.a19311900.asesoria.ui.adapters.OnBoardingAdapter
import mx.edu.uthermosillo.a19311900.asesoria.databinding.FragmentInitBinding
import onboarding.FirstFragment
import onboarding.SecondFragment
import onboarding.ThirdFragment

class InitFragment : Fragment() {
    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        val view: View = inflater.inflate(R.layout.fragment_init, container, false);
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        val viewPager2 = binding.onBoardingViewPager
        val fragmentList = arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment(),
            LoginFragment()
        )
        val adapter = OnBoardingAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        return binding.root
    }
}