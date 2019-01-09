package com.nhahv.managermoney.di

import com.nhahv.managermoney.MainActivity
import com.nhahv.managermoney.ui.history.HistoryFragment
import com.nhahv.managermoney.ui.home.HomeFragment
import com.nhahv.managermoney.ui.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress
@Module
abstract class AppBuildersModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindHistoryFragment(): HistoryFragment

    @ContributesAndroidInjector
    abstract fun bindProfileFragment(): ProfileFragment
}