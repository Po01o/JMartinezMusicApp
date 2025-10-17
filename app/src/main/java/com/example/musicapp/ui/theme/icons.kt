package com.example.musicapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Pause: ImageVector
    get() {
        if (_Pause != null) return _Pause!!

        _Pause = ImageVector.Builder(
            name = "Pause",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(520f, 760f)
                verticalLineToRelative(-560f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(560f)
                close()
                moveToRelative(-320f, 0f)
                verticalLineToRelative(-560f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(560f)
                close()
                moveToRelative(400f, -80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-400f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(-320f, 0f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-400f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(0f, -400f)
                verticalLineToRelative(400f)
                close()
                moveToRelative(320f, 0f)
                verticalLineToRelative(400f)
                close()
            }
        }.build()

        return _Pause!!
    }

private var _Pause: ImageVector? = null

val SkipForward: ImageVector
    get() {
        if (_SkipForward != null) return _SkipForward!!

        _SkipForward = ImageVector.Builder(
            name = "SkipForward",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(15.5f, 3.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, 0.5f)
                verticalLineToRelative(8f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, -1f, 0f)
                verticalLineTo(8.752f)
                lineToRelative(-6.267f, 3.636f)
                curveToRelative(-0.52f, 0.302f, -1.233f, -0.043f, -1.233f, -0.696f)
                verticalLineToRelative(-2.94f)
                lineToRelative(-6.267f, 3.636f)
                curveTo(0.713f, 12.69f, 0f, 12.345f, 0f, 11.692f)
                verticalLineTo(4.308f)
                curveToRelative(0f, -0.653f, 0.713f, -0.998f, 1.233f, -0.696f)
                lineTo(7.5f, 7.248f)
                verticalLineToRelative(-2.94f)
                curveToRelative(0f, -0.653f, 0.713f, -0.998f, 1.233f, -0.696f)
                lineTo(15f, 7.248f)
                verticalLineTo(4f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
                moveTo(1f, 4.633f)
                verticalLineToRelative(6.734f)
                lineTo(6.804f, 8f)
                close()
                moveToRelative(7.5f, 0f)
                verticalLineToRelative(6.734f)
                lineTo(14.304f, 8f)
                close()
            }
        }.build()

        return _SkipForward!!
    }

private var _SkipForward: ImageVector? = null

