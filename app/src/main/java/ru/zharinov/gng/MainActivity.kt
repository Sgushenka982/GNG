package ru.zharinov.gng

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.google.gson.Gson
import model.Rider
import model.SingerWithConcert
import room.AppDatabase
import ru.zharinov.gng.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity= Gravity.CENTER_HORIZONTAL
        setContentView(bindingClass.root)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "GNG.db")
            .createFromAsset("db/info.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


        val singerRepository = db.singerRepository()
        val concertRepository = db.concertRepository()

        val singersList: List<SingerWithConcert> = singerRepository.getAllSingers()
        val riderList: List<Rider> = concertRepository.getAllRiders(1)
            Log.i("INFO", riderList.toString())



        for (singerWithConcert: SingerWithConcert in singersList) {
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = 60

            var btn = createButton(singerWithConcert)
            bindingClass.singersBlock.addView(btn, params)
            btn.setOnClickListener(getOnClickDoSomething(btn, singerWithConcert))
        }

    }

    private fun createButton(singerWithConcert: SingerWithConcert): Button {
        val myBtn = Button(this)

        myBtn.elevation = 1.0f
        myBtn.text = singerWithConcert.singer.name
        myBtn.setTextColor(Color.WHITE)
        myBtn.background = ContextCompat.getDrawable(this, R.drawable.rounded_button)

        return myBtn
    }

    fun getOnClickDoSomething(button: Button, singerWithConcert: SingerWithConcert): View.OnClickListener? {
        return View.OnClickListener {
            val intent = Intent(this, SingerActivity::class.java)
            intent.putExtra("SingerJson", Gson().toJson(singerWithConcert))
            startActivity(intent)
        }
    }
}