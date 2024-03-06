package com.dimas.s16042104week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.dimas.s16042104week1.databinding.FragmentGameBinding
import com.dimas.s16042104week1.databinding.FragmentMainBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private lateinit var  binding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val random          = Random
        val randomNumber1   = random.nextInt(100) + 1
        val randomNumber2   = random.nextInt(100) + 1
        val answer          = randomNumber1 + randomNumber2
        var score: Int      = 0

        binding.txtNum1.text = randomNumber1.toString()
        binding.txtNum2.text = randomNumber2.toString()

            if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }

//        binding.btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

        binding.btnAnswer.setOnClickListener {
            val playerAnswer = binding.txtAnswer.text.toString().toInt()

            if(playerAnswer == answer){
                score++
                binding.txtScore.text = "Score: $score"
            }
        }
    }
}