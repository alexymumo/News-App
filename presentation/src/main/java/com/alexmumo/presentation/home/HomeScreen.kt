package com.alexmumo.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.domain.model.Article
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    onNavigate:() -> Unit,
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {

    val state = viewModel.uiState.collectAsState().value
    val news = state.articles?.collectAsLazyPagingItems()
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("News App") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)

        ) {
            LazyColumn {
                news?.let {
                    items(it.itemCount) { index ->
                        news[index]?.let { article ->
                            ArticleCard(article = article)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ArticleCard(
    article: Article
) {
    Row {
        article.author?.let { Text(text = it) }
    }
}


@Preview
@Composable
fun ArticlePreview() {
    //ArticleCard()
}

@Preview
@Composable
fun HomeScreePreview() {
    //HomeScreen()
}