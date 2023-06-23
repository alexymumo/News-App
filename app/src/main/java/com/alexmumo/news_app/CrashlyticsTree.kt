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
