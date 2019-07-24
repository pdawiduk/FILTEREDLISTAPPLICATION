package com.example.roomapplicationwithrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomapplicationwithrecyclerview.util.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(MainFragment.newInstance(),R.id.fragment_container)
    }


}
