package com.mouazalhindi.headquarters

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chromeIcon: ImageView = findViewById<ImageView>(R.id.app_icon)
        chromeIcon.setImageDrawable(getActivityIcon(this,"com.android.chrome", "com.google.android.apps.chrome.Main"))
        chromeIcon.setOnClickListener {
            onChromeButtonClick(it)
        }
    }

    fun getActivityIcon(context: Context, packageName: String?, activityName: String?): Drawable? {
        val pm: PackageManager = context.getPackageManager()
        val intent = Intent()
        intent.component = ComponentName(packageName!!, activityName!!)
        val resolveInfo = pm.resolveActivity(intent, 0)
        return resolveInfo!!.loadIcon(pm)
    }

    fun onChromeButtonClick(v: View?) {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.android.chrome")
        startActivity(launchIntent)
    }
}