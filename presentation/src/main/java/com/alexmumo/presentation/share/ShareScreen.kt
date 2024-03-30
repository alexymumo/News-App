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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ShareScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(text = "Share")
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
            // Implement dropdown selector
            OutlinedTextField(
                value = author, onValueChange = {},
                placeholder = { Text(text = "Category") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),

            ) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
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
