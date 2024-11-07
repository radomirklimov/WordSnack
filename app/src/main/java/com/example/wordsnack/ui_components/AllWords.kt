package com.example.wordsnack.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import com.example.wordsnack.room.WordEntity
import com.example.wordsnack.room.WordViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

object AllWords {
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