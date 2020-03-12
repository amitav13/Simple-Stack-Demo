package com.amitavkhandelwal.simplestackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amitavkhandelwal.simplestackdemo.navigation.FragmentStateChanger
import com.amitavkhandelwal.simplestackdemo.screens.home.HomeKey
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import com.zhuinden.simplestack.navigator.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), StateChanger {

    private lateinit var fragmentStateChanger: FragmentStateChanger

    @Inject
    lateinit var backstackHolder: BackstackHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app.appComponent.inject(this)
        initSimpleStack()
    }

    private fun initSimpleStack() {
        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.root)

        val backstack = Navigator.configure()
            .setStateChanger(this)
//            .setScopedServices(ServiceProvider())
            .setDeferredInitialization(true)
            .install(this, root, History.of(HomeKey()))

        backstackHolder.backstack = backstack // <-- make Backstack globally available through Dagger, singleInstance only!

        Navigator.executeDeferredInitialization(this)
    }

    override fun onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed()
        }
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.isTopNewKeyEqualToPrevious) {
            completionCallback.stateChangeComplete()
            return
        }
        fragmentStateChanger.handleStateChange(stateChange)
        completionCallback.stateChangeComplete()
    }
}
