package com.airvet.demo.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airvet.demo.R
import com.airvet.demo.data.model.ResultModel
import com.airvet.demo.data.model.UserData
import com.airvet.demo.data.model.UserDetailsData
import com.airvet.demo.data.viewmodel.UserViewModel
import com.airvet.demo.databinding.FragmentUsersBinding
import com.airvet.demo.views.adapter.UsersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.getAllUsers()
        userViewModel.usersLiveData.observe(viewLifecycleOwner, { userData ->
            when (userData) {
                is ResultModel.Success<*> -> {
                    setupUserRecyclerview(userData.data as UserData)
                }
                else -> {

                }
            }
        })
    }

    private fun setupUserRecyclerview(userData: UserData) {
        val linearLayoutManager = LinearLayoutManager(binding.root.context)
        binding.rvUsers.layoutManager = linearLayoutManager
        binding.rvUsers.adapter = UsersAdapter(userData.results, ::onUserClick)

    }

    private fun onUserClick(userDetailsData: UserDetailsData) {
        val bundle = bundleOf("userDetailsData" to userDetailsData)

        findNavController().navigate(R.id.userDetail,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}