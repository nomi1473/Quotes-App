package com.example.simple_quotes_compose_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_quotes_compose_app.DataManager
import com.example.simple_quotes_compose_app.model.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onCLick: (Quote) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 25.dp)
    ) {
        Text("Quotes List Screen", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        QuoteList(data) {
            onCLick(it)
        }
    }

}