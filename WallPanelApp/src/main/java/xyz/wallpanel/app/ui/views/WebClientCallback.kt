package xyz.wallpanel.app.ui.views

import android.webkit.PermissionRequest
import android.webkit.WebView

interface WebClientCallback {
    fun askForWebkitPermission(permission: String, requestCode: Int)

    fun complete()

    fun pageLoadComplete(url: String)

    fun setWebkitPermissionRequest(request: PermissionRequest?)

    var isConnected: Boolean

    fun isFinishing(): Boolean

    fun displayProgress(): Boolean

    fun startReloadDelay()

    fun stopReloadDelay()

    fun certPermissionsShown() : Boolean

    /**
     * Called when the WebView render process has gone (crashed or killed).
     * The implementation should remove the old WebView and replace it with a new one, then reload.
     */
    fun onWebViewRenderProcessGone(crashedWebView: WebView)

}