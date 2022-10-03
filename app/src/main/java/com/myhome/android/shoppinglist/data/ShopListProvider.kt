package com.myhome.android.shoppinglist.data

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.myhome.android.shoppinglist.domain.ShopItem
import com.myhome.android.shoppinglist.presentation.ShopListApp
import javax.inject.Inject

class ShopListProvider: ContentProvider() {

    private val component by lazy {
        (context as ShopListApp).component
    }

    @Inject
    lateinit var shopListDao: ShopListDao

    @Inject
    lateinit var mapper: ShopListMapper

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("com.myhome.android.shoppinglist", "shop_items", GET_SHOP_ITEMS_QUERY)
        addURI("com.myhome.android.shoppinglist", "shop_items/#", GET_SHOP_ITEM_BY_ID_QUERY)
        addURI("com.myhome.android.shoppinglist", "shop_items/*", GET_SHOP_ITEM_BY_NAME_QUERY)
    }

    override fun onCreate(): Boolean {
        component.inject(this)
        return true
    }

    override fun query(
        uri: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return when(uriMatcher.match(uri)){
            GET_SHOP_ITEMS_QUERY -> {
                shopListDao.getShopListCursor()
            }
            else -> {
                null
            }
        }
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        when(uriMatcher.match(uri)){
            GET_SHOP_ITEMS_QUERY -> {
                if (values == null) return null
                val id = values.getAsInteger("id")
                val name = values.getAsString("name")
                val count = values.getAsInteger("count")
                val enabled = values.getAsBoolean("enabled")
                val shopItem = ShopItem(
                    id = id,
                    name = name,
                    count = count,
                    enabled = enabled
                )
                shopListDao.addShopItemSync(mapper.mapEntityToDBModel(shopItem))
            }
        }
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    companion object{

        const val GET_SHOP_ITEMS_QUERY = 100
        const val GET_SHOP_ITEM_BY_ID_QUERY = 101
        const val GET_SHOP_ITEM_BY_NAME_QUERY = 102
    }
}