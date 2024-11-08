package com.example.wordsnack.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wordsnack.R

object WordPage {
    @Composable
    fun TheWord(
        navController: NavController,
        word: String,
        partOfSpeech: String,
        transcription: String,
        translation: String
    ){
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Yellow)
                    .padding(10.dp)
            ) {
                Text(text = word)
                Text(text = partOfSpeech)
                Text(text = transcription)
                Text(text = translation)
            }

            Button(
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "BACK")
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(id = R.string.app_name)
                )

            }
        }
    }
}