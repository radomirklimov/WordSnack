package com.example.wordsnack.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordsnack.R
import com.example.wordsnack.room.WordEntity
import com.example.wordsnack.room.WordViewModel

object AddWordButton {
    val popUp = AddWordPopUp

    @Composable
    fun mainPageMix(){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            addNewWord(viewModel)
        }
    }

    @Composable
    fun addNewWord(viewModel: WordViewModel) {
        var showPopUp = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(120.dp)
        ) {

            Button(
                onClick = { showPopUp.value = true },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
                    .size(300.dp, 80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Add Icon",
                    modifier = Modifier
                        .size(50.dp)
                )
                Text(
                    text = "Add new word",
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
            }
            AddWordPopUp.windowUp(showPopUp, viewModel)

            AllWords.displayWords(viewModel)
        }
    }

    @Composable
    fun displayWords(viewModel: WordViewModel) {
        var words by remember { mutableStateOf<List<WordEntity>>(listOfNotNull()) }

        LaunchedEffect(Unit) {
            words = viewModel.fetchAllWords()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            for (word in words) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.LightGray)
                        .padding(10.dp)
                ) {
                    Text(text = word.word)
                    Text(text = word.translation)
                    Text(text = word.transcription)
                }
            }
        }
    }

}