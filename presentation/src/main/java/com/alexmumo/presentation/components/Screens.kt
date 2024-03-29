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
package com.alexmumo.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.presentation.home.HomeViewModel
import com.alexmumo.presentation.navigation.NavItem

@Composable
fun Screens(
    tabs: List<TabItem>,
    pageState: PagerState,
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val generalState = homeViewModel.general.collectAsState().value
    val general = generalState.articles?.collectAsLazyPagingItems()

    val techState = homeViewModel.technology.collectAsState().value
    val technology = techState.articles?.collectAsLazyPagingItems()

    val businessState = homeViewModel.business.collectAsState().value
    val business = businessState.articles?.collectAsLazyPagingItems()

    val sportState = homeViewModel.sports.collectAsState().value
    val sports = sportState.articles?.collectAsLazyPagingItems()

    val healthState = homeViewModel.health.collectAsState().value
    val health = healthState.articles?.collectAsLazyPagingItems()

    HorizontalPager(state = pageState, pageCount = tabs.size) { count ->
        Column(modifier = Modifier.fillMaxSize()) {
            if (count == 0) {
                LazyColumn {
                    general?.let {
                        items(it.itemCount) { index ->
                            general[index]?.let { article ->
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
                    business?.let {
                        items(it.itemCount) { index ->
                            business[index]?.let { article ->
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
            if (count == 2) {
                LazyColumn {
                    technology?.let {
                        items(it.itemCount) { index ->
                            technology[index]?.let { article ->
                                NewsCard(
                                    onNavigate = { article ->
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "news",
                                            value = article
                                        )
                                        navController.navigate(NavItem.Detail.route)
                                    },
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
                                    onNavigate = { article ->
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "news",
                                            value = article
                                        )
                                    },
                                    article = article
                                )
                            }
                        }
                    }
                }
            }

            if (count == 4) {
                LazyColumn {
                    health?.let {
                        items(it.itemCount) { index ->
                            health[index]?.let { article ->
                                NewsCard(
                                    onNavigate = { news ->
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "news",
                                            value = news
                                        )
                                    },
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
