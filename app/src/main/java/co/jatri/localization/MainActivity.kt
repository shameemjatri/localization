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

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnView = findViewById<Button>(R.id.button_language_switch)
        val textView = findViewById<TextView>(R.id.text_view_hello)
        textView.text=this.resources.getString(R.string.hello)


        btnView.setOnClickListener(View.OnClickListener {
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            val language = sharedPreferences.getString("language","en")
            if(language=="en"){
                val localeToSwitchTo = Locale("en")
                ContextUtils.updateLocale(this, localeToSwitchTo)
                editor.putString("language","en")
            }else{
                val localeToSwitchTo = Locale("bn")
                ContextUtils.updateLocale(this, localeToSwitchTo)
                editor.putString("language","bn")
            }


            editor.apply()
            editor.commit()

            textView.text=this.resources.getString(R.string.hello)
            btnView.text=this.resources.getString(R.string.switch_language)
        })
    }



    override fun attachBaseContext(newBase: Context?) {
        try {
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
            val language = sharedPreferences.getString("language","en")
            if(language=="en"){
                val localeToSwitchTo = Locale("en")
                val localeUpdatedContext =
                    ContextUtils.updateLocale(newBase!!, localeToSwitchTo)
                super.attachBaseContext(localeUpdatedContext)
            }else{
                val localeToSwitchTo = Locale("bn")
                val localeUpdatedContext =
                    ContextUtils.updateLocale(newBase!!, localeToSwitchTo)
                super.attachBaseContext(localeUpdatedContext)
            }
        }catch (e: Exception){
            val localeToSwitchTo = Locale("en")
            val localeUpdatedContext =
                ContextUtils.updateLocale(newBase!!, localeToSwitchTo)
            super.attachBaseContext(localeUpdatedContext)
        }



    }


}