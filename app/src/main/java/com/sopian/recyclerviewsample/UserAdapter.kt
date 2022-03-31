package com.sopian.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val user: List<User>,
    private var onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_user,parent,false
        )
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.nameTextView.text = user[position].name
        holder.phoneTextView.text = user[position].phone.toString()
        holder.root.setOnClickListener {
            onItemClick(user[position])
        }
    }

    override fun getItemCount(): Int = user.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        val phoneTextView: TextView = itemView.findViewById(R.id.phone_number_text_view)
        val root: ConstraintLayout = itemView.findViewById(R.id.root)
    }
}