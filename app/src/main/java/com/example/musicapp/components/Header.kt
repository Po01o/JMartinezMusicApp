package com.example.musicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.ui.theme.MusicAppTheme


@Composable
fun Header(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 45.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF946CF6),
                        Color(0xFF744BF5)
                    )
                )
            )
            .padding(20.dp)
    ){
        Row(
            modifier = Modifier 
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "search",
                tint = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search",
                tint = Color.White
            )
        }
        Text(
            text = "Good Morning!",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Joel Martínez",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun HeaderView(){
    MusicAppTheme {
        Header()
    }
}