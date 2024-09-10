package com.example.simple_quotes_compose_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_quotes_compose_app.R
import com.example.simple_quotes_compose_app.model.Quote

@Composable
fun QuoteListItem(quote: Quote = Quote("This is a quote", "Author"), onCLick: () -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.clickable {
            onCLick()
        }.padding(horizontal = 16.dp).padding(top = 16.dp),
        shape = RoundedCornerShape(6.dp)

    ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    quote.quote,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )

                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                )
                Text(
                    quote.author,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.bodyMedium
                )

            }


        }
    }
}



