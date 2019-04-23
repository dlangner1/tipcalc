package edu.us.ischool.dlangner.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var tipButton: Button
    private var current = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tipButton = findViewById(R.id.button_tip)
        tipButton.isEnabled = false

        setupEditTextView()
    }

    private fun setupEditTextView() {
        editText = findViewById(R.id.money_et)

        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString() != current) {
                    editText.removeTextChangedListener(this)

                    val cleanString = s.toString().replace(Regex("""[$,.]"""), "")
                    val value = cleanString.toDouble()
                    val formatted = NumberFormat.getCurrencyInstance().format(value/100)

                    current = formatted
                    editText.setText(formatted);
                    editText.setSelection(formatted.length)

                    editText.addTextChangedListener(this)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (current != "") {
                    tipButton.isEnabled = true
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })
    }

    fun displayTip(view: View) {
        val serviceCharge = editText.text

        val cleanString = serviceCharge.replace(Regex("""[$,.]"""), "")
        val curr = cleanString.toDouble()
        val tip = curr * 0.15
        val formatted = NumberFormat.getCurrencyInstance().format(tip/100)

        val tipToast = Toast.makeText(applicationContext, formatted, Toast.LENGTH_LONG)
        tipToast.setGravity(Gravity.TOP, 0, 400)
        tipToast.show()
    }
}
