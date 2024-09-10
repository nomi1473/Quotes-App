package com.example.simple_quotes_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simple_quotes_compose_app.screens.QuoteDetails
import com.example.simple_quotes_compose_app.screens.QuoteListScreen
import com.example.simple_quotes_compose_app.ui.theme.SimpleQuotesComposeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(this@MainActivity)

        }
        setContent {
            App()
//            QuoteDetails()
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {
    if(DataManager.currentPage.value == Pages.LISTING) {
        if (DataManager.isDataLoaded.value) {
            QuoteListScreen(DataManager.data) { quote ->
                DataManager.switchPages(quote)
            }
        }
    }
    else{
        DataManager.currrentQuote?.let { QuoteDetails(it) }
    }

}

enum class Pages{
    LISTING, DETAIL
}

