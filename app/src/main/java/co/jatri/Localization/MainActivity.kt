package co.jatri.Localization

import AppCompatActivityBase
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val banglaButton : Button =findViewById(R.id.bn_button)
        val enButton : Button =findViewById(R.id.en_button)
        banglaButton.setOnClickListener {
            setNewLocale("bn")
        }

        enButton.setOnClickListener {
            setNewLocale("en")
        }
    }
}