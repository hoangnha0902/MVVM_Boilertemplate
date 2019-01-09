package com.nhahv.managermoney.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nhahv.managermoney.R

fun Activity.navController() = Navigation.findNavController(this, R.id.nav_host)
fun Fragment.navController() = Navigation.findNavController(requireActivity(), R.id.nav_host)


fun Fragment.addDecoration(recyclerView: RecyclerView) {
    recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
}