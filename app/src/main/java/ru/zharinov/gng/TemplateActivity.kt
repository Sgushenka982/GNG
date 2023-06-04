package ru.zharinov.gng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.zharinov.gng.databinding.ActivityPlaceBinding
import ru.zharinov.gng.databinding.ActivityTemplateBinding

class TemplateActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivityTemplateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val templateName: String? = intent.getStringExtra("templateName")
        bindingLayout.templateName.text = templateName
    }
}