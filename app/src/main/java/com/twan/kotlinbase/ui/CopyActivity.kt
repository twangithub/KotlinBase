package com.twan.kotlinbase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.SPUtils
import com.twan.kotlinbase.R
import com.twan.kotlinbase.app.BaseActivity
import com.twan.kotlinbase.widgets.router.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CopyActivity : BaseActivity(){

    override fun getLayout(): Int {
        return R.layout.activity_copy
    }

    override fun initEventAndData() {

    }


}