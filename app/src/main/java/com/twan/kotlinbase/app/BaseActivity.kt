package com.twan.kotlinbase.app

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.jaeger.library.StatusBarUtil
import com.twan.kotlinbase.R
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

abstract class BaseActivity : SwipeBackActivity() {
    protected var mContext: Activity? = null

    @JvmField
    @BindView(R.id.back)
    var back: ImageButton? = null

    @JvmField
    @BindView(R.id.tv_webview_close)
    var tv_webview_close: TextView? = null

    @JvmField
    @BindView(R.id.more)
    var ib_more: ImageButton? = null

    @JvmField
    @BindView(R.id.title)
    var title: TextView? = null

    @JvmField
    @BindView(R.id.moreText)
    var moreText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setColor(this, resources.getColor(R.color.text_white), 25)
        //StatusBarUtil.setColorForSwipeBack(this, resources.getColor(R.color.app_blue), 38)
        ButterKnife.bind(this)
        mContext = this
        App.addActivity(this)
        initEventAndData()
    }

    @OnClick(R.id.back)
    fun back(view: View?) {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.removeActivity(this)
    }

    protected abstract fun getLayout(): Int
    protected abstract fun initEventAndData()
}