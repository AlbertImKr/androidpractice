package com.albert.ch09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.albert.ch09.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /**
     * Inflates the fragment's layout using view binding and returns the root view.
     *
     * This method initializes the binding by inflating the layout associated with this fragment and
     * ensures that the binding references are correctly set up for subsequent use in the view lifecycle.
     *
     * @param inflater The LayoutInflater used to inflate the layout.
     * @param container The optional parent view that the fragment's UI may be attached to.
     * @param savedInstanceState Previously saved state, if any.
     * @return The root view of the inflated layout.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    /**
     * Initializes UI interactions after the fragment's view is created.
     *
     * Attaches a click listener to the "buttonFirst" to navigate from the current fragment to SecondFragment when pressed.
     *
     * @param view The fragment's root view.
     * @param savedInstanceState A Bundle containing the fragment's previously saved state, if any.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    /**
     * Releases the view binding to prevent memory leaks.
     *
     * This method clears the binding instance after the fragment's view is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}