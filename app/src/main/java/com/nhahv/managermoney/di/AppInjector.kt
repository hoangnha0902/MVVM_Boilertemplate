package com.nhahv.managermoney.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nhahv.managermoney.AppApplication
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

object AppInjector {
    fun init(app: AppApplication) {
        DaggerAppComponent.builder().application(app).builder().inject(app)
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {}
            override fun onActivityResumed(activity: Activity?) {}
            override fun onActivityStarted(activity: Activity?) {}
            override fun onActivityDestroyed(activity: Activity?) {}
            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}
            override fun onActivityStopped(activity: Activity?) {}
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                injectActivity(activity)
            }
        })
    }

    private fun injectActivity(activity: Activity) {
        if (activity is AppCompatActivity) {
            AndroidInjection.inject(activity)
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object :
                    androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentCreated(fm: androidx.fragment.app.FragmentManager, f: androidx.fragment.app.Fragment, savedInstanceState: Bundle?) {
                    super.onFragmentCreated(fm, f, savedInstanceState)
                    if (f is Injectable) {
                        AndroidSupportInjection.inject(f)
                    }
                }
            }, true)
        }
    }
}