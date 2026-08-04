import kotlinx.browser.window

actual fun getEpochMillis(): Long = window.performance.now().toLong() // O Date.now() en JS
