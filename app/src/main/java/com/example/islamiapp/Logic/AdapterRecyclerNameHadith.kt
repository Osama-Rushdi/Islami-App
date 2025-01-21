package com.example.islamiapp.Logic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.Data.Hadith
import com.example.islamiapp.databinding.CardItemSoraasBinding
import com.example.islamiapp.databinding.HadethItemBinding

class AdapterRecyclerNameHadith(
    private val hadithList: MutableList<Hadith>,
    val clickOnItem: (position: Int) -> Unit
) :
    RecyclerView.Adapter<AdapterRecyclerNameHadith.ViewHolder>() {


    class ViewHolder(val binding: HadethItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding =
            HadethItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadith = hadithList[position]
        holder.binding.HadeethTitleArTV.text = hadith.nameAr
        holder.binding.HadeethContentTV.text = hadith.content

        holder.binding.root.setOnClickListener { clickOnItem(position) }
    }

    override fun getItemCount(): Int {
        return hadithList.size
    }
}