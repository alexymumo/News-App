package com.alexmumo.news_app

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashlyticsTree : Timber.Tree() {
    private val crashlytics = FirebaseCrashlytics.getInstance()
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.INFO || priority == Log.DEBUG) {
            return
        }

        crashlytics.setCustomKey(KEY_PRIORITY, priority)
        if (tag != null) {
            crashlytics.setCustomKey(KEY_TAG, tag)
        }
        crashlytics.setCustomKey(KEY_MESSAGE, message)

        if (t == null) {
            crashlytics.recordException(Exception(message))
        } else {
            crashlytics.recordException(t)
        }
        crashlytics.log(message)
    }

    companion object {
        private const val KEY_PRIORITY = "priority"
        private const val KEY_TAG = "tag"
        private const val KEY_MESSAGE = "message"
    }
}

