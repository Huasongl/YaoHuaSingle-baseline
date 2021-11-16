package com.yaohua.studies.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.icu.util.Measure
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import java.lang.Long.max
import java.net.Inet4Address

class FlowLayout @JvmOverloads constructor(
    context: Context, attrs:AttributeSet? = null, defStyleAttr:Int = 0
) : ViewGroup(context, attrs, defStyleAttr){

    private var itemHorizontalSpacing = 20
    private var itemVerticalSpacing = 20

    private val allLineViews = ArrayList<ArrayList<View>>()
    private val lineHeights = ArrayList<Int>()

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        allLineViews.clear()
        lineHeights.clear()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val maxWidth = widthSize
        var lineWidth = 0
        var maxLineWidth = 0
        var lineHeight = 0
        var totalHeight = 0
        val childCount = childCount
        var lineViews = ArrayList<View>()
        var lineCount = 0
        for(i in 0 until childCount){
            val child = getChildAt(i)
            if(child.visibility != View.GONE){
                val lp = child.layoutParams
                val childWithMeasureSpec = getChildMeasureSpec(widthMeasureSpec,paddingLeft+paddingRight,lp.width)
                val childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,paddingTop+paddingBottom,lp.height)
                child.measure(childWithMeasureSpec,childHeightMeasureSpec)
                val childMeasuredWith = child.measuredHeight
                val childMeasureHeight = child.measuredWidth
                val actualItemHorizontalSpacing = if(lineWidth ==0 )0 else itemHorizontalSpacing
                if(lineWidth + actualItemHorizontalSpacing + childMeasuredWith <= maxWidth){
                    lineWidth += actualItemHorizontalSpacing + childMeasuredWith
                    lineHeight = kotlin.math.max(lineHeight,childMeasureHeight)
                    lineViews.add(child)
                } else {
                    lineCount++
                    maxLineWidth = kotlin.math.max(lineWidth,childMeasureHeight)
                    totalHeight += lineHeight +if(lineCount==1)0 else itemVerticalSpacing
                    lineHeights.add(lineHeight)
                    allLineViews.add(lineViews)
                    lineWidth = childMeasuredWith
                    lineHeight = childMeasureHeight
                    lineViews = ArrayList<View>()
                    lineViews.add(child)
                }
            }
        }
        val measuredWidth =if(widthMode == MeasureSpec.EXACTLY)widthSize else maxLineWidth
        val measureHeight =if(heightMode == MeasureSpec.EXACTLY)heightSize else totalHeight
        setMeasuredDimension(measuredWidth,measureHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val lineCount = allLineViews.size
        var childLeft = 0
        var childTop = 0
        for(i in 0 until lineCount){
            val lineViews = allLineViews[i]
            val lineHeight = lineHeights[i]
            for(j in 0 until lineViews.size){
                val child =lineViews[j]
                val childMeasuredWidth = child.measuredWidth
                val childMeasuredHeight = child.measuredHeight
                child.layout(childLeft,childTop,childLeft + childMeasuredWidth,childTop + childMeasuredHeight)
                childLeft += childMeasuredWidth + itemHorizontalSpacing
            }
            childTop += lineHeight + itemHorizontalSpacing
            childLeft = 0
        }
    }


}