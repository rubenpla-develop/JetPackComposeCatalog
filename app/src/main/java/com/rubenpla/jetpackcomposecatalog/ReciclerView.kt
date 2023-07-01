package com.rubenpla.jetpackcomposecatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rubenpla.jetpackcomposecatalog.model.SuperHero

@Composable
fun simpleRecyclerView() {
    val list = listOf(
        "Item #1",
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

@Composable
fun SuperHeroRecyclerView() {
    //  LazyRow(content = { getSuperHeroes() })
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superHeroItem ->
            ItemHero(superHero = superHeroItem) {
                Toast.makeText(context, "${it.superHeroName} clicked!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }
    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp),
                fontSize = 10.sp
            )
        }
    }
}

private fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "Spiderman",
            realName = "Peter Parker",
            publisher = "Marvel",
            R.drawable.spiderman
        ),
        SuperHero("Wolverine", realName = "James Howlett", publisher = "Marvel", R.drawable.logan),
        SuperHero("Batman", realName = "Bruce Wayne", publisher = "DC", R.drawable.batman),
        SuperHero("Thor", realName = "Thor Odinson", publisher = "Marvel", R.drawable.thor),
        SuperHero("Flash", realName = "Jay Garrick", publisher = "DC", R.drawable.flash),
        SuperHero(
            "Green Lantern",
            realName = "Alan Scott",
            publisher = "DC",
            R.drawable.green_lantern
        ),
        SuperHero(
            "Wonder Woman",
            realName = "Princess Diana",
            publisher = "DC",
            R.drawable.wonder_woman
        )
    )
}