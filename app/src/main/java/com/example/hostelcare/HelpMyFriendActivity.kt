package com.example.hostelcare

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_help_my_friend.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class HelpMyFriendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_my_friend)
    }
    fun hmsf(v: View)
    {
        var pno=editText4.text.toString()
        var msg=editText5.text.toString()
        var uid=MainActivity.userid

        doAsync {
            val result = URL("http://jnncealumni.org/hostel/helpmf.php?uid="+uid+"&pno="+pno+"&msg="+msg).readText()
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
