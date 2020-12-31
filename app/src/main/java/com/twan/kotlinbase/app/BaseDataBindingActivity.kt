package com.twan.kotlinbase.app

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.jaeger.library.StatusBarUtil
import com.twan.kotlinbase.R
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

//如果你使用databinding,请继承这个基类,用法不变
abstract class BaseDataBindingActivity<T: ViewDataBinding> : SwipeBackActivity() {
    protected var mContext: Activity? = null

    @BindView(R.id.back)
    lateinit var back: ImageButton

    @BindView(R.id.tv_back_text)
    lateinit var tv_back_text: TextView

    @BindView(R.id.ib_right)
    lateinit var ib_right: ImageButton

    @BindView(R.id.title)
    lateinit var title: TextView

    @BindView(R.id.tv_right)
    lateinit var tv_right: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,getLayout())
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorAccent), 25)
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

    protected lateinit var mBinding: T
    protected abstract fun getLayout(): Int
    protected abstract fun initEventAndData()
}