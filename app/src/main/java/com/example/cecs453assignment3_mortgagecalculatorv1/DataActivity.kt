package com.example.cecs453assignment3_mortgagecalculatorv1
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cecs453assignment3_mortgagecalculatorv1.MainActivity.Companion.mortgage
import com.jblearning.mortgagev1.R
import com.jblearning.mortgagev1.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    val DA = "MainActivity"
    val p = Prefs(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root);
        Log.w( DA, "Inside DataActivity:onCreate\n" );
        // setContentView(R.layout.activity_data)


    }
    fun goBack(v: View?) {
        updateMortgageObject()
        overridePendingTransition(R.anim.fade_in_and_scale, 0 );
        finish()
    }
    override fun onStart()  {
        super.onStart()
        p.getPrefernces(mortgage)
        var amountString = mortgage.getAmount().toString()
        var rateString = mortgage.getRate().toString()
        binding.dataAmount.setText(amountString)
        binding.dataRate.setText(rateString)
        binding.thirty.isChecked = false
        binding.fifteen.isChecked = false
        binding.ten.isChecked = false
        if(mortgage.getYears() == 30)   {
            binding.thirty.isChecked = true
        }
        Log.w( DA, "Inside DataActivity:onStart\n" );     }

    fun updateMortgageObject() {
        val mortgage = MainActivity.mortgage
        val p = Prefs(this)
        val amountET = binding.dataAmount
        val rb10 = binding.ten
        val rb15 = binding.fifteen
        var years = 30
        if (rb10.isChecked)
            years = 10
        else if (rb15.isChecked)
            years = 15
        mortgage.setYears(years)
        val rateET = binding.dataRate
        val rateString:String = rateET.getText().toString()
        val amountString = amountET.text.toString()
        try {
            val amount = amountString.toFloat()
            mortgage.setAmount(amount)
            binding.dataAmount.setText(mortgage.getFormattedAmount())
            val rate: Float = rateString.toFloat()
            mortgage.setRate(rate)
            binding.dataRate.setText(rate.toString())
            p.setPreferences(mortgage)
        } catch (nfe: NumberFormatException) {
            mortgage.setAmount(100000.0f)
            mortgage.setRate(.035f)
        }

    }


    override fun onRestart() {
        super.onRestart()
        Log.w(DA, "Inside DataActivity:onReStart\n")
    }

    override fun onResume() {
        super.onResume()
        Log.w(DA, "Inside DataActivity:onResume\n")
    }

    override fun onPause() {
        super.onPause()
        Log.w(DA, "Inside DataActivity:onPause\n")
    }

    override fun onStop() {
        super.onStop()
        Log.w(DA, "Inside DataActivity:onStop\n")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(DA, "Inside DataActivity:onDestroy\n")
    }



}