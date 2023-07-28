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
package com.alexmumo.news_app

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashlyticsTree : Timber.Tree() {
    private val crashlyticsTree = FirebaseCrashlytics.getInstance()

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.DEBUG || priority == Log.VERBOSE || priority == Log.INFO) {
            return
        }

        crashlyticsTree.setCustomKey(KEY_PRIORITY, priority)
        if (tag != null) {
            crashlyticsTree.setCustomKey(KEY_TAG, tag)
        }
        crashlyticsTree.setCustomKey(KEY_MESSAGE, message)
        if (t == null) {
            crashlyticsTree.recordException(Exception(message))
        } else {
            crashlyticsTree.recordException(t)
        }
        crashlyticsTree.log(message)
    }

    companion object {
        private const val KEY_PRIORITY = "priority"
        private const val KEY_TAG = "tag"
        private const val KEY_MESSAGE = "message"
    }
}
