package com.example.tarot

import kotlinx.browser.window

actual fun getEpochMillis(): Long = window.performance.now().toLong()
