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


    fun printPDF(context: Context, path: String) {
        val printManager = context.getSystemService(Context.PRINT_SERVICE) as PrintManager
        try {
            val printAdapter = PdfDocumentAdapter(context, path)
            printManager.print("Document", printAdapter, PrintAttributes.Builder().build())
        } catch (e: Exception) {
            Log.e("message", e.message ?: "")
        }
    }

    class renderHTML {
        fun renderDocument(activity: Activity, HtmlCode: String) {
            // Create a WebView object specifically for printing
            val webView = WebView(activity)
            webView.webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest) = false

                override fun onPageFinished(view: WebView, url: String) {
                    createWebPrintJob(view, activity)
                }
            }

            // Generate an HTML document on the fly:
            webView.loadDataWithBaseURL(null, HtmlCode, "text/HTML", "UTF-8", null)
        }

        private fun createWebPrintJob(webView: WebView, activity: Activity) {

            // Get a PrintManager instance
            (activity.getSystemService(Context.PRINT_SERVICE) as? PrintManager)?.let { printManager ->

                val jobName = "${activity.getString(R.string.app_name)} Document"

                // Get a print adapter instance
                val printAdapter = webView.createPrintDocumentAdapter(jobName)

                // Create a print job with name and adapter instance
                printManager.print(
                    jobName,
                    printAdapter,
                    PrintAttributes.Builder().build())
            }
        }
    }
}