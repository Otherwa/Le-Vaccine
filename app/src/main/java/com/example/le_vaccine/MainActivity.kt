package com.example.le_vaccine

import android.os.Build
import android.os.Bundle
import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)


    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //webview
        webviewsetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewsetup(){
        main_view.webViewClient = WebViewClient()
        main_view.apply {
            loadUrl("https://drug-lord.onrender.com")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }

        main_view.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(
                origin: String,
                callback: GeolocationPermissions.Callback
            ) {
                callback.invoke(origin, true, false)
            }
        }

    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (main_view.canGoBack())
            main_view.goBack()
        // if your webview cannot go back
        // it will exit the application
        //idk
        else
            super.onBackPressed()
    }
}