package com.albert.ch09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.albert.ch09.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /**
     * Inflates the fragment's layout using view binding.
     *
     * This method initializes the fragment's view binding by inflating the layout with the provided inflater
     * and container, and then returns the binding's root view.
     *
     * @param inflater LayoutInflater used to inflate the fragment's view.
     * @param container Optional parent view for the fragment's UI.
     * @param savedInstanceState Previously saved state, if any.
     * @return The root view of the inflated layout.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    /**
     * Initializes the fragment's view and sets up navigation for the second button.
     *
     * Configures a click listener on the second button to navigate from SecondFragment to FirstFragment.
     *
     * @param view The fragment's root view.
     * @param savedInstanceState If non-null, the fragment is being re-constructed from a previous state.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    /**
     * Releases the view binding reference to prevent memory leaks.
     *
     * This method overrides the default onDestroyView to first call the superclass implementation,
     * then nullifies the binding reference, ensuring that the view binding is not accessed after
     * the fragment's view is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}