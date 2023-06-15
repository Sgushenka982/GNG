package ru.zharinov.gng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.gson.Gson
import model.ConcertWithInfo
import model.SingerWithConcert
import ru.zharinov.gng.databinding.ActivityMainBinding
import ru.zharinov.gng.databinding.ActivityPlaceBinding

class PlaceActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivityPlaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivityPlaceBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val gson = Gson()
        val concertWithInfo: ConcertWithInfo = gson.fromJson(intent.getStringExtra("concertJson"), ConcertWithInfo::class.java)

        bindingLayout.clubName.text = concertWithInfo.concert.club

        var btn = bindingLayout.riderBtn
        btn.setOnClickListener(getOnClickDoSomething(concertWithInfo.riderList, btn.text as String))
        btn = bindingLayout.accessCodesBtn
        btn.setOnClickListener(getOnClickDoSomething(concertWithInfo.codeList, btn.text as String))
        btn = bindingLayout.guestsBtn
        btn.setOnClickListener(getOnClickDoSomething(concertWithInfo.guestList, btn.text as String))


    }

    fun getOnClickDoSomething(infoList: List<Any>, header: String): View.OnClickListener? {
        return View.OnClickListener {
            val intent = Intent(this, TemplateActivity::class.java)
            intent.putExtra("infoListJson", Gson().toJson(infoList))
            intent.putExtra("header", header)
            startActivity(intent)
        }
    }
}