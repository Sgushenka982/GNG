package ru.zharinov.gng

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.Code
import model.Guest
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
        var riderType = object : TypeToken<ArrayList<Rider>>() {}.type
        var codeType = object : TypeToken<ArrayList<Code>>() {}.type
        var guestType = object : TypeToken<ArrayList<Guest>>() {}.type

        var riderList: List<Rider> = emptyList()
        var codeList: List<Code> = emptyList()
        var guestList: List<Guest> = emptyList()

        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            if (extras.containsKey("riderListJson")) {
                riderList = gson.fromJson(extras.getString("riderListJson"),riderType)
            }else if (extras.containsKey("codeListJson")){
                codeList = gson.fromJson(extras.getString("codeListJson"), codeType)
            }else if (extras.containsKey("guestListJson")){
                guestList = gson.fromJson(extras.getString("guestListJson"), guestType)
            }
        }
        val templateName: String? = extras?.getString("header")?.toUpperCase()

        setContent() {
            Surface(color = Color.Blue) {
                if (riderList.isNotEmpty()) {
                    if (templateName != null) {
                        riderList(riderList, templateName)
                    }
                } else if(codeList.isNotEmpty()){
                    if (templateName != null) {
                        codeList(codeList, templateName)
                    }
                }else if(guestList.isNotEmpty()){
                    if (templateName != null) {
                        guestList(guestList,templateName)
                    }
                }
            }

        }


    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun riderList(riderList: List<Rider>, header: String) {
        Box(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.img),
                    contentScale = ContentScale.Crop
                )
                .fillMaxHeight()
        ) {
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            stickyHeader {
                Surface(
                    color = Color(192,2,2)) {
                    Text(
                        text = header,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    )
                }
            }
            items(riderList) { rider ->
                    Row() {
                        Text(
                        text = "• " + rider.requirements,
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun codeList(codeList: List<Code>, header: String) {
        Box(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.img),
                    contentScale = ContentScale.Crop
                )
                .fillMaxHeight()
        ) {
        }
        LazyColumn {
            stickyHeader {
                Surface(
                    color = Color(192,2,2)) {
                    Text(
                        text = header,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            itemsIndexed(codeList) { index,code->
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = code.code + " - сканировщик " + (index+1),
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun guestList(guestList: List<Guest>, header: String) {
        Box(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.img),
                    contentScale = ContentScale.Crop
                )
                .fillMaxHeight()
        ) {
        }
        LazyColumn {
            stickyHeader {
                Surface(
                    color = Color(192,2,2)) {
                    Text(
                        text = header,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            items(guestList) { guest->
                Column() {
                    Text(
                        text = guest.guest,
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun infoListPreview() {
        Surface(
//            color = Color.DarkGray,
            ) {
//            riderList()
        }
    }

}


