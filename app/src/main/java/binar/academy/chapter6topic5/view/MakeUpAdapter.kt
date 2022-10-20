package binar.academy.chapter6topic5.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.chapter6topic5.databinding.ItemMakeupBinding
import binar.academy.chapter6topic5.model.ResponseDataMakeupItem
import com.bumptech.glide.Glide

class MakeUpAdapter(var listmakeup : List<ResponseDataMakeupItem>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemMakeupBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameMakeUp.text = listmakeup[position].name
        holder.binding.priceMakeup.text = listmakeup[position].price
        holder.binding.brandMakeup.text = listmakeup[position].brand
        Glide.with(holder.itemView.context)
            .load(listmakeup[position].imageLink)
            .into(holder.binding.imgMakeup)
    }

    override fun getItemCount(): Int = listmakeup.size
}