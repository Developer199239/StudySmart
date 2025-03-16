package com.wordpress.murtuzarahman.studysmart.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wordpress.murtuzarahman.studysmart.R
import com.wordpress.murtuzarahman.studysmart.domain.model.Subject
import com.wordpress.murtuzarahman.studysmart.presentation.components.CountCard
import com.wordpress.murtuzarahman.studysmart.presentation.components.SubjectCard

@Composable
fun DashBoardScreen() {
    val subjects = listOf(
        Subject(
            name = "English",
            goalHours = 15f,
            colors = Subject.subjectCardColors[0]
        ),
        Subject(
            name = "Bangla",
            goalHours = 10f,
            colors = Subject.subjectCardColors[3]
        ),
        Subject(
            name = "Math",
            goalHours = 12f,
            colors = Subject.subjectCardColors[2]
        ),
        Subject(
            name = "Data Structure",
            goalHours = 20f,
            colors = Subject.subjectCardColors[4]
        ),
        Subject(
            name = "Algorithm",
            goalHours = 15f,
            colors = Subject.subjectCardColors[1]
        )
    )
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = "5",
                    studiedHours = "10",
                    goalHours = "15"
                )
            }
            item {
                SubjectCardSection(
                    modifier = Modifier.fillMaxWidth(),
                    subjectList = subjects,
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
            Text(text = "StudySmart", style = MaterialTheme.typography.headlineMedium)
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

@Composable
fun SubjectCardSection(
    modifier: Modifier = Modifier,
    subjectList: List<Subject>,
    emptyListText: String = "You don't have any upcoming tasks.\n " +
            "Click the + button in subject screen to add new task."
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
           Text(
               text = "Subjects",
               style = MaterialTheme.typography.bodySmall,
               modifier = Modifier.padding(start = 12.dp)
           )
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subject"
                )
            }

        }

        if(subjectList.isEmpty()) {
           Image(
           modifier = Modifier.size(120.dp).align(Alignment.CenterHorizontally),
               painter = painterResource(R.drawable.img_books),
               contentDescription = ""
           )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
          items(subjectList) {subject->
            SubjectCard(
                subjectName = subject.name,
                gradientColors = subject.colors,
                onclick = {}
            )
          }
        }
    }
}