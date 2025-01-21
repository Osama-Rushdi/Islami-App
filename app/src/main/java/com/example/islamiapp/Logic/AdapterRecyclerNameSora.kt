package com.example.islamiapp.Logic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.Data.Sora
import com.example.islamiapp.databinding.CardItemSoraasBinding

class AdapterRecyclerNameSora(private val soraList: MutableList<Sora>,val clickOnItem:(position:Int)->Unit) :
    RecyclerView.Adapter<AdapterRecyclerNameSora.ViewHolder>() {


    class ViewHolder(val binding: CardItemSoraasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding =
            CardItemSoraasBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder,  position: Int) {
        val sora = soraList[position]
        holder.binding.soraNumber.text = "${position.plus(1)}"
        holder.binding.ayatNumbers.text = sora.numVerses
        holder.binding.soraNameArabic.text = sora.nameAr
        holder.binding.soraNameEnglish.text = sora.nameEn

        holder.binding.root.setOnClickListener { clickOnItem(position)}
    }

    override fun getItemCount(): Int {
        return soraList.size
    }
}