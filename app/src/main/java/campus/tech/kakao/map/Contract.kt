package campus.tech.kakao.map

import android.provider.BaseColumns

object LocationContract {
    object LocationEntry: BaseColumns{
        const val TABLE_NAME = "locations"
        const val COLUMN_NAME_TITLE = "name"
        const val COLUMN_NAME_ADDRESS = "address"
        const val COLUMN_NAME_CATEGORY = "category"
    }
}