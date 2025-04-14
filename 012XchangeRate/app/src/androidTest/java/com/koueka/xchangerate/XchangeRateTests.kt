package com.koueka.xchangerate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertValueEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.koueka.xchangerate.ui.theme.XchangeRateTheme
import org.junit.Rule
import org.junit.Test

class XchangeRateTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun exchange_1_CAD_to_XAF() {
        composeTestRule.setContent {
            XchangeRateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Xchange(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
//                        .background(Color.LightGray)
                    )
                }
            }
        }
        composeTestRule.onNodeWithText(text = "Amount (\$CAD)").performTextInput("1")
        composeTestRule.onNodeWithContentDescription("direction").assertIsDisplayed()
        //TODO testing images? composeTestRule.onNodeWithTag(R.drawable.canada_flag.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Amount (XAF/CFA)").assert(hasText("416.365"))
    }


    @Test
    fun exchange_1_XAF_to_CAD() {
        composeTestRule.setContent {
            XchangeRateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Xchange(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    )
                }
            }
        }
        composeTestRule.onNodeWithText(text = "Amount (XAF/CFA)").performTextInput("1")
        composeTestRule.onNodeWithContentDescription("direction").assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Amount (\$CAD)").assert(hasText("0.002"))
    }
}