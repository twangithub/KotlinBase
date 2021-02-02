package com.twan.kotlinbase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twan.kotlinbase.R
import com.twan.kotlinbase.widgets.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FirstActivity : AppCompatActivity(){

    private val DELAY_TIME = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

//        if(SPUtils.getInstance().getBoolean("iseverused")){
//            Router.newIntent(this@FirstActivity).to(MainActivity::class.java).launch()
//            finish()
//        } else {
            GlobalScope.launch(Dispatchers.Main) {
                delay(DELAY_TIME)
                Router.newIntent(this@FirstActivity).to(SplashActivity::class.java).launch()
                finish()
            }
//        }
    }

}