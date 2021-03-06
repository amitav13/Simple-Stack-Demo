package com.amitavkhandelwal.simplestackdemo.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitavkhandelwal.simplestackdemo.R
import com.amitavkhandelwal.simplestackdemo.navigation.BaseFragment
import com.amitavkhandelwal.simplestackdemo.onClick
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFlow.onClick { viewModel.startFlow() }
    }

}
