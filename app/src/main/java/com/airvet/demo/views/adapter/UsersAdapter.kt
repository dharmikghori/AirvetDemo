package com.airvet.demo.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airvet.demo.data.model.UserDetailsData
import com.airvet.demo.databinding.LayoutUserBinding

class UsersAdapter(
    private val users: ArrayList<UserDetailsData>,
    private val clickListener: (UserDetailsData) -> Unit
) :
    RecyclerView.Adapter<UserViewHolder.UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder.UserHolder {
        return UserViewHolder.UserHolder(
            LayoutUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), clickListener
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder.UserHolder, position: Int) {
        holder.bind(userData = users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}