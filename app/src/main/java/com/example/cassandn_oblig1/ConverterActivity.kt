package com.example.cassandn_oblig1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.cassandn_oblig1.databinding.ActivityConverterBinding
import kotlinx.android.synthetic.main.activity_converter.*

class ConverterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_converter)

        val spinner = spinner1
        val units = resources.getStringArray(R.array.unit_array)
        val adapter = ArrayAdapter(
                this,
                R.layout.custom_spinner_item, // custom stil på spinner items så vi får riktig skriftstørrelse
                units)

        spinner.adapter = adapter


    }

    fun convert(view: View){

        if (input2.text.isEmpty()){
            toastMessage()
            return
        }

        val unit = spinner1.selectedItem.toString()
        val userInput = input2.text.toString().toDouble()
        val spinnerItems = resources.getStringArray(R.array.unit_array)



        textResult.text = when (unit) {
            spinnerItems[0] -> { // fluid ounce
                "%.2f".format(userInput * 0.02957) + "L"
            }
            spinnerItems[1] -> { // cup
                "%.2f".format(userInput * 0.23659) + "L"
            }
            spinnerItems[2] -> { // gallon
                "%.2f".format(userInput * 3.78541) + "L"
            }
            else -> { // hogshead
                "%.2f".format(userInput * 238.481) + "L"
            }
        }

        // fjerner tastatur
        val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }

    fun toastMessage(){
        val message = R.string.toastConverterError
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun next(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        this.startActivity(intent)
    }


}