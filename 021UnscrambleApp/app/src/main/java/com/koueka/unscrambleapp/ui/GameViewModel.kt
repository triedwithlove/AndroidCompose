package com.koueka.unscrambleapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.koueka.unscrambleapp.data.MAX_NO_OF_WORDS
import com.koueka.unscrambleapp.data.SCORE_INCREASE
import com.koueka.unscrambleapp.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    //Game UI state

    //Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    //to save the current scrambled word
    private lateinit var currentWord: String

    //Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()

    //
    var userGuess by mutableStateOf("")
        private set

    //pick a random word and shuffle
    private fun pickRandomWordAndShuffle(): String {
        //Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            //pick again
            return pickRandomWordAndShuffle()
        }
        //update the useWords collection and shuffle the word
        usedWords.add(currentWord)
        return shuffleCurrentWord(currentWord)
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord: CharArray = word.toCharArray()
        //Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambleWord = pickRandomWordAndShuffle())
    }

    init {
        resetGame()
    }

    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    fun checkUserGuess() {
        android.util.Log.d("MainActivity", "userGuess = $userGuess currentWord = $currentWord")
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            //User's guess is correct, increase the score
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            //Prepare the game for the next round
            updateGameState(updatedScore)
        } else {
            //User's guess is wrong, show an error
            _uiState.update { currentState -> currentState.copy(isGuessedWordWrong = true) }
        }
        //Reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int) {
        if (MAX_NO_OF_WORDS == usedWords.size) {
            //Last round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            //Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambleWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc()
                )
            }
        }
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        //Reset user guess
        updateUserGuess("")
    }



}