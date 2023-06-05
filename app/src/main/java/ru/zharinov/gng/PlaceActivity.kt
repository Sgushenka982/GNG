package ru.zharinov.gng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import ru.zharinov.gng.databinding.ActivityMainBinding
import ru.zharinov.gng.databinding.ActivityPlaceBinding

class PlaceActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivityPlaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivityPlaceBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val clubName: String? = intent.getStringExtra("clubName")
        bindingLayout.clubName.text = clubName

        var btn = bindingLayout.riderBtn
        btn.setOnClickListener(getOnClickDoSomething(btn))
        btn = bindingLayout.accessCodesBtn
        btn.setOnClickListener(getOnClickDoSomething(btn))
        btn = bindingLayout.guestsBtn
        btn.setOnClickListener(getOnClickDoSomething(btn))


    }

    fun getOnClickDoSomething(button: Button): View.OnClickListener? {
        return View.OnClickListener {
            val intent = Intent(this, TemplateActivity::class.java)
            intent.putExtra("templateName", button.text)
            startActivity(intent)
        }
    }
}