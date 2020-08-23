package co.jatri.localization

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnView = findViewById<Button>(R.id.button_language_switch)
        val textView = findViewById<TextView>(R.id.text_view_hello)
        textView.text=this.resources.getString(R.string.hello)
        btnView.text=this.resources.getString(R.string.switch_language)


        btnView.setOnClickListener(View.OnClickListener {

            val localeToSwitchTo = Locale("bn")
            ContextUtils.updateLocale(this, localeToSwitchTo)
            textView.text=this.resources.getString(R.string.hello)
            btnView.text=this.resources.getString(R.string.switch_language)
        })
    }



    override fun attachBaseContext(newBase: Context?) {

        val localeToSwitchTo = Locale("en")
        val localeUpdatedContext =
            ContextUtils.updateLocale(newBase!!, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)

    }


}