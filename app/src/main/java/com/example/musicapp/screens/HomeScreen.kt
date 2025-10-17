package com.example.musicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.musicapp.components.ActualAlbum
import com.example.musicapp.components.AlbumCard
import com.example.musicapp.components.Header
import com.example.musicapp.components.RecentlyPlayedCard
import com.example.musicapp.models.Album
import com.example.musicapp.services.AlbumService
import com.example.musicapp.ui.theme.MusicAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun HomeScreen(
    navController: NavController
) {
    /*
    *
    *
    *
    *
     */
    var albums by remember {
        mutableStateOf(listOf<Album>())
    }
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) { //Para que la llamada a la api se realice solo una vez, cuando esta cargando la app
        try {
            //1. Crear una instancia de retrofit
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllAlbums()
            }
            Log.i("HomeScreen", "${result.await()}")
            albums = result.await()
            loading = false
        }
        catch (e: Exception){
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }

    if(loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
    else
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE0D6FC),
                            Color(0xFFFFFFFF)
                        )//#744BF5
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 115.dp)
                        .padding(bottom = 90.dp),
                    contentPadding = PaddingValues(bottom = 50.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(bottom = 10.dp, top = 70.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "Albums",
                                color = Color.Black,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "See more",
                                color = Color(0xFF744BF5),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 15.dp)
                        ) {
                            items(albums) { album ->
                                AlbumCard(
                                    album = album,
                                    onClick = {

                                    }
                                )
                            }
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(vertical = 10.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "Recently Played",
                                color = Color.Black,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "See more",
                                color = Color(0xFF744BF5),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    /*LazyColumn(
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                        ) {*/
                    items(albums) { album ->
                        RecentlyPlayedCard(
                            album = album,
                            onClick = {

                            }
                        )
                    }
                }
                Column(){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.verticalGradient(
                                    colorStops = arrayOf(
                                        0.0f to Color(0xFFE0D6FC),
                                        0.7f to Color(0xFFE0D6FC),
                                        1.0f to Color.Transparent
                                    )
                                )
                            )
                    ) {
                        Header()
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    ActualAlbum(

                        album = albums[0],
                        onClick = {

                        }
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    MusicAppTheme {
        HomeScreen(rememberNavController())
    }
}