package india.learn.lifeline.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import india.learn.lifeline.R
import india.learn.lifeline.ui.theme.LifeLineTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetUpHomeComponent(innerPadding)
                }
            }
        }
    }
}

@Composable
private fun SetUpHomeComponent(innerPadding: PaddingValues) {
    val homeObjects = prepareDataObject()
    LazyColumn(
        modifier = Modifier.padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
            TopImageIcons()
        }
        item {
            SearchBar(query = "", onQueryChanged = {

            }, onMenuClick = {

            }) {

            }
        }
        items(homeObjects.chunked(2)) { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HomeItems(pair[0])
                Spacer(modifier = Modifier.width(16.dp))
                if (pair.size > 1) {
                    HomeItems(pair[1])
                }
            }
        }
    }
}

@Composable
private fun HomeItems(data: HomeObject) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 8.dp),
    ) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.opd),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = data.title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onMenuClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = Color.White, // Background color
                shape = RoundedCornerShape(8.dp) // Rounded corners
            )
            .padding(horizontal = 8.dp) // Padding inside the Box
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            // Menu icon on the start
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
            }

            // Search text field
            TextField(
                value = query,
                onValueChange = onQueryChanged,
                placeholder = { Text(text = "Search...") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
            )

            // Search icon on the end
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search, // Replace with your search icon resource
                    contentDescription = "Search Icon"
                )
            }
        }
    }
}

@Composable
fun TopImageIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image 1
        Image(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Image 1",
            modifier = Modifier
                .size(40.dp) // Size of the image
        )

        Image(
            imageVector = Icons.Default.Menu,
            contentDescription = "Image 2",
            modifier = Modifier
                .size(40.dp) // Size of the image
        )

        // Image 3
        Image(
            imageVector = Icons.Default.Menu,
            contentDescription = "Image 3",
            modifier = Modifier
                .size(40.dp) // Size of the image
        )
    }
}

data class HomeObject(val imageRes: Int, val title: String)

private fun prepareDataObject(): ArrayList<HomeObject> {
    return arrayListOf(
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd"),
        HomeObject(R.drawable.opd, "Opd")
    )
}
