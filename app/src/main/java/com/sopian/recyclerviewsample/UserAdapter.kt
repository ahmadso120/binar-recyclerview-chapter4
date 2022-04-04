package com.sopian.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sopian.recyclerviewsample.databinding.ItemUserBinding

class UserAdapter(
    private val listUser: List<User>,
    private var onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder) {
            val data = listUser[position]

            binding.nameTextView.text = data.name
            binding.phoneNumberTextView.text = data.phone.toString()

            binding.root.setOnClickListener {
                onItemClick(data)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
}