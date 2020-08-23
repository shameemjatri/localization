package co.jatri.localization

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    private val sharedPrefFile = "kotlinsharedpreference"
    val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
    val editor:SharedPreferences.Editor =  sharedPreferences.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnView = findViewById<Button>(R.id.button_language_switch)

        btnView.setOnClickListener(View.OnClickListener {
            val lang = sharedPreferences.getString("SELECTED_LANGUAGE", "en")
            if (lang == "en"){
                ApplicationLanguageHelper.wrap(this, lang!!)
                editor.putString("SELECTED_LANGUAGE","en")

            }else{
                ApplicationLanguageHelper.wrap(this, lang!!)
                editor.putString("SELECTED_LANGUAGE","bn")
            }

            editor.apply()
            editor.commit()

        })
    }


    override fun attachBaseContext(newBase: Context?) {
        val lang = sharedPreferences.getString("SELECTED_LANGUAGE", "en")
        super.attachBaseContext(ApplicationLanguageHelper.wrap(newBase!!, lang!!))
    }

}