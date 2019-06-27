package com.bennyhuo.kotlin.coroutines.android.sample

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.bennyhuo.kotlin.coroutines.android.mainscope.lifecycle.mainScope
import com.bennyhuo.kotlin.coroutines.android.mainscope.scope.BasicScoped
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : FragmentActivity(), BasicScoped {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.onClick {
            supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                    .add(R.id.fragmentContainer, MainFragment())
                    .addToBackStack("Main").commit()
        }


        textView.onClick {
            lifecycle.mainScope.launch {
                log(1)
                delay(1000)
                log(2)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}