package com.example.courtcounter_viewmodellivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewHolder : ViewModel() {
    private var _scoreTeamA = MutableLiveData(0)
    val scoreTeamA: LiveData<Int>
        get() = _scoreTeamA
    private var _scoreTeamB = MutableLiveData(0)
    val scoreTeamB: LiveData<Int>
        get() = _scoreTeamB
    fun addPointsForTeamA(ptValue: Int) {
        val currentPoints = scoreTeamA.value ?: 0
        _scoreTeamA.value = currentPoints + ptValue
    }

    fun addPointsForTeamB(ptValue: Int) {
        val currentPoints = scoreTeamB.value ?: 0
        _scoreTeamB.value = currentPoints + ptValue
    }
    fun resetScore() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}