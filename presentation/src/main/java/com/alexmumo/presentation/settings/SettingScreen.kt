package com.alexmumo.presentation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingScreen(
    navController: NavController
) {
    //val settings = viewModel.theme.collectAsState().value ?:0
    Scaffold(
        topBar = {
            Text(text = "Settings")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    SettingScreen(navController = navController)
}



@Composable
fun SettingsItem(
    onClick: (Int) ->Unit,
    theme: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = {
            onClick(theme)
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = "Change Theme")
            Icon(painter = painterResource(id = R.drawable.ic_theme), contentDescription = "text")
        }
    }
}


@Preview
@Composable
fun SettingsItemPreview() {
    //SettingsItem()
}