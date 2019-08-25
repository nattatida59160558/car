package com.example.carslot

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.carslot.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myCar1: MyCar = MyCar("","","")
    private val myCar2: MyCar = MyCar("","","")
    private val myCar3: MyCar = MyCar("","","")
    private var slot: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        hideButton()

        binding.apply {
            buttonSlot1.setOnClickListener {
                slot = 1
                showSlot(it)
            }
            buttonSlot2.setOnClickListener {
                slot = 2
                showSlot(it)
            }
            buttonSlot3.setOnClickListener {
                slot = 3
                showSlot(it)
            }
            buttonCon.setOnClickListener {
                addCar(it)
            }
            buttonDel.setOnClickListener {
                deleteCar(it)
            }
        }
        binding.myCar1 = myCar1
        binding.myCar2 = myCar2
        binding.myCar3 = myCar3

    }
    private fun hideButton(){
        binding.apply {
            textSerial.visibility = View.GONE
            textBrand.visibility = View.GONE
            textName.visibility = View.GONE
            buttonCon.visibility = View.GONE
            buttonDel.visibility = View.GONE
        }
    }

    private fun showSlot(view: View) {
        binding.apply {
            textSerial.visibility = View.VISIBLE
            textBrand.visibility = View.VISIBLE
            textName.visibility = View.VISIBLE
            buttonCon.visibility = View.VISIBLE
            buttonDel.visibility = View.VISIBLE

            if (slot == 1) {
                textSerial.setText(myCar1?.serialnumber)
                textBrand.setText(myCar1?.brand)
                textName.setText(myCar1?.name)
                invalidateAll()
            }
            else if (slot == 2) {
                textSerial.setText(myCar2?.serialnumber)
                textBrand.setText(myCar2?.brand)
                textName.setText(myCar2?.name)
                invalidateAll()
            }
            else{
                textSerial.setText(myCar3?.serialnumber)
                textBrand.setText(myCar3?.brand)
                textName.setText(myCar3?.name)
                invalidateAll()
            }
        }
    }

    private fun addCar(view: View){
        binding.apply {
            textSerial.visibility = View.GONE
            textBrand.visibility = View.GONE
            textName.visibility = View.GONE
            buttonCon.visibility = View.GONE
            buttonDel.visibility = View.GONE

            if (slot == 1) {
                myCar1?.serialnumber = textSerial.text.toString()
                myCar1?.brand = textBrand.text.toString()
                myCar1?.name = textName.text.toString()
                buttonSlot1.setText(myCar1?.name.toString())
                buttonSlot1.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            else if (slot == 2) {
                myCar2?.serialnumber = textSerial.text.toString()
                myCar2?.brand = textBrand.text.toString()
                myCar2?.name = textName.text.toString()
                buttonSlot2.setText(myCar2?.name.toString())
                buttonSlot2.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            else{
                myCar3?.serialnumber = textSerial.text.toString()
                myCar3?.brand = textBrand.text.toString()
                myCar3?.name = textName.text.toString()
                buttonSlot3.setText(myCar3?.name.toString())
                buttonSlot3.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    private fun deleteCar(view: View) {
        binding.apply {
            textSerial.visibility = View.GONE
            textBrand.visibility = View.GONE
            textName.visibility = View.GONE
            buttonCon.visibility = View.GONE
            buttonDel.visibility = View.GONE

            if (slot == 1) {
                myCar1?.serialnumber = ""
                myCar1?.brand = ""
                myCar1?.name = ""
                buttonSlot1.setText("Slot 1")
                buttonSlot1.setTextColor(Color.RED)
                buttonSlot1.setBackgroundColor(Color.YELLOW)
                invalidateAll()
            }
            else if (slot == 2) {
                myCar2?.serialnumber = ""
                myCar2?.brand = ""
                myCar2?.name = ""
                buttonSlot2.setText("Slot 2")
                buttonSlot2.setTextColor(Color.RED)
                buttonSlot2.setBackgroundColor(Color.YELLOW)
                invalidateAll()
            }
            else{
                myCar3?.serialnumber = ""
                myCar3?.brand = ""
                myCar3?.name = ""
                buttonSlot3.setText("Slot 3")
                buttonSlot3.setTextColor(Color.RED)
                buttonSlot3.setBackgroundColor(Color.YELLOW)
                invalidateAll()
            }
        }
    }


}
