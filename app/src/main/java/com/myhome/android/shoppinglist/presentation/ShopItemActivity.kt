package com.myhome.android.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.myhome.android.shoppinglist.R
import com.myhome.android.shoppinglist.domain.ShopItem
import java.lang.RuntimeException

class ShopItemActivity : AppCompatActivity() {

//    private lateinit var viewModel: ShopIteViewModel
//
//    private lateinit var tilName: TextInputLayout
//    private lateinit var tilCount: TextInputLayout
//    private lateinit var etName: TextInputEditText
//    private lateinit var etCount: TextInputEditText
//    private lateinit var saveButton: Button
//
//    private var screenMode = UNKNOWN_MODE
//    private var shopItemId = ShopItem.UNDEFINED_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
//        parseIntent()
//        viewModel = ViewModelProvider(this)[ShopIteViewModel::class.java]
//        initViews()
//        addTextChangeListeners()
//        launchRightMode()
//        observeViewModel()
    }
//
//    private fun observeViewModel() {
//        viewModel.errorInputName.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_name)
//            } else {
//                null
//            }
//            tilName.error = message
//        }
//        viewModel.errorInputCount.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_count)
//            } else {
//                null
//            }
//            tilCount.error = message
//        }
//        viewModel.closeScreen.observe(this) {
//            finish()
//        }
//    }
//
//    private fun launchRightMode() {
//        when (screenMode) {
//            ADD_MODE -> launchAddMode()
//            EDIT_MODE -> launchEditMode()
//        }
//    }
//
//    private fun addTextChangeListeners() {
//        etName.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.resetErrorInputName()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//        etCount.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.resetErrorInputCount()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//    }
//
//    private fun launchEditMode() {
//        viewModel.getShopItem(shopItemId)
//        viewModel.shopItem.observe(this){
//            etName.setText(it.name)
//            etCount.setText(it.count.toString())
//        }
//        saveButton.setOnClickListener {
//            viewModel.editShopItem(etName.text?.toString(), etCount.text?.toString())
//        }
//    }
//
//    private fun launchAddMode() {
//        saveButton.setOnClickListener {
//            viewModel.addShopItem(etName.text?.toString(), etCount.text?.toString())
//        }
//    }
//
//    private fun parseIntent() {
//        if (!intent.hasExtra(EXTRA_SCREEN_MODE)){
//            throw RuntimeException("Param screen mode is absent")
//        }
//        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
//        if (mode != ADD_MODE && mode != EDIT_MODE){
//            throw RuntimeException("Param screen mode is $UNKNOWN_MODE")
//        }
//        screenMode = mode
//        if (screenMode == EDIT_MODE){
//            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)){
//                throw RuntimeException("Param shop item id is absent")
//            }
//            shopItemId = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, ShopItem.UNDEFINED_ID)
//        }
//    }
//
//    private fun initViews() {
//        tilName = findViewById(R.id.til_name)
//        tilCount = findViewById(R.id.til_count)
//        etName = findViewById(R.id.et_name)
//        etCount = findViewById(R.id.et_count)
//        saveButton = findViewById(R.id.save_button)
//    }

    companion object {

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val ADD_MODE = "mode_add"
        private const val EDIT_MODE = "edit_mode"
        private const val UNKNOWN_MODE = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, ADD_MODE)
            return intent
        }

        fun newIntentEditItem(context: Context, shopItemId: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, EDIT_MODE)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, shopItemId)
            return intent
        }
    }
}