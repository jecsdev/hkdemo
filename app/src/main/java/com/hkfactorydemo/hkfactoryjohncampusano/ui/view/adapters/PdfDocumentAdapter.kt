package com.hkfactorydemo.hkfactoryjohncampusano.ui.view.adapters

import android.content.Context
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.util.Log
import java.io.*
import java.lang.Exception

class PdfDocumentAdapter(var context: Context, var path: String) : PrintDocumentAdapter() {

    override fun onLayout(
        oldAttributes: PrintAttributes?,
        newAttributes: PrintAttributes?,
        cancellationSignal: CancellationSignal?,
        layoutResultCallback: LayoutResultCallback?,
        extras: Bundle?
    ) {
        if (cancellationSignal!!.isCanceled)
            layoutResultCallback!!.onLayoutCancelled()
        else {
            val builder = PrintDocumentInfo.Builder("file name")
            builder.setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(PrintDocumentInfo.PAGE_COUNT_UNKNOWN)
                .build()
            layoutResultCallback!!.onLayoutFinished(builder.build(), oldAttributes != newAttributes)
        }
    }

    override fun onWrite(
        pages: Array<out PageRange>?,
        parcelFileDescriptor: ParcelFileDescriptor,
        cancellationSignal: CancellationSignal?,
        writeResultCallback: PrintDocumentAdapter.WriteResultCallback
    ) {
        var `in`: InputStream? = null
        var out: OutputStream? = null
        try {
            val file = File(path)
            `in` = FileInputStream(file)
            out = FileOutputStream(parcelFileDescriptor.fileDescriptor)
            if (!cancellationSignal!!.isCanceled) {
                `in`.copyTo(out)
                writeResultCallback.onWriteFinished(arrayOf(PageRange.ALL_PAGES))
            } else {
                writeResultCallback.onWriteCancelled()
            }
        } catch (e: Exception) {
            writeResultCallback.onWriteFailed(e.message)
            Log.e("message", e.message ?: "")
        } finally {
            try {
                `in`!!.close()
                out!!.close()
            } catch (e: IOException) {
                Log.e("message", e.message ?: "")
            }
        }
    }
}