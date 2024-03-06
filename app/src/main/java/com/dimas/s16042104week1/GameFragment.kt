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

    companion object {
        var score: Int = 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val random          = Random
        var randomNumber1   = random.nextInt(100) + 1
        var randomNumber2   = random.nextInt(100) + 1
        var answer          = randomNumber1 + randomNumber2
        score = 0

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
                randomNumber1   = random.nextInt(100) + 1
                randomNumber2   = random.nextInt(100) + 1
                answer          = randomNumber1 + randomNumber2
                score++

                binding.txtNum1.text = randomNumber1.toString()
                binding.txtNum2.text = randomNumber2.toString()

                binding.txtScore.text = "Score: $score"
            }
            else{
                val action = GameFragmentDirections.actionResultFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}