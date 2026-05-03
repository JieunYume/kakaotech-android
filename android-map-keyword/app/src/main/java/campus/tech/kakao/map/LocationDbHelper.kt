package campus.tech.kakao.map

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import campus.tech.kakao.map.LocationContract.LocationEntry


private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${LocationEntry.TABLE_NAME} (" +
            "${LocationEntry.COLUMN_NAME_TITLE} TEXT," +
            "${LocationEntry.COLUMN_NAME_ADDRESS} TEXT,"+
            "${LocationEntry.COLUMN_NAME_CATEGORY} TEXT"+
            ")"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${LocationEntry.TABLE_NAME}"

class LocationDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Location.db"
    }
}