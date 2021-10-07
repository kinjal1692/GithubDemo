package com.example.githubdemo.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

const val DF_DD_MMMM = "dd MMMM"
const val DF_YYYY_MM_DD_T_HH_MM_SS_GMT = "yyyy-MM-dd'T'HH:mm:ssZ"

fun getBgDrawable(
    context: Context, @ColorRes backgroundColor: Int,
    @DimenRes topLeftRadiusRes: Int = 0,
    @DimenRes topRightRadiusRes: Int = 0,
    @DimenRes bottomRightRadiusRes: Int = 0,
    @DimenRes bottomLeftRadiusRes: Int = 0
): Drawable {
    val topLeftRadius: Float =
        if (topLeftRadiusRes == 0) 0f else context.resources.getDimension(topLeftRadiusRes)
    val topRightRadius: Float =
        if (topRightRadiusRes == 0) 0f else context.resources.getDimension(topRightRadiusRes)
    val bottomRightRadius: Float =
        if (bottomRightRadiusRes == 0) 0f else context.resources.getDimension(bottomRightRadiusRes)
    val bottomLeftRadius: Float =
        if (bottomLeftRadiusRes == 0) 0f else context.resources.getDimension(bottomLeftRadiusRes)
    val shape = GradientDrawable()
    shape.shape = GradientDrawable.RECTANGLE
    shape.cornerRadii = floatArrayOf(
        topLeftRadius,
        topLeftRadius,
        topRightRadius,
        topRightRadius,
        bottomRightRadius,
        bottomRightRadius,
        bottomLeftRadius,
        bottomLeftRadius
    )
    shape.setColor(ContextCompat.getColor(context, backgroundColor))
    return shape
}


fun formatDate(date: String, inputFormat: String, outputFormat: String = DF_DD_MMMM): String {
    return try {
        val oSimpleDf = SimpleDateFormat(outputFormat, Locale.getDefault())
        val iSimpleDf = SimpleDateFormat(inputFormat, Locale.getDefault())
        val d = iSimpleDf.parse(date)
        oSimpleDf.format(d)
    } catch (ex: Exception) {
        date
    }
}

fun prettyCount(number: Number): String? {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val numValue = number.toLong()
    val value = floor(log10(numValue.toDouble())).toInt()
    val base = value / 3
    return if (value >= 3 && base < suffix.size) {
        DecimalFormat("#0.0").format(
            numValue / 10.0.pow((base * 3).toDouble())
        ) + suffix[base]
    } else {
        DecimalFormat("#,##0").format(numValue)
    }
}
