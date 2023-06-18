package com.ai.challenge.alexklars.movies.presentation.movieList.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ai.challenge.alexklars.movies.presentation.movieList.model.SortType

@Composable
fun SortOptionsComponent(
    modifier: Modifier = Modifier,
    sortType: SortType,
    onSortSelected: (SortType) -> Unit,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 8.dp,
        )
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Sort By: ")
                }
                append(sortType.displayName)
            },
            modifier = Modifier
                .clickable { expanded = true }
                .padding(16.dp)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            sortOptions.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onSortSelected(option)
                        expanded = false
                    },
                ) {
                    Text(
                        text = option.displayName,
                        style = if (option == sortType) TextStyle(fontWeight = FontWeight.Bold)
                        else TextStyle(fontWeight = FontWeight.Normal)
                    )
                }
            }
        }
    }
}

private val sortOptions = listOf(
    SortType.NONE,
    SortType.PRICE_LOW_TO_HIGH,
    SortType.PRICE_HIGH_TO_LOW,
    SortType.NAME_A_TO_Z,
    SortType.NAME_Z_TO_A
)

private val SortType.displayName: String
    get() = when (this) {
        SortType.NONE -> "None"
        SortType.PRICE_LOW_TO_HIGH -> "Price: Low to High"
        SortType.PRICE_HIGH_TO_LOW -> "Price: High to Low"
        SortType.NAME_A_TO_Z -> "Name: A to Z"
        SortType.NAME_Z_TO_A -> "Name: Z to A"
    }
