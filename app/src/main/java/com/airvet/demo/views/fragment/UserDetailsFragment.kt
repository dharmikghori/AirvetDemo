package com.airvet.demo.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airvet.demo.data.model.UserDetailsData
import com.airvet.demo.databinding.FragmentUserDetailBinding
import com.bumptech.glide.Glide

class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userDetailsData = arguments?.getParcelable<UserDetailsData>("userDetailsData")
        setupUserData(userDetailsData!!)
    }

    private fun setupUserData(userDetailsData: UserDetailsData) {
        Glide.with(binding.root.context)
            .load(userDetailsData.picture.medium)
            .into(binding.avatarImage)
        binding.emailText.text = userDetailsData.email
        binding.name.text = "${userDetailsData.name.first} ${userDetailsData.name.last}"
        binding.phoneNumber.text = userDetailsData.cell
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}