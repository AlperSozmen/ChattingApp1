package com.example.chattingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.chattingapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        /*if (currentUser != null) {
            val action = LoginFragmentDirections.actionLoginFragmentToUserFragment()
            findNavController().navigate(action)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signupButton.setOnClickListener {
            //sign up button'a tiklandiginda yapilacaklar. kullanici kayit islemi yapilacak
            auth.createUserWithEmailAndPassword(binding.emailText.text.toString(),binding.passwordText.text.toString()).addOnSuccessListener {
                //Kullanıcı oluşturuldu
                if (auth.currentUser?.email?.contains("@std.yeditepe.edu.tr")!!) {
                    val action = LoginFragmentDirections.actionLoginFragmentToUserFragment()
                    findNavController().navigate(action)
                }
                else {
                    val action = LoginFragmentDirections.actionLoginFragmentToUser2Fragment()
                    findNavController().navigate(action)
                }
            }.addOnFailureListener { exception ->
                //hata alınınca execption olarak cevap veriyor
                Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

        binding.loginButton.setOnClickListener {
            //login button'a tiklandiginda yapilacaklar. kullanici giris islemi yapilacak.
            auth.signInWithEmailAndPassword(binding.emailText.text.toString(),binding.passwordText.text.toString()).addOnSuccessListener {
                if (auth.currentUser?.email?.contains("@std.yeditepe.edu.tr")!!) {
                    val action = LoginFragmentDirections.actionLoginFragmentToUserFragment()
                    findNavController().navigate(action)
                }
                else {
                    val action = LoginFragmentDirections.actionLoginFragmentToUser2Fragment()
                    findNavController().navigate(action)
                }
            }.addOnFailureListener { exception ->
                //hata alınınca execption olarak cevap veriyor
                Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}