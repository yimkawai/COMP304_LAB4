@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.kawai.kawaiyim_comp304lab4.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import androidx.navigation.NavType

@Composable
fun CategoryScreen(
    categories: List<String>,
    onSelect: (String) -> Unit
) {
    Scaffold(topBar = { TopAppBar(title = { Text("Categories") }) }) { pad ->
        LazyColumn(contentPadding = pad) {
            items(categories) { cat ->
                Text(
                    cat,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelect(cat) }
                        .padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
