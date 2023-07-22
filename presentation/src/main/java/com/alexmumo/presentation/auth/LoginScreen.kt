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
package com.alexmumo.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .testTag("login_tag")
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome Back",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        var name by remember { mutableStateOf("Name") }
        var email by remember { mutableStateOf("Email") }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            elevation = CardDefaults.cardElevation(focusedElevation = 20.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Forgot Password?",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Left
        )
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Log In",
                maxLines = 1,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Don't have an account?, Register",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
