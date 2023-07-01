package com.rubenpla.jetpackcomposecatalog

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun simpleRecyclerView() {
    val list = listOf("Item #1",
        "Item #2",
        "Item #3",
        "Item #4",
        "Item #5",
        "Item #6",
        "Item #7",
        "Item #8",
        "Item #9",
        "Item #10",
        "Item #11",
        "Item #12",
    )

    LazyColumn {
        item { Text(text = "RecyclerView HEADER", fontWeight = FontWeight.Bold, fontSize = 22.sp) }
//        items(7) {
//            Text(text = "This is the it $it")
//        }
        items(list) {
            Text(text = "This is the $it")
        }

        item { Text(text = "RecyclerView FOOTER", fontWeight = FontWeight.Bold, fontSize = 22.sp) }
    }
}