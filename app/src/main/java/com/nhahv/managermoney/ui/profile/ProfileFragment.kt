package com.nhahv.managermoney.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nhahv.managermoney.BaseFragment
import com.nhahv.managermoney.R
import kotlinx.android.synthetic.main.profile_fragment.*
import javax.inject.Inject

class ProfileFragment : BaseFragment() {

    @Inject
    lateinit var viweModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viweModelFactory).get(ProfileViewModel::class.java)
        viewModel.responseData.observe(this, Observer { data ->
            message.text = data
        })
    }

}
