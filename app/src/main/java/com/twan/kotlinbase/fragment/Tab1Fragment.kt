package com.twan.kotlinbase.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import butterknife.BindView
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.twan.kotlinbase.R
import com.twan.kotlinbase.app.BaseFragment
import com.twan.kotlinbase.network.Response
import com.twan.kotlinbase.network.RxHttpScope
import rxhttp.toClass
import rxhttp.wrapper.param.RxHttp


class Tab1Fragment: BaseFragment() {
    @BindView(R.id.refreshLayout) lateinit var refreshLayout: SmartRefreshLayout

    override fun getLayoutId(): Int {
        return R.layout.tab1_fragment
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        title?.text = resources.getText(R.string.tab1)
        back?.visibility=View.GONE

    }

    fun getDataFromNetwork() {
        // demo
        RxHttpScope(mActivity as LifecycleOwner,refreshLayout).launch {
            val req = RxHttp.postJson("/phone/wlsl/login")
                .add("username", "usr")
                .add("password", "pwd")
                .toClass<Response<Any>>().await()
        }
    }

}