package com.example.bankingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Currency
import com.example.bankingapp.ui.theme.GreenStart

val currencyList = listOf(
    Currency(
        name = "USD",
        buy = 78.25f,
        sell = 25.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 85.62f,
        sell = 74.52f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 98.63f,
        sell = 85.62f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "USD",
        buy = 74.52f,
        sell = 78.65f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 95.25f,
        sell = 65.25f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 52.62f,
        sell = 74.25f,
        icon = Icons.Rounded.CurrencyYen
    )
)

@Preview
@Composable
fun CurrencySection() {
    var isVisible by remember {
        mutableStateOf(true)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowDown
                        } else {
                            Icons.Rounded.KeyboardArrowUp
                        }
                    }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currency",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Currency", modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Buy", modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = "Sell", modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(currencyList.size) { index ->
                                CurrencyItem(index, width)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val item = currencyList[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.name,
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
            }
            Text(
                text = item.name, modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Text(
            text = "$ ${item.buy}", modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
        Text(
            text = "$ ${item.sell}", modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
    }
}
















