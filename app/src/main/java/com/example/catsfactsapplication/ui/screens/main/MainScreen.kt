package com.example.catsfactsapplication.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catsfactsapplication.data.models.cats_api.CatFactsGetResponseItem
import com.example.catsfactsapplication.ui.screens.main.components.FactsCard

@Composable
fun MainScreen(
    facts: List<CatFactsGetResponseItem>
) {
    Text(
        text = "Факты о котах",
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
        ,
        color = Color.White,
        fontSize = 54.sp,
        textAlign = TextAlign.Center
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .padding(top = 70.dp)
    ) {
        items(items = facts){
            FactsCard(facts = it)
        }
    }
}
