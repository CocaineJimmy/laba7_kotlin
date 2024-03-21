package com.topic2.android.notes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.topic2.android.notes.theme.rwGreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.topic2.android.notes.domain.model.NoteModel
import com.topic2.android.notes.util.fromHex


@Preview
@Composable
fun NoteColorPreview(){
    NoteColor(color = Color.Red, size = 40.dp, padding = 4.dp, border = 2.dp)
}

@Composable
fun Note(
    note: NoteModel,
    onNoteClick: (NoteModel) -> Unit = {},
    onNoteCheckedChange: (NoteModel) -> Unit = {}
){
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    Row(modifier = Modifier
        .padding(8.dp)
        .shadow(1.dp, backgroundShape)
        .fillMaxWidth()
        .heightIn(min = 64.dp)
        .background(Color.White, backgroundShape)) {
        Row(modifier = Modifier.fillMaxSize()) {
            NoteColor(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 16.dp),
                color = Color.fromHex(note.color.hex),
                size = 40.dp,
                border = 1.dp
            )
            Column(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)) {
                Text(text = note.title, maxLines = 1,
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        letterSpacing = 0.15.sp)
                )
                Text(text = note.content, maxLines = 1,
                    color = Color.Black.copy(alpha = 0.75f),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        letterSpacing = 0.25.sp
                    ))
            }
            if (note.isCheckedOff !=null)
                Checkbox(
                    checked = note.isCheckedOff,
                    onCheckedChange = { },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
        }
        }
    }
}

@Preview
@Composable
private fun NotePreview(){
    Note(
        note = NoteModel(
            1,
            "Заметка 1",
            "Содержимое 1",
            null)
    )
}