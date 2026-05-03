package campus.tech.kakao.map

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import campus.tech.kakao.map.LocationContract.LocationEntry

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbAccessor = LocationDbAccessor(context=this)
        addLocationData(dbAccessor)
        readLocationData(dbAccessor)
    }

    private fun readLocationData(dbAccessor: LocationDbAccessor) {
        val result = dbAccessor.getLocationByCategory("카페")
        Log.d("jieun", "$result")
    }

    private fun addLocationData(dbAccessor: LocationDbAccessor) {
        for (i in 1..9) {
            dbAccessor.insertLocation("카페$i", "부산 부산진구 전포대로$i", "카페")
        }
        for (i in 1..9) {
            dbAccessor.insertLocation("음식점$i", "부산 부산진구 중앙대로$i", "음식점")
        }
    }

}
