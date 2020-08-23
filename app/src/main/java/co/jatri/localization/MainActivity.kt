package co.jatri.localization

import android.content.Context
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

        val btnBangla = findViewById<Button>(R.id.button_bangla)
        val btnEnglish = findViewById<Button>(R.id.button_english)
        val textView = findViewById<TextView>(R.id.text_view_hello)
        textView.text=this.resources.getString(R.string.hello)



        btnBangla.setOnClickListener(View.OnClickListener {
            val localeToSwitchTo = Locale("bn")
            ContextUtils.updateLocale(this, localeToSwitchTo)
            textView.text=this.resources.getString(R.string.hello)
        })

        btnEnglish.setOnClickListener(View.OnClickListener {
            val localeToSwitchTo = Locale("en")
            ContextUtils.updateLocale(this, localeToSwitchTo)
            textView.text=this.resources.getString(R.string.hello)
        })
    }




}