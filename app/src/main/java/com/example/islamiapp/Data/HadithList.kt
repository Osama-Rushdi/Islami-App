package com.example.islamiapp.Data
import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object HadithList {


    fun readHadithFromAssets(fileName: String, context: Context): MutableList<Hadith> {
        val assetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val hadithContentList = mutableListOf<String>()
        val title = mutableListOf<String>()
        val currentHadith = StringBuilder()
        var line: String?

        line = reader.readLine()
        while (line != null) {
            if (currentHadith.isEmpty() && line.isNotEmpty())
                title.add(line)

            if (line.contains("#")) {
                if (currentHadith.isNotEmpty()) {
                    hadithContentList.add(currentHadith.toString().trim())
                    currentHadith.clear()
                }
            } else {
                currentHadith.append(line).append("\n")
            }
            line = reader.readLine()

        }
        reader.close()
        return fillHadithList(hadithContentList, title)
    }

    private fun fillHadithList(
        hadithContentList: MutableList<String>,
        title: MutableList<String>
    ): MutableList<Hadith> {
        val hadithListFull = mutableListOf<Hadith>()
        for (index in 0 until hadithContentList.size) {
            hadithListFull.add(Hadith(title[index], hadithContentList[index]))
        }
        return hadithListFull
    }
}
