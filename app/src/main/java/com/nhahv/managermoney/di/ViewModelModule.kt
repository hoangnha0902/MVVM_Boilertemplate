package com.nhahv.managermoney.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nhahv.managermoney.ViewModelFactory
import com.nhahv.managermoney.ui.history.HistoryViewModel
import com.nhahv.managermoney.ui.home.HomeViewModel
import com.nhahv.managermoney.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindHistoryViewModel(viewModel: HistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}