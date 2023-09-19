package com.raghul.myapplication

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raghul.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myImaage()
                }
            }
        }
    }
}

//these codes are designed by me
@Composable
fun birthdaywish(greet:String ,from:String ,modifier: Modifier= Modifier){
    Column(
        verticalArrangement = Arrangement.Center
        , modifier = modifier
    ) {
        Text(text = greet,
            fontSize = 75.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
            )
        Text(text =from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
@Composable
fun Greetimage(message: String,from: String,modifier: Modifier=Modifier){
    val image = painterResource(id = R.drawable.androidparty_png)
    Box {
        Image(painter = image, contentDescription = null
        , contentScale = ContentScale.Crop
            , alpha = 0.5f
            )
        
        birthdaywish(greet = message, from = from,
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }

}

@Composable
fun TextElements(title:String,Para1:String,Para2:String,modifier: Modifier=Modifier){
    Column(
        modifier = modifier
    ) {
        Text(text = title,
            fontSize = 24.sp,
            modifier=Modifier.
            padding(16.dp)
            )
        Text(text = Para1,
            textAlign = TextAlign.Justify,
            modifier=Modifier.padding(start=16.dp,end=16.dp)
        )
        Text(text = Para2,
            textAlign = TextAlign.Justify,
            modifier=Modifier.padding(16.dp)
            )

    }

}


@Composable
fun ComposeImage(title: String,Para1: String,Para2: String){
    val ComposeImg = painterResource(id = R.drawable.bg_compose_background)
    Box{


        TextElements(title = title, Para1 = Para1, Para2 =Para2 ,modifier= Modifier
            .fillMaxSize()
            .padding(8.dp))

        Image(painter = ComposeImg, contentDescription = null)

    }

}

//these are codes by google for compose practice
@Composable
fun ComposeArticle(){
    ArticleCard(titleCompose = stringResource(id = R.string.title) ,
        shortDescription = stringResource(id = R.string.Para1),
        LongDescription = stringResource(id = R.string.Para2),
        ImageCompose = painterResource(id = R.drawable.bg_compose_background))

}

@Composable
fun ArticleCard (titleCompose:String,
                 shortDescription:String,
                 LongDescription:String,
                 ImageCompose:Painter,
                 modifier: Modifier=Modifier
                 ){
    Column(modifier = modifier) {


        Image(painter = ImageCompose, contentDescription = null)

        Text(text = titleCompose
        , fontSize = 24.sp,
            modifier=Modifier.padding(16.dp)
        )
        Text(text = shortDescription
        ,modifier=Modifier.padding(start=16.dp,end=16.dp)
            , textAlign = TextAlign.Justify
        )
        Text(text = LongDescription
        , modifier = Modifier.padding(16.dp)
            , textAlign = TextAlign.Justify
            )
    }
}

@Composable
fun taskCompletion(){
    Column(modifier = Modifier.
    fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val taskimg =
        painterResource(id = R.drawable.ic_task_completed)

        Image(painter = taskimg, contentDescription = null)


        Text(text = stringResource(id = R.string.tasktext1),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )


        Text(text = stringResource(id = R.string.tasktext2)
        , fontSize = 16.sp)

    }
}

@Composable
fun Quadrant(){
    Column(Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)) {
            QuadrantCard(
                texttitle = stringResource(id = R.string.quadrant1),
                description = stringResource(id = R.string.quadrantd1),
                background = Color(0xFFEADDFF), modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                texttitle = stringResource(R.string.quadrant2),
                description = stringResource(id = R.string.quadrantd2),
                background = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
            Row (Modifier.weight(1f)){
                QuadrantCard(texttitle = stringResource(id = R.string.quadrant3),
                    description = stringResource(id = R.string.quadrantd3),
                    background = Color(0xFFB69DF8), modifier = Modifier.weight(1f))


                QuadrantCard(texttitle = stringResource(id = R.string.quadrant4),
                    description = stringResource(id = R.string.quadrantd4),
                    background = Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
            }

        }

    }



@Composable
private fun QuadrantCard(texttitle:String, description:String,
                         background: Color,
                         modifier: Modifier=Modifier)
{
    Column(modifier= modifier
        .fillMaxSize()
        .background(background)
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = texttitle,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(bottom=16.dp)
        )

        Text(text = description,
            textAlign = TextAlign.Justify
            )
    }
}

@Composable
fun myImaage(){
    Column(modifier=Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val profileimg= painterResource(id = R.drawable.img_20230913_000601)

        Image(painter = profileimg,contentDescription = null, modifier = Modifier.aspectRatio(16f/9f))

        Text(text = stringResource(id = R.string.Name),
            fontWeight = FontWeight.Bold
            , fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom=8.dp)
            )
        Text(text = stringResource(id = R.string.Job),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}








