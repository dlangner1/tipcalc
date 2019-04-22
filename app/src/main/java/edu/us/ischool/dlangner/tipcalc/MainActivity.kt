package edu.us.ischool.dlangner.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moneyEditText: EditText = findViewById(R.id.moneyText)
        // moneyEditText.addTextChangedListener(MoneyTextWatcher())

        setContentView(R.layout.activity_main)
    }
}
