package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.MusicAppTheme
import com.example.musicapp.ui.theme.Pause
import com.example.musicapp.ui.theme.SkipForward


@Composable
fun AlbumSelected(
    album: Album,
    onClick : () -> Unit){
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 45.dp)
            .fillMaxWidth()
            .height(390.dp)
            .clip(RoundedCornerShape(30.dp))
    ) {
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f)
                        )
                    )
                )
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable() {

                        }
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(15.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable() {

                        }
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(15.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = album.title,
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = album.artist,
                fontSize = 20.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.SemiBold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "play",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clip(CircleShape)
                        .clickable() {

                        }
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF946CF6),
                                    Color(0xFF744BF5)
                                )
                            )
                        )
                        .size(60.dp)
                        .padding(15.dp)
                )
                Icon(
                    imageVector = SkipForward,
                    contentDescription = "skip",
                    tint = Color(0xFF744BF5),
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clip(CircleShape)
                        .clickable() {

                        }
                        .background(Color.White)
                        .size(60.dp)
                        .padding(15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun AlbumSelectedView(){
    val testAlbum = Album(
        id = "abc",
        title = "titulo",
        artist = "artista",
        description = "descripcion.",
        image = "https://ejemplo.com/camiseta.png",
    )
    MusicAppTheme {
        AlbumCard(
            album = testAlbum,
            onClick = {  }
        )
    }
}