package com.gmind.githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.username)
        var tvDetail: TextView = itemView.findViewById(R.id.user_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_user_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(200, 200))
            .into(holder.imgPhoto)
        holder.tvName.text = user.username
        holder.tvDetail.text = user.company
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(user: User)
    }
}

