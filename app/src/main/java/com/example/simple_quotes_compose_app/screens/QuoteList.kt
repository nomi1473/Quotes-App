package com.example.simple_quotes_compose_app.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simple_quotes_compose_app.model.Quote


@Composable
fun QuoteList(list : Array<Quote>, onCLick : (Quote) -> Unit) {

    LazyColumn {
        items(list.size) {
            QuoteListItem(quote = list[it]){
                onCLick(list[it])
            }
        }

    }
}