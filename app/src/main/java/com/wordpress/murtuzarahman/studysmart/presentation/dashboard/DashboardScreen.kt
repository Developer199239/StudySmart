package com.wordpress.murtuzarahman.studysmart.presentation.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wordpress.murtuzarahman.studysmart.presentation.components.CountCard

@Composable
fun DashBoardScreen() {
    Scaffold(
        topBar = {
            DashboardScreenTopBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CountCardsSection(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    subjectCount = "5",
                    studiedHours = "10",
                    goalHours = "15"
                )
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "StudySmart123", style = MaterialTheme.typography.headlineMedium)
        }
    )
}

@Composable
private fun CountCardsSection(
    modifier: Modifier = Modifier,
    subjectCount: String,
    studiedHours: String,
    goalHours: String
) {
 Row(
     modifier = modifier
 ){
     CountCard(
         modifier = Modifier.weight(1f),
         headingText = "Subject Count",
         count = subjectCount
     )
     Spacer(modifier = Modifier.width(10.dp))
     CountCard(
         modifier = Modifier.weight(1f),
         headingText = "Studied Hours",
         count = studiedHours
     )
     Spacer(modifier = Modifier.width(10.dp))
     CountCard(
         modifier = Modifier.weight(1f),
         headingText = "Goal Study Hours",
         count = goalHours
     )
 }
}