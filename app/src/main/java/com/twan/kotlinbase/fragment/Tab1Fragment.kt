package com.twan.kotlinbase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.twan.kotlinbase.R
import com.twan.kotlinbase.app.BaseFragment
import com.twan.kotlinbase.databinding.Tab1FragmentBinding
import com.twan.kotlinbase.viewmodel.Tab1ViewModel
import com.twan.kotlinbase.network.Response
import com.twan.kotlinbase.network.RxHttpScope
import kotlinx.android.synthetic.main.tab1_fragment.*
import rxhttp.toClass
import rxhttp.wrapper.param.RxHttp


class Tab1Fragment: BaseFragment<Tab1FragmentBinding>() {

    //viewmodel使用示例
    private val myViewModel by viewModels<Tab1ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.tab1_fragment
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        title?.text = resources.getText(R.string.tab1)
        back?.visibility=View.GONE


        //使用viewmodel后,屏幕旋转后initView重新被调用,但是myViewModel数据不会丢失
        tv_num.text = myViewModel.number.toString()
        btn_add.setOnClickListener {
            myViewModel.number++
            tv_num.text = myViewModel.number.toString()
        }
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