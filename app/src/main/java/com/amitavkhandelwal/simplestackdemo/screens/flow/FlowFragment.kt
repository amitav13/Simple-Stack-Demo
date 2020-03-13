package com.amitavkhandelwal.simplestackdemo.screens.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitavkhandelwal.simplestackdemo.R
import com.amitavkhandelwal.simplestackdemo.navigation.BaseFragment
import com.amitavkhandelwal.simplestackdemo.onClick
import kotlinx.android.synthetic.main.flow_fragment.*

class FlowFragment : BaseFragment() {

    companion object {
        fun newInstance() = FlowFragment()
    }

    private lateinit var viewModel: FlowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.flow_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        completeFlow.onClick {
            viewModel.onCompleteFlow(
                etData1.text.toString(), etData2.text.toString()
            )
        }
    }
}
