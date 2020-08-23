package co.jatri.localization

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*


class ContextUtils(base: Context?) : ContextWrapper(base) {
    companion object {
        fun updateLocale(context: Context, localeToSwitchTo: Locale?,lang: String): ContextWrapper {
            var context: Context = context
            val resources: Resources = context.getResources()
            val configuration: Configuration = resources.getConfiguration()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val localeList = LocaleList(localeToSwitchTo)
                LocaleList.setDefault(localeList)
                configuration.setLocales(localeList)
            } else {
                configuration.locale = localeToSwitchTo
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                context = context.createConfigurationContext(configuration)
            } else {
                resources.updateConfiguration(configuration, resources.getDisplayMetrics())
            }



            val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
            editor.putString("My_Lang", lang)
            editor.apply()

            return ContextUtils(context)
        }
    }
}