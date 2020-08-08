package com.twan.kotlinbase.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

/**
 * @author Twan
 * @date 2019/4/11
 */
class MyGridView : GridView {
    private var haveScrollbar = false

    constructor(context: Context?) : super(context) {
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
    }

    /**
     * 设置是否有ScrollBar，当要在ScollView中显示时，应当设置为false。 默认为 true
     */
    fun setHaveScrollbar(haveScrollbar: Boolean) {
        this.haveScrollbar = haveScrollbar
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!haveScrollbar) {
            val expandSpec = MeasureSpec.makeMeasureSpec(Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
            super.onMeasure(widthMeasureSpec, expandSpec)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}