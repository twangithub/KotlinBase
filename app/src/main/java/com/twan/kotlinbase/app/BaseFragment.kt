package com.twan.kotlinbase.app

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import com.twan.kotlinbase.R

abstract class BaseFragment<T> : Fragment() {
    protected var mActivity: Activity? = null
    protected var mContext: Context? = null
    protected var mRootView: View? = null
    protected var mData: T? = null

    /**
     * 是否对用户可见
     */
    protected var mIsVisible = false

    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected var mIsPrepare = false

    @JvmField @BindView(R.id.back) var back: ImageButton? = null
    @JvmField @BindView(R.id.ib_login) var ib_login: ImageButton? = null
    @JvmField @BindView(R.id.tv_webview_close) var tv_webview_close: TextView? = null
    @JvmField @BindView(R.id.more) var ib_more: ImageButton? = null
    @JvmField @BindView(R.id.title) var title: TextView? = null
    @JvmField @BindView(R.id.moreText) var moreText: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = LayoutInflater.from(mActivity).inflate(getLayoutId(), container, false)
        ButterKnife.bind(this, mRootView!!)
        initData(arguments)
        initTitle()
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(mRootView, savedInstanceState)
        mIsPrepare = true
        getData()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        mContext = context
    }

    protected fun initTitle() {
        back?.visibility = View.VISIBLE
        title?.visibility = View.VISIBLE
        ib_login?.visibility = View.GONE
        tv_webview_close?.visibility = View.GONE
        title?.text = getString(R.string.app_name)
        ib_more?.visibility = View.GONE
        moreText?.visibility = View.GONE
    }

    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     *
     * @return
     */
    protected abstract fun getLayoutId():Int

    /**
     * 该抽象方法就是 初始化view
     *
     * @param view
     * @param savedInstanceState
     */
    protected abstract fun initView(view: View?, savedInstanceState: Bundle?
    )

    /**
     * 执行数据的加载
     */
    protected fun initData(arguments: Bundle?) {}

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mIsVisible = isVisibleToUser
        if (isVisibleToUser) {
            onVisibleToUser()
        }
    }

    /**
     * 用户可见时执行的操作
     */
    protected fun onVisibleToUser() {
        if (mIsPrepare && mIsVisible) {
            getData()
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     */
    open fun getData() {}

    protected fun <V : View?> findViewById(id: Int): V? {
        return if (mRootView == null) {
            null
        } else mRootView!!.findViewById<View>(id) as V
    }
}