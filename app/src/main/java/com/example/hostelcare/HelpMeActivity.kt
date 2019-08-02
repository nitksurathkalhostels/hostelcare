package com.example.hostelcare

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_help_me.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class HelpMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_me)
    }
    fun hms(v: View)
    {
        var msg=editText3.text.toString()
        var uid=MainActivity.userid

        doAsync {
            val result = URL("http://jnncealumni.org/hostel/helpme.php?uid="+uid+"&msg="+msg).readText()
            uiThread {
                try {
                    toast(result)



                } catch (e: Exception) {

                    toast(e.toString());
                }
            }
        }
    }
}
