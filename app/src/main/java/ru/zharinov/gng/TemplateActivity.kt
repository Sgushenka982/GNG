package ru.zharinov.gng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.gson.Gson
import model.ConcertWithInfo
import ru.zharinov.gng.databinding.ActivityPlaceBinding
import ru.zharinov.gng.databinding.ActivityTemplateBinding

class TemplateActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivityTemplateBinding
    lateinit var infoList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val gson = Gson()
        val info: Any = gson.fromJson(intent.getStringExtra("infoList"), Any::class.java)

        val templateName: String? = intent.getStringExtra("header")
        bindingLayout.templateName.text = templateName?.toUpperCase()

        infoList = findViewById(R.id.recyclerView)

        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        infoList.layoutManager = layoutManager
        infoList.setHasFixedSize(true)
    }
}


