package com.example.islamiapp.UI.MainActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.Data.Hadith
import com.example.islamiapp.Data.HadithList
import com.example.islamiapp.Logic.AdapterRecyclerNameHadith
import com.example.islamiapp.UI.ShowDetailsActivity.DetailsActivity
import com.example.islamiapp.databinding.FragmentAhadeethBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadeethFragment : Fragment() {
    lateinit var binding: FragmentAhadeethBinding
    lateinit var adapterHadith: AdapterRecyclerNameHadith
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadeethBinding.inflate(inflater)

        adapterHadith = AdapterRecyclerNameHadith(
            HadithList.readHadithFromAssets(
                "hadeeth/ahadeth.txt",
                requireContext().applicationContext
            )
        ) {
            Intent(requireContext(), DetailsActivity::class.java).apply {
                putExtra(Constants.POSITION_HADEETH, it)
                startActivity(this)
            }
        }
        binding.carouselRecyclerHadith.adapter = adapterHadith

        binding.carouselRecyclerHadith.apply {
          //  set3DItem(true)
            setAlpha(true)
            setInfinite(true)
            //setFlat(true)
            setIntervalRatio(.4f)
            setIsScrollingEnabled(true)
        }
        return binding.root
    }
}