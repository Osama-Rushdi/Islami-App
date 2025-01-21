package com.example.islamiapp.UI.MainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.animation.ObjectAnimator
import com.example.islamiapp.Data.Zekr
import com.example.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private var counter = 0.0f
    private var countZekr = 0
    private var countFallZekr = 0
    private var indexOfZekr = 0

    private lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(layoutInflater)

        binding.root.setOnClickListener {
            changeZekr()
            rotateSeb7a()

        }


        binding.resetButton.setOnClickListener {
            counter = 0.0f
            countZekr = 0
            countFallZekr = 0
            indexOfZekr = 1
            binding.countFallAzkarTV.text = "${countFallZekr}"
            binding.zekrNameTV.text = Zekr.AzkarList()[0]
            binding.countZekrTV.text = "$countZekr"
        }

        return binding.root
    }

    private fun changeZekr() {
        binding.countFallAzkarTV.text = "${++countFallZekr}"
        binding.countZekrTV.text = "${++countZekr}"
        if (countZekr > 33) {
            countZekr = 1
            binding.countZekrTV.text = "$countZekr"
            binding.zekrNameTV.text = Zekr.AzkarList()[++indexOfZekr]
        }


    }

    private fun rotateSeb7a() {
        counter += 11
        if (counter == 360f)
            counter = 0f
        val rotation =
            ObjectAnimator.ofFloat(binding.progressBar, "rotation", counter, counter + 7)
        rotation.start()
    }


}
