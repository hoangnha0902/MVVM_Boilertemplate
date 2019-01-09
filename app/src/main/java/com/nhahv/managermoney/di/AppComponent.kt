package com.nhahv.managermoney.di

import android.app.Application
import com.nhahv.managermoney.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
        modules = [
            AndroidInjectionModule::class,
            AppBuildersModule::class,
            AppModule::class,
            ViewModelModule::class,
            RepositoryModule::class,
            NetworkModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<AppApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun builder(): AppComponent
    }
}