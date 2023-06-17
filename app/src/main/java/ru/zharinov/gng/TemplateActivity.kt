package ru.zharinov.gng

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.Rider
import ru.zharinov.gng.databinding.ActivityTemplateBinding


class TemplateActivity : AppCompatActivity() {
    lateinit var bindingLayout: ActivityTemplateBinding
    lateinit var infoList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(bindingLayout.root)

        val gson = Gson()
        val listType = object : TypeToken<ArrayList<Any>>() {}.type
        val infoList: List<Any> = gson.fromJson(intent.getStringExtra("infoListJson") , listType)

//        setContent(){
//            infoList(info)
//        }

        val templateName: String? = intent.getStringExtra("header")
        bindingLayout.templateName.text = templateName?.toUpperCase()

//        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
//        infoList.layoutManager = layoutManager
//        infoList.setHasFixedSize(true)
    }

    @Composable
    fun infoList(infoList: List<Rider>){
        LazyColumn{
            items(infoList) { info->
                Row() {
                    Text(
                        text = "• " + info.requirements,
                        fontSize=24.sp ,
                        color = Color.White ,
                        textAlign= TextAlign.Left ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }

//    @Preview(showBackground = true)
//    @Composable
//    fun infoListPreview(){
//        infoList()
//    }
}


