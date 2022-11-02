package com.example.chapter6_mvp.View

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter6_mvp.Model.DataCarItem
import com.example.chapter6_mvp.databinding.ItemCarBinding

class CarAdapter(var listCar : List<DataCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        val id = listCar[position].id.toString()
        val nama = listCar[position].name
        val cat = listCar[position].category
        val price = listCar[position].price.toString()
        val img = listCar[position].image

        holder.binding.textIdCar.text = id
        holder.binding.textNamecar.text = nama
        holder.binding.textCategory.text = cat
        holder.binding.textHarga.text = "Rp."+ price
        Glide.with(holder.itemView).load(img).into(holder.binding.carImage)

        holder.binding.idCardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("nama", nama)
            intent.putExtra("cat", cat)
            intent.putExtra("price", price)
            intent.putExtra("img", img)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}