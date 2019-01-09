package com.nhahv.managermoney

import android.content.Context
import androidx.fragment.app.Fragment
import com.nhahv.managermoney.di.Injectable
import dagger.android.support.AndroidSupportInjection

open class BaseFragment : Fragment(), Injectable {
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}