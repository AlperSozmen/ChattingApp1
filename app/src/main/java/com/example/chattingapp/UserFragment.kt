package com.example.chattingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.chattingapp.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val currentUser = auth.currentUser

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val chatFragment = ChatFragment()
            val args = Bundle()
            args.putString("user_name", "John Smith")
            chatFragment.arguments = args
            requireFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, chatFragment)
                .commit()
        }*/


        binding.button.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChatFragment()
            findNavController().navigate(action)

        }

        binding.button2.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChat2Fragment()
            findNavController().navigate(action)
        }

        binding.button3.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChat3Fragment()
            findNavController().navigate(action)
        }
        binding.button4.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChat4Fragment()
            findNavController().navigate(action)

        }
        binding.button5.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChat5Fragment()
            findNavController().navigate(action)
        }
        binding.button6.setOnClickListener {

            val action = UserFragmentDirections.actionUserFragmentToChat6Fragment()
            findNavController().navigate(action)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}