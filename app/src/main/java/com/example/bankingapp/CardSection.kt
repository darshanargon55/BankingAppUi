package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Card
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "4574 8795 6352",
        cardName = "Savings",
        balance = 452.65,
        cardColor = getColor(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "4587 9658 2541",
        cardName = "Trips",
        balance = 472.65,
        cardColor = getColor(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "7854 2541 7485",
        cardName = "School",
        balance = 785.55,
        cardColor = getColor(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "8596 7485 2145",
        cardName = "Savings",
        balance = 547.75,
        cardColor = getColor(PurpleStart, PurpleEnd)
    ),
)

fun getColor(startColor: Color,endColor: Color):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun CardSection() {
    LazyRow( ){
        items(cards.size){index->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index:Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size-1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.cardColor)
            .width(250.dp)
            .height(150.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp)
            , verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Image(painter = image, contentDescription = card.cardName,Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(text = "$ "+card.balance.toString(), color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.SemiBold )
            Text(text = card.cardNumber, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        }
    }

}