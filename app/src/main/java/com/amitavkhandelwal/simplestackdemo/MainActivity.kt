package com.amitavkhandelwal.simplestackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amitavkhandelwal.simplestackdemo.navigation.FragmentStateChanger
import com.amitavkhandelwal.simplestackdemo.screens.home.HomeKey
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import com.zhuinden.simplestack.navigator.Navigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StateChanger {

    private lateinit var fragmentStateChanger: FragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.root)

        Navigator.configure()
            .setStateChanger(this)
            .install(this, root, History.of(HomeKey()))

//            .setScopedServices(ScopeConfiguration())
//            .install(this, root, History.of(WordListKey()))
    }

    override fun handleStateChange(
        stateChange: StateChange,
        completionCallback: StateChanger.Callback
    ) {
        TODO("Not yet implemented")
    }
}
