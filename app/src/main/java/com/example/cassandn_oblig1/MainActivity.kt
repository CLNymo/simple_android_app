package com.example.cassandn_oblig1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cassandn_oblig1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // alternativ måte for view binding som gir penere kode (googel standard eller noe sånt?)
        // slipper å skrive binding.id senere, kan bare skrive id


    }

    fun sjekkPalindrom(view: View){

        if(input1.text.toString().equals(input1.text.toString().reversed())){
            textView2.text = getString(R.string.palindromeTrue)

        }
        else {
            textView2.text = getString(R.string.palindromeFalse)
        }

        // gjør input blank etter at palindrom er sjekket
        input1.setText("")


        // fjerner tastatur
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


    fun next(view: View){
        val intent = Intent(this, ConverterActivity::class.java)
        this.startActivity(intent)
    }






}