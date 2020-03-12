package com.amitavkhandelwal.simplestackdemo.navigation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amitavkhandelwal.simplestackdemo.app
import com.careclues.patient.di.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Owner on 2017.11.13.
 */

open class BaseFragment : Fragment() {
    fun <T : BaseKey> getKey(): T = requireArguments().getParcelable<T>("KEY")!!

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as AppCompatActivity).app.appComponent.inject(this)
    }

    /**
     * @return A ViewModel tied to the lifecycle of the current fragment
     */
    protected inline fun <reified VM : ViewModel> getViewModel(): VM {
        return ViewModelProvider(this, viewModelFactory).get(VM::class.java)
    }

    /**
     * @return A ViewModel tied to the lifecycle of the specified fragment
     */
    protected inline fun <reified VM : ViewModel> getViewModel(fragment: Fragment): VM {
        return ViewModelProvider(fragment, viewModelFactory).get(VM::class.java)
    }

    /**
     * @return A ViewModel tied to the lifecycle of the specified activity
     */
    protected inline fun <reified VM : ViewModel> getViewModel(activity: AppCompatActivity): VM {
        return ViewModelProvider(activity, viewModelFactory).get(VM::class.java)
    }
}
