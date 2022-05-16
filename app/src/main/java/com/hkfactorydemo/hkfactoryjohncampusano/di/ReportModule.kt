package com.hkfactorydemo.hkfactoryjohncampusano.di

import android.app.Activity
import android.content.Context
import android.print.PrintAttributes
import android.print.PrintManager
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hkfactorydemo.hkfactoryjohncampusano.R
import com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters.PdfDocumentAdapter
import java.io.File

object ReportModule {
    fun getAppPath(context: Context, name: String = "report.pdf"): String {
        val separator = File.separator
        val dir = File(
            context.applicationContext.cacheDir.toString()
                    + File.separator
                    + context.resources.getString(R.string.app_name)
                    + separator
        )
        if (dir.exists())
            dir.delete()

        dir.mkdir()


        return dir.path + separator + name
    }


}