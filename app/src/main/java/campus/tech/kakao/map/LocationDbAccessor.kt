package campus.tech.kakao.map

import android.content.ContentValues
import android.content.Context
import campus.tech.kakao.map.LocationContract.LocationEntry

class LocationDbAccessor(context: Context) {

    private val dbHelper = LocationDbHelper(context)

    fun insertLocation(title: String, address: String, category: String): Long {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(LocationEntry.COLUMN_NAME_TITLE, title)
            put(LocationEntry.COLUMN_NAME_ADDRESS, address)
            put(LocationEntry.COLUMN_NAME_CATEGORY, category)
        }

        return db.insert(LocationEntry.TABLE_NAME, null, values)
    }

    fun getLocationByCategory(category: String): List<String> {
        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            LocationEntry.COLUMN_NAME_TITLE,
            LocationEntry.COLUMN_NAME_ADDRESS,
            LocationEntry.COLUMN_NAME_CATEGORY
        )

        val selection = "${LocationEntry.COLUMN_NAME_CATEGORY} = ?"
        val selectionArgs = arrayOf(category)

        val sortOrder = "${LocationEntry.COLUMN_NAME_TITLE} ASC"

        val cursor = db.query(
            LocationEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )

        val results = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val title = getString(getColumnIndexOrThrow(LocationEntry.COLUMN_NAME_TITLE))
                results.add(title)
            }
        }
        cursor.close()
        return results
    }
}
