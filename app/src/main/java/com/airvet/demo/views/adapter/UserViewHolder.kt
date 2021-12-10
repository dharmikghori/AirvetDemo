package com.airvet.demo.views.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.airvet.demo.data.model.UserDetailsData
import com.airvet.demo.databinding.LayoutUserBinding
import com.bumptech.glide.Glide

sealed class UserViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class UserHolder(
        private val binding: LayoutUserBinding,
        private val clickListener: (UserDetailsData) -> Unit
    ) : UserViewHolder(binding) {
        fun bind(userData: UserDetailsData) {
            binding.textName.text = "${userData.name.first} ${userData.name.last}"
            binding.textCell.text = userData.cell
            binding.root.setOnClickListener { clickListener.invoke(userData) }
            Glide.with(binding.root.context)
                .load(userData.picture.medium)
                .into(binding.imageChat)
        }
    }
}