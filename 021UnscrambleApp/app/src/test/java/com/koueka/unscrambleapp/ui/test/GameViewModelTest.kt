package com.koueka.unscrambleapp.ui.test

import com.koueka.unscrambleapp.data.MAX_NO_OF_WORDS
import com.koueka.unscrambleapp.data.SCORE_INCREASE
import com.koueka.unscrambleapp.data.getUnscrambledWord
import com.koueka.unscrambleapp.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameViewModelTest {
    private val viewModel: GameViewModel = GameViewModel()


    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        //Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly
        assertFalse(currentGameUiState.isGuessedWordWrong)
        //Assert that score is updated correctly
        assertEquals(20, currentGameUiState.score)

        //Assert that score is updated correctly
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
    }


    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {

        //Given an incorrect word as input
        val incorrectPlayerWord = "and"

        //
        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        //check result
        var currentGameUiState = viewModel.uiState.value
        //Assert that score is unchanged
        assertEquals(0, currentGameUiState.score)
        //Assert that checkUserUserGuess() method updates isGuessedWordWrong correctly
        assertTrue(currentGameUiState.isGuessedWordWrong)

    }


    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {

        val gameUiState = viewModel.uiState.value
        val unScrambleWord = getUnscrambledWord(gameUiState.currentScrambleWord)

        //Assert that current word is scrambled
        assertNotEquals(unScrambleWord, gameUiState.currentScrambleWord)
        //Assert that current word count is set to 1
        assertTrue(1 == gameUiState.currentWordCount)
        //Assert that initially the score is 0
        assertTrue(0 == gameUiState.score)
        //Assert that the wrong word guessed is false
        assertFalse(gameUiState.isGuessedWordWrong)
        //Assert that game is not over
        assertFalse(gameUiState.isGameOver)
    }


    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {

        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambleWord)

        repeat(MAX_NO_OF_WORDS) {
            expectedScore += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            //
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambleWord)
            //Assert that after each correct answer, score is updated correctly
            assertEquals(expectedScore, currentGameUiState.score)
        }

        //Assert that after all questions are answered, the current word count is up-to-date.
        assertTrue(MAX_NO_OF_WORDS == currentGameUiState.currentWordCount)
        //Assert that at the end of the game, the score is 200
        assertEquals(200, currentGameUiState.score)
        //Assert that after 10 questions are answered, the game is over
        assertTrue(currentGameUiState.isGameOver)
    }


    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}