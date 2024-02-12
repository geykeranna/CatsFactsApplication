package com.example.catsfactsapplication.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catsfactsapplication.data.models.cats_api.CatFactsGetResponseItem

@Composable
fun FactsCard(
    facts: CatFactsGetResponseItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp)
            .border(2.dp, Color.White, RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imgMap = CatsImg.img

        imgMap[(0..<imgMap.size).random()]?.let { it -> painterResource(id = it) }?.let { img ->
            Image(
                modifier = Modifier
                    .padding(10.dp)
                    .size(74.dp),
                painter = img,
                alignment = Alignment.TopCenter,
                contentDescription = "Just random cats"
            )
        }

        Text(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
            ,
            text = facts.fact,
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

    }
}