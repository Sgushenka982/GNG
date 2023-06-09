package ru.zharinov.gng

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import model.ConcertWithInfo
import model.SingerWithConcert
import ru.zharinov.gng.databinding.ActivitySingerBinding

class SingerActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivitySingerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivitySingerBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val gson = Gson()
        val singerWithConcert:SingerWithConcert = gson.fromJson(intent.getStringExtra("SingerJson"), SingerWithConcert::class.java)

        bindingLayout.singerName.text = singerWithConcert.singer.name

        for(concert:ConcertWithInfo in singerWithConcert.concertList){
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.topMargin= 80

            var btn = createButton(concert)
            bindingLayout.concertsBlock.addView(btn, params)
            btn.setOnClickListener(getOnClickDoSomething(concert))
        }
    }

    private fun createButton(concert: ConcertWithInfo): Button {
        val myBtn = Button(this)

        myBtn.elevation = 1.0f
        myBtn.text = concert.concert.club + "//" + concert.concert.city
        myBtn.setTextColor(Color.WHITE)
        myBtn.background = ContextCompat.getDrawable(this, R.drawable.rounded_button)

        return myBtn
    }

    fun getOnClickDoSomething(concert:ConcertWithInfo): View.OnClickListener? {
        return View.OnClickListener {
            val intent = Intent(this, PlaceActivity::class.java)
            intent.putExtra("concertJson", Gson().toJson(concert))
            startActivity(intent)
        }
    }
}