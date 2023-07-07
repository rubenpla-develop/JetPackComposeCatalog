package com.rubenpla.jetpackcomposecatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rubenpla.jetpackcomposecatalog.model.SuperHero
import kotlinx.coroutines.launch

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
fun SuperHeroGridView() {
    //  LazyRow(content = { getSuperHeroes() })
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp)
    ) {
        items(getSuperHeroes()) { superHeroItem ->
            ItemHero(superHero = superHeroItem) {
                Toast.makeText(context, "${it.superHeroName} clicked!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroWithSpecialsControlsView() {
    //  LazyRow(content = { getSuperHeroes() })
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()) {
            items(getSuperHeroes()) { superHeroItem ->
                ItemConstraintHero(superHero = superHeroItem) {
                    Toast.makeText(context, "${it.superHeroName} clicked!!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            },
                modifier = Modifier.align(Alignment.CenterHorizontally).background(Color.Transparent)) {

                Text(text = "Button")
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.DarkGray),
        modifier = Modifier
            .width(300.dp)
            .height(150.dp)
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
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp),
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun ItemConstraintHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.DarkGray),
        modifier = Modifier
            .width(300.dp)
            .height(150.dp)
            .clickable { onItemSelected(superHero) }
    ) {
        ConstraintLayout {

            val (heroName, heroRealName, publisher, photo) = createRefs()

            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(photo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = superHero.superHeroName,
                color = Color.White,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(top= 4.dp, start = 8.dp)
                    .constrainAs(heroName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                text = superHero.realName,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 8.dp)
                    .constrainAs(heroRealName) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                )

            Text(
                text = superHero.publisher,
                color = Color.White,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(bottom = 4.dp, end = 8.dp)
                    .constrainAs(publisher) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

private fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "The Witcher",
            realName = "Geralt de Rivia",
            publisher = "Cd Projekt Red",
            R.drawable.geralt
        ),
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