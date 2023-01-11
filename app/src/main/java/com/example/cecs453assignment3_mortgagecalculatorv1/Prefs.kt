package com.example.cecs453assignment3_mortgagecalculatorv1

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class Prefs(context1: Context)  {
    private var context: Context? = context1
    private var amount:Float=200000.0f


    private var years: Int =15
    private var rate: Float =0.035f
    fun setPreferences(mort: Mortgage) {
        var s: SharedPreferences? =
            context!!.getSharedPreferences("Mortgage", Context.MODE_PRIVATE)
        var editor = s?.edit()
        if (editor != null) {
            editor.putFloat(Mortgage.PREFERENCE_AMOUNT, mort.getAmount())
            editor.commit( )
        }
        if (editor != null) {
            editor.putInt(Mortgage.PREFERENCE_YEARS, mort.getYears())
            editor.commit( )
        }
        if (editor !=null){
            editor.putFloat(Mortgage.PREFERENCE_RATE,mort.getRate())
            editor.commit( )
        }

    }

    fun getPrefernces(mort: Mortgage)
    {

        var s: SharedPreferences? =
            context!!.getSharedPreferences("Mortgage", Context.MODE_PRIVATE)
        if (s != null) {
            mort.setYears(s.getInt(Mortgage.PREFERENCE_YEARS,30))
            mort.setAmount(s.getFloat(Mortgage.PREFERENCE_AMOUNT,100000.0f))
            mort.setRate(s.getFloat(Mortgage.PREFERENCE_RATE,0.035f))

        }

    }
}