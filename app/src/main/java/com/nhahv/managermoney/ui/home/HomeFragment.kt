package com.nhahv.managermoney.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nhahv.managermoney.*

import com.nhahv.managermoney.data.model.UserWedding
import com.nhahv.managermoney.utils.UserWedCallback
import com.nhahv.managermoney.utils.addDecoration
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HomeViewModel

    var weddingAdapter: BaseRecyclerViewAdapter<UserWedding, UserWedViewHolder> =
            BaseRecyclerViewAdapter(UserWedCallback())


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weddingList.adapter = weddingAdapter
        addDecoration(weddingList)
        val temp = ArrayList<UserWedding>()
        temp.add(UserWedding())
        temp.add(UserWedding())
        temp.add(UserWedding())
        temp.add(UserWedding())
        temp.add(UserWedding())
        temp.add(UserWedding())

        weddingAdapter.submitList(temp)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.userWeds.observe(this, Observer { userWeds ->

        })
    }

}
