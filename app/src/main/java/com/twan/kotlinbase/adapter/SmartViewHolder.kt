package com.twan.kotlinbase.adapter

import android.R
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SmartViewHolder(itemView: View, private val mListener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(v: View) {
        if (mListener != null) {
            val position = adapterPosition
            if (position >= 0) {
                mListener.onItemClick(null, v, position, itemId)
            }
        }
    }

    private fun findViewById(id: Int): View {
        return if (id == 0) itemView else itemView.findViewById(id)
    }

    fun text(id: Int, sequence: CharSequence?): SmartViewHolder {
        val view = findViewById(id)
        if (view is TextView) {
            view.text = sequence
        }
        return this
    }

    fun text(id: Int, @StringRes stringRes: Int): SmartViewHolder {
        val view = findViewById(id)
        if (view is TextView) {
            view.setText(stringRes)
        }
        return this
    }

    fun textColorId(id: Int, colorId: Int): SmartViewHolder {
        val view = findViewById(id)
        if (view is TextView) {
            view.setTextColor(ContextCompat.getColor(view.getContext(), colorId))
        }
        return this
    }

    fun image(id: Int, imageId: Int): SmartViewHolder {
        val view = findViewById(id)
        if (view is ImageView) {
            view.setImageResource(imageId)
        }
        return this
    }

    init {
        itemView.setOnClickListener(this)
        /**
         * 设置水波纹背景
         */
        if (itemView.background == null) {
            val typedValue = TypedValue()
            val theme = itemView.context.theme
            val top = itemView.paddingTop
            val bottom = itemView.paddingBottom
            val left = itemView.paddingLeft
            val right = itemView.paddingRight
            if (theme.resolveAttribute(R.attr.selectableItemBackground, typedValue, true)) {
                itemView.setBackgroundResource(typedValue.resourceId)
            }
            itemView.setPadding(left, top, right, bottom)
        }
    }
}