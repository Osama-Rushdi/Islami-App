package com.example.islamiapp.UI.MainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.animation.ObjectAnimator
import android.util.Log
import com.example.islamiapp.Data.Zekr
import com.example.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private var counter = 0.0f
    private var countZekr = 0
    private var countFallZekr = 0
    private var indexOfZekr = 1

    private lateinit var bindingSeb7a: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingSeb7a = FragmentSebhaBinding.inflate(layoutInflater)

        bindingSeb7a.root.setOnClickListener {
            changeZekr()
            rotateSeb7a()

        }


        bindingSeb7a.resetButton.setOnClickListener {
            resetAll()
        }

        return bindingSeb7a.root
    }

    private fun resetAll() {
        counter = 0.0f
        countZekr = 0
        countFallZekr = 0
        indexOfZekr = 0
        bindingSeb7a.countFallAzkarTV.text = "${countFallZekr}"
        bindingSeb7a.zekrNameTV.text = Zekr.AzkarList()[0]
        bindingSeb7a.countZekrTV.text = "$countZekr"
    }

    private fun changeZekr() {
        bindingSeb7a.countFallAzkarTV.text = "${++countFallZekr}"
        bindingSeb7a.countZekrTV.text = "${++countZekr}"

        if (countZekr > 33) {
            countZekr = 1
            Log.d("TAG", "countZekr:$countZekr ")
            bindingSeb7a.countZekrTV.text = "$countZekr"
            indexOfZekr++
            if (indexOfZekr <= Zekr.AzkarList().lastIndex)
                bindingSeb7a.zekrNameTV.text = Zekr.AzkarList()[indexOfZekr]
            else {
                indexOfZekr = 0
                bindingSeb7a.zekrNameTV.text = Zekr.AzkarList()[indexOfZekr]

            }


        }


    }

    private fun rotateSeb7a() {
        counter += 11
        if (counter == 360f)
            counter = 0f
        val rotation =
            ObjectAnimator.ofFloat(bindingSeb7a.progressBar, "rotation", counter, counter + 7)
        rotation.start()
    }
}
