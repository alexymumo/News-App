/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alexmumo.presentation.bookmarks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.components.BookMarkCard
import com.alexmumo.presentation.navigation.NavItem

@Composable
fun BookMarkScreen(
    navController: NavController,
    viewModel: BookMarkViewModel = hiltViewModel()
) {
    val bookmarks = viewModel.bookMarkedNews.collectAsState(emptyList())
    val delete = viewModel.deleteBookMarkedNews()
    val dismissState = rememberDismissState()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.testTag("top_app_bar_test_tag"),
                title = {
                    Text(
                        text = "Bookmarks",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .testTag("bookmark_test_tag")
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(items = bookmarks.value) { bookMarkEntity ->
                BookMarkCard(
                    bookMarkEntity = bookMarkEntity,
                    onNavigate = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "news",
                            value = bookMarkEntity
                        )
                        navController.navigate(NavItem.Detail.route)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun BookMarkScreenPreview() {
    val navController = rememberNavController()
    BookMarkScreen(navController = navController)
}

/*if(dismissState.isDismissed(DismissDirection.EndToStart)) {
    viewModel.deleteBookMarkedNews()
}
SwipeToDismiss(
    state = dismissState,
    background = {
        DeleteCard(dismissState = dismissState)
    },
    directions = setOf(DismissDirection.EndToStart),
    dismissContent = {
        BookMarkCard(bookMarkEntity = bookMark)
    }
)
*/
