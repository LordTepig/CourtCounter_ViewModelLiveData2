package com.example.courtcounter_viewmodellivedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.courtcounter_viewmodellivedata2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var scoreTeamA = 0
    var scoreTeamB = 0

    private val viewModel: GameViewHolder by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.scoreTeamA.observe(this) {    newScore ->
            binding.teamAScore.text = newScore.toString()
        }
        viewModel.scoreTeamB.observe(this) {    newScore ->
            binding.teamBScore.text = newScore.toString()
        }

        setupClickListeners()

    }

    private fun setupClickListeners() {
        binding.teamA3.setOnClickListener {
            viewModel.addPointsForTeamA(3)
        }

        binding.teamB3.setOnClickListener {
            viewModel.addPointsForTeamB(3)
        }

        binding.teamA2.setOnClickListener {
            viewModel.addPointsForTeamA(2)
        }

        binding.teamB2.setOnClickListener {
            viewModel.addPointsForTeamB(2)
        }

        binding.teamAFree.setOnClickListener {
            viewModel.addPointsForTeamA(1)
        }

        binding.teamBFree.setOnClickListener {
            viewModel.addPointsForTeamB(1)
        }

        binding.reset.setOnClickListener {
            viewModel.resetScore()
        }

    }
}