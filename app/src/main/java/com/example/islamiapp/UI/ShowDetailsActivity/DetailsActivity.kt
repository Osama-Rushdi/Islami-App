package com.example.islamiapp.UI.ShowDetailsActivity

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.Data.Hadith
import com.example.islamiapp.Data.HadithList
import com.example.islamiapp.Data.Quraanlist
import com.example.islamiapp.UI.MainActivity.Constants.POSITION_HADEETH
import com.example.islamiapp.UI.MainActivity.Constants.POSITION_QURAAN
import com.example.islamiapp.databinding.ActivityDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var binding: ActivityDetailsBinding

 class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.dark(0),
            navigationBarStyle = SystemBarStyle.dark(0)
        )
        setContentView(binding.root)


        binding.arrowBackIV.setOnClickListener { finish() }

        addContentToViewsQuraan()


    }

    fun readQuraanFromAssets(fileName: String): String {
        val assetManager = this.assets
        val inputStream = assetManager.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String?

        // Read each line from the file and append to the stringBuilder
        while (reader.readLine().also { line = it } != null) {
            stringBuilder.append(line).append("\n")
        }
        reader.close()

        return stringBuilder.toString()
    }

    private fun addContentToViewsQuraan() {
        var index = 0
        if (intent.getIntExtra(POSITION_QURAAN, -1) != -1) {
            index = intent.getIntExtra(POSITION_QURAAN, -1)

            val sora = Quraanlist.ListSoraFilled[index]
            binding.soraOrHadeethNameArTV.text = sora.nameAr
            binding.soraOrHadeethNameEnTV.text = sora.nameEn
            binding.soraOrHadeethContentTV.text = readQuraanFromAssets("sorah/${index + 1}.txt")
        }

        else if (intent.getIntExtra(POSITION_HADEETH, -1) != -1) {
            val Hadeth = HadithList.readHadithFromAssets("hadeeth/ahadeth.txt",applicationContext)
            index = intent.getIntExtra(POSITION_HADEETH, -1)

            "Hadith ${index + 1}".also { binding.soraOrHadeethNameEnTV.text = it }
            binding.soraOrHadeethNameArTV.text = Hadeth[index].nameAr
            binding.soraOrHadeethContentTV.text = Hadeth[index].content
        }
    }


}


