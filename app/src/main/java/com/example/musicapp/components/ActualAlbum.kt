package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.MusicAppTheme

@Composable
fun ActualAlbum(
    album: Album,
    onClick : () -> Unit){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 30.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF260F44))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFAF8FF))
        )
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
        ) {
            Text(
                text = album.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = album.artist + " · Popular Song",
                color = Color.LightGray,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "play",
            tint = Color.Gray
        )
    }
}

@Preview
@Composable
fun ActualAlbumView(){
    val testAlbum = Album(
        id = "abc",
        title = "titulo",
        artist = "artista",
        description = "descripcion.",
        image = "https://ejemplo.com/camiseta.png",
    )
    MusicAppTheme {
        ActualAlbum(
            album = testAlbum,
            onClick = {  }
        )
    }
}