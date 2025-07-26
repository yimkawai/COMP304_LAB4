
@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.kawai.kawaiyim_comp304lab4.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kawai.kawaiyim_comp304lab4.model.Landmark

@Composable
fun ItemScreen(
    landmarks: List<Landmark>,
    onSelect: (Landmark) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(landmarks.firstOrNull()?.category ?: "Items") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { pad ->
        LazyColumn(contentPadding = pad) {
            items(landmarks) { lm ->
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clickable { onSelect(lm) }
                        .padding(16.dp)
                ) {
                    Text(lm.name, style = MaterialTheme.typography.titleMedium)
                    Text(lm.address, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
