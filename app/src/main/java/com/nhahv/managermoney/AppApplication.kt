package com.nhahv.managermoney

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.nhahv.managermoney.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AppApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var bindActivity: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var bindFragment: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).builder().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = bindActivity

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = bindFragment
}