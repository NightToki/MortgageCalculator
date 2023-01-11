package com.example.cecs453assignment3_mortgagecalculatorv1

//import com.example.cecs453assignment3_mortgagecalculatorv1.Mortgage.Companion.formattedMonthlyPayment
//import com.example.cecs453assignment3_mortgagecalculatorv1.Mortgage.Companion.formattedTotalPayment
//import com.example.cecs453assignment3_mortgagecalculatorv1.Mortgage.Companion.getFormattedAmount
//import com.example.cecs453assignment3_mortgagecalculatorv1.Mortgage.Companion.getRate
//import com.example.cecs453assignment3_mortgagecalculatorv1.Mortgage.Companion.getYears
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jblearning.mortgagev1.R
import com.jblearning.mortgagev1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        val mortgage: Mortgage=Mortgage()

    }

    val MA = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    val  pf:Prefs = Prefs(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w( MA, "Inside MainActivity:onCreate\n" );
        pf.getPrefernces(mortgage)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onStart() {
        super.onStart()
        pf.getPrefernces(mortgage)
        binding.years.setText(mortgage.getYears().toString())
        binding.rate.setText(mortgage.getRate().toString()+"%")
        binding.amount.setText(mortgage.getFormattedAmount())
        binding.payment.setText(mortgage.formattedMonthlyPayment())
        binding.total.setText(mortgage.formattedTotalPayment())
        Log.w( MA, "Inside MainActivity:onStart\n" );
    }

    fun modifyData(view: View) {
        val myIntent = Intent(this, DataActivity::class.java)
        this.startActivity(myIntent)
        overridePendingTransition( R.anim.slide_from_left, 0 );

    }

    override fun onRestart() {
        super.onRestart()
        Log.w(MA, "Inside MainActivity:onReStart\n")
    }

    override fun onResume() {
        super.onResume()
        Log.w(MA, "Inside MainActivity:onResume\n")
    }

    override fun onPause() {
        super.onPause()
        Log.w(MA, "Inside MainActivity:onPause\n")
    }

    override fun onStop() {
        super.onStop()
        Log.w(MA, "Inside MainActivity:onStop\n")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(MA, "Inside MainActivity:onDestroy\n")
    }

}
