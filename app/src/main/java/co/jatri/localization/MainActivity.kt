package co.jatri.localization

import android.os.Bundle
import com.ninenox.demokotlinlocalemanager.R
import com.ninenox.kotlinlocalemanager.AppCompatActivityBase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bn_button.setOnClickListener {
            setNewLocale("bn")
        }

        en_button.setOnClickListener {
            setNewLocale("en")
        }

    }


}
