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
package com.alexmumo.repository.repository

import com.alexmumo.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun registerUser(name: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logOutUser() {
        TODO("Not yet implemented")
    }
}