package com.project.news.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TagList(tags: List<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.chunked(3).forEach { rowTags ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowTags.forEach { tag ->
                    AssistChip(
                        onClick = {},
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color.LightGray.copy(alpha = 0.3f)
                        ),
                        label = { Text("#$tag") }
                    )
                }
            }
        }
    }
}