package com.alexmumo.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.presentation.components.NewsCard
import com.alexmumo.presentation.navigation.NavItem
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val state = viewModel.uiState.collectAsState().value
    val news = state.articles?.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("News App") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .testTag("home_test")

        ) {
            RowItem(viewModel = viewModel, navController = navController)
        }
    }
}

sealed class TabItem(val title: String) {
    object GeneralItem: TabItem("General")
    object BusinessItem: TabItem("Business")
    object TechItem: TabItem("Technology")
    object EntertainmentItem: TabItem("Entertainment")
    object HealthItem: TabItem("Health")
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowItem(
    viewModel: HomeViewModel = getViewModel(),
    navController: NavController
) {
    val tabs = listOf(TabItem.GeneralItem, TabItem.BusinessItem, TabItem.EntertainmentItem, TabItem.TechItem, TabItem.HealthItem)
    val pageState = rememberPagerState()
    Tabs(tabs = tabs, pageState = pageState)
    Screens(tabs = tabs, pageState = pageState, homeViewModel = viewModel, navController = navController)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    tabs:List<TabItem>,
    pageState: PagerState
) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pageState.currentPage,
        contentColor = Color.White
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                text = {
                    Text(
                        text = tabItem.title,
                        maxLines = 1,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Thin
                    )
                },
                selected = pageState.currentPage == index,
                onClick = {
                scope.launch {
                    pageState.animateScrollToPage(index)
                }
            }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Screens(
    tabs: List<TabItem>,
    pageState: PagerState,
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val homeState = homeViewModel.uiState.collectAsState().value
    val news = homeState.articles?.collectAsLazyPagingItems()

    val techState = homeViewModel.technology.collectAsState().value
    val tech = techState.articles?.collectAsLazyPagingItems()

    val healthState = homeViewModel.health.collectAsState().value
    val health = healthState.articles?.collectAsLazyPagingItems()

    val businessState = homeViewModel.business.collectAsState().value
    val business = businessState.articles?.collectAsLazyPagingItems()

    val sportState = homeViewModel.sports.collectAsState().value
    val sports = sportState.articles?.collectAsLazyPagingItems()


    HorizontalPager(state = pageState,pageCount = tabs.size) { count ->
        Column(modifier = Modifier.fillMaxSize()) {
            if (count == 0) {
                LazyColumn {
                    tech?.let {
                        items(it.itemCount) { index ->
                            tech[index]?.let { article ->
                                NewsCard(
                                    onNavigate = { article ->
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "news",
                                            value = article
                                        )
                                        navController.navigate(NavItem.Detail.route)
                                    },
                                    article = article
                                )
                            }
                        }
                    }
                }
            }
            if (count == 1) {
                LazyColumn {
                    health?.let {
                        items(it.itemCount) { index ->
                            health[index]?.let { article ->
                                NewsCard(
                                    onNavigate = { article -> it },
                                    article = article)
                            }
                        }
                    }
                }
            }
            if (count == 2) {
                LazyColumn {
                    news?.let {
                        items(it.itemCount) { index ->
                            news[index]?.let { article ->
                                NewsCard(
                                    onNavigate = { article -> it },
                                    article = article,
                                )
                            }
                        }
                    }
                }
            }
            if (count == 3) {
                LazyColumn {
                    sports?.let {
                        items(it.itemCount) { index ->
                            sports[index]?.let { article ->
                                NewsCard(
                                    onNavigate = {article -> it },
                                    article = article
                                )
                            }
                        }
                    }
                }
            }

            if (count == 4) {
                LazyColumn {
                    business?.let {
                        items(it.itemCount) { index ->
                            business[index]?.let {article ->
                                NewsCard(
                                    onNavigate = {article -> it },
                                    article = article
                                )
                            }
                        }
                    }
                }
            }
        }        
    }
}

@Preview
@Composable
fun HomeScreePreview() {
    //HomeScreen()
}