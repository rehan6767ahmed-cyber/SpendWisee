package com.spendwise.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFFF5F7FA)
private val Primary = Color(0xFF176B55)
private val Dark = Color(0xFF172B25)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SpendWiseDashboard()
            }
        }
    }
}

@Composable
fun SpendWiseDashboard() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            // Header

            Text(
                text = "SpendWise",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Text(
                text = "Your money. Your control.",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Monthly spending card

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Dark
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Text(
                        text = "TOTAL SPENDING THIS MONTH",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "₹7,300",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "12 transactions recorded",
                        color = Color.LightGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Quick statistics

            Text(
                text = "Overview",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                StatCard(
                    title = "Today's Spending",
                    amount = "₹450",
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                StatCard(
                    title = "Monthly Budget",
                    amount = "₹10,000",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Categories

            Text(
                text = "Expense Categories",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            CategoryItem("Food", "₹3,000", 0.75f)

            CategoryItem("Shopping", "₹2,000", 0.50f)

            CategoryItem("Travel", "₹1,500", 0.40f)

            CategoryItem("Entertainment", "₹800", 0.25f)

            Spacer(modifier = Modifier.height(25.dp))

            // Recent transactions

            Text(
                text = "Recent Transactions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            TransactionItem("Starbucks", "Food", "₹250")

            TransactionItem("Uber", "Travel", "₹150")

            TransactionItem("Amazon", "Shopping", "₹500")

            Spacer(modifier = Modifier.height(25.dp))

            // AI Assistant

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Primary
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "AI Financial Assistant",
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Ask me where your money goes!",
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {

                        Text(
                            text = "Ask SpendWise AI",
                            color = Primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Your financial data stays on your device.",
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun StatCard(
    title: String,
    amount: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(15.dp)
        ) {

            Text(
                text = title,
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = amount,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Dark
            )
        }
    }
}

@Composable
fun CategoryItem(
    name: String,
    amount: String,
    progress: Float
) {

    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(name, fontWeight = FontWeight.Medium)

            Text(amount, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(7.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = Primary,
            trackColor = Color.LightGray.copy(alpha = 0.3f)
        )
    }
}

@Composable
fun TransactionItem(
    merchant: String,
    category: String,
    amount: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = merchant,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = category,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Text(
                text = "-$amount",
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
    }
}