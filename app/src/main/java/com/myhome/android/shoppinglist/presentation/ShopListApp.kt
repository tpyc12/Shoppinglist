package com.myhome.android.shoppinglist.presentation

import android.app.Application
import com.myhome.android.shoppinglist.di.DaggerApplicationComponent

class ShopListApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}