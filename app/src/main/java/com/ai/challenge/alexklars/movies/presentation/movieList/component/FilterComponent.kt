package com.ai.challenge.alexklars.movies.presentation.movieList.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ai.challenge.alexklars.movies.presentation.movieList.FilterState

@Composable
fun FilterComponent(
    filterState: FilterState,
    onFilterSelected: (FilterState) -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(16.dp)
        .clickable { showDialog = true }) {
        Text(
            text = "Filter By:",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Price: ${filterState.displayName}",
        )
    }

    if (showDialog) {
        FilterDialog(
            filterState = filterState,
            onDismiss = { showDialog = false },
            onApplyFilter = {
                showDialog = false
                onFilterSelected(it)
            },
        )
    }
}

@Composable
private fun FilterDialog(
    filterState: FilterState,
    onDismiss: () -> Unit,
    onApplyFilter: (FilterState) -> Unit
) {
    var minPrice by rememberSaveable {
        mutableStateOf(
            (filterState as? FilterState.PriceRange)?.minPrice?.toString() ?: ""
        )
    }
    var maxPrice by rememberSaveable {
        mutableStateOf(
            (filterState as? FilterState.PriceRange)?.maxPrice?.toString() ?: ""
        )
    }
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Column {
                Text(
                    text = "Filter By Price",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = minPrice,
                    onValueChange = { minPrice = it },
                    label = { Text("Min Price") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                OutlinedTextField(
                    value = maxPrice,
                    onValueChange = { maxPrice = it },
                    label = { Text("Max Price") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
            }
        },
        buttons = {
            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 24.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Button(
                    onClick = {
                        val min = minPrice.toDoubleOrNull()
                        val max = maxPrice.toDoubleOrNull()
                        val filter = when {
                            min != null && max != null -> FilterState.PriceRange(min, max)
                            else -> FilterState.NONE
                        }
                        onApplyFilter(filter)
                    }
                ) {
                    Text("Apply")
                }
            }
        },
    )
}

private val FilterState.displayName: String
    get() = when (this) {
        is FilterState.NONE -> "None"
        is FilterState.PriceRange -> "Min= $minPrice, Max= $maxPrice"
    }
