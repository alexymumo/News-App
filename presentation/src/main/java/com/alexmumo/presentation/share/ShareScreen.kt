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
package com.alexmumo.presentation.share

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ShareScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.testTag("top_bar_test_tag"),
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = "Share",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 18.sp
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(all = 4.dp)
                .testTag("share_screen_test_tag")
        ) {
            val title by remember { mutableStateOf("") }
            val description by remember { mutableStateOf("") }
            val date by remember { mutableStateOf("") }
            val author by remember { mutableStateOf("") }
            OutlinedTextField(
                value = title, onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = {
                    Text(text = "Title")
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = description, onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3,
                placeholder = {
                    Text(text = "Description")
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = date, onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = {
                    Text(text = "Location")
                }
            )
            Spacer(modifier = Modifier.height(4.dp))

            var selectedCategory by remember { mutableStateOf("") }
            var expanded by remember { mutableStateOf(false) }
            var categories = listOf("Technology", "Sports", "Health", "Others", "Education")
            var textField by remember {
                mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
            }
            val icon = if (expanded)
                Icons.Filled.ArrowDropDown
            else
                Icons.Filled.ArrowDropDown

            Box {
                OutlinedTextField(
                    value = selectedCategory,
                    onValueChange = { selectedCategory = it },
                    placeholder = { Text(text = "Category") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { layoutCoordinates ->
                            textField = layoutCoordinates.size.toSize()
                        },
                    trailingIcon = {
                        Icon(icon, contentDescription = "Image", Modifier.clickable { expanded = !expanded })
                    }
                )
                DropdownMenu(
                    expanded = expanded, onDismissRequest = { expanded = false },
                    modifier = Modifier.width(with(LocalDensity.current) { textField.width.toDp() })
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(text = {
                            Text(text = category)
                        }, onClick = { selectedCategory = category })
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                colors = CardDefaults.cardColors(
                    contentColor = Color.LightGray
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "+",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth().testTag("share_test_tag")
            ) {
                Text(text = "Share")
            }
        }
    }
}

@Preview
@Composable
fun UploadScreenPreview() {
    val navController = rememberNavController()
    ShareScreen(navController = navController)
}
