package com.example.islamiapp.UI.MainActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.Data.Quraanlist
import com.example.islamiapp.Logic.AdapterRecyclerNameSora
import com.example.islamiapp.UI.ShowDetailsActivity.DetailsActivity
import com.example.islamiapp.databinding.FragmentQuraanBinding

object Constants {
    const val POSITION_QURAAN = "positionQuraan"
    const val POSITION_HADEETH = "positionHadeeth"
}

class QuraanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var adapter:AdapterRecyclerNameSora
    private lateinit var binding: FragmentQuraanBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          binding=FragmentQuraanBinding.inflate(inflater)
        adapter = AdapterRecyclerNameSora(Quraanlist.ListSoraFilled) { index ->
            Log.d("TAG", "onCreateView:${index} ")
            val intent = Intent(requireContext(), DetailsActivity::class.java)
            intent.putExtra( Constants.POSITION_QURAAN,index)
            startActivity(intent)
        }
        binding.recyclerSora.adapter = adapter
        return binding.root
    }


}