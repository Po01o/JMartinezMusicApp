package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.models.Album
import com.example.musicapp.ui.theme.MusicAppTheme


@Composable
fun AlbumInfo(
    album: Album,
    onClick : () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 20.dp)
            .padding(top = 15.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .padding(start = 15.dp)
            .padding(15.dp),
    ) {
        Text(
            text = "About this album",
            color = Color(0xFF48217f),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = album.description,
            color = Color.Gray,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun AlbumInfoView(){
    val testAlbum = Album(
        id = "abc",
        title = "titulo",
        artist = "artista",
        description = "descripcion.",
        image = "https://ejemplo.com/camiseta.png",
    )
    MusicAppTheme {
        AlbumInfo(
            album = testAlbum,
            onClick = {  }
        )
    }
}