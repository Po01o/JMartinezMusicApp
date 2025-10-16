package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.MusicAppTheme


@Composable
fun AlbumCard(
    album: Album,
    onClick : () -> Unit){
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable() {
                onClick()
            }
    ) {
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier
                .size(150.dp)
                .background(Color.White)
        )
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = album.title,
                        fontSize = 10.sp,
                        color = Color.White
                    )
                    Text(
                        text = album.artist,
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "play",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun AlbumCardView(){
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