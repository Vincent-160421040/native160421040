package com.dimas.s16042104week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.dimas.s16042104week1.databinding.FragmentGameBinding
import com.dimas.s16042104week1.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentScore = GameFragment.score

        binding.txtFInalScore.text = currentScore.toString()

        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionBackFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}