package com.myhome.android.shoppinglist.data

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log

class ShopListProvider: ContentProvider() {

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("com.myhome.android.shoppinglist", "shop_items", GET_SHOP_ITEMS_QUERY)
        addURI("com.myhome.android.shoppinglist", "shop_items/#", GET_SHOP_ITEM_BY_ID_QUERY)
        addURI("com.myhome.android.shoppinglist", "shop_items/*", GET_SHOP_ITEM_BY_NAME_QUERY)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        val code = uriMatcher.match(uri)
        when(code){
            GET_SHOP_ITEMS_QUERY -> {

            }
        }
        Log.d("ShopListProvider", "query $uri $code")
        return null
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
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