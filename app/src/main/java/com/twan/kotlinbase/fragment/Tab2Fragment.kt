package com.twan.kotlinbase.fragment

import android.os.Bundle
import android.view.View
import butterknife.BindView
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.twan.kotlinbase.R
import com.twan.kotlinbase.app.BaseFragment
import com.twan.kotlinbase.databinding.Tab2FragmentBinding

class Tab2Fragment: BaseFragment<Tab2FragmentBinding>() {
    @BindView(R.id.refreshLayout) lateinit var refreshLayout: SmartRefreshLayout

    override fun getLayoutId(): Int {
        return R.layout.tab2_fragment
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        title?.text = resources.getText(R.string.tab2)
        back?.visibility=View.GONE

    }


}