package com.myhome.android.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myhome.android.shoppinglist.R

class ShopItemActivity : AppCompatActivity() {

    private lateinit var viewModel: ShopIteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        viewModel = ShopIteViewModel()
        viewModel.errorInputName
    }
}