package com.example.second_and_re

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.second_and_re.ui.theme.Second_and_reTheme
import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Second_and_reTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    var rcswitch by remember { mutableStateOf(true) }
                    Column (
                        modifier = Modifier.padding(40.dp)
                    ) {
                        Column {
                            Text(
                                text = "To understand the 'Alignment' And 'Arrangement'",
                                modifier = Modifier.padding(12.dp)
                            )
                            Text(
                                text = "Row places items in its main axis which is 'Horizontal'",
                                modifier = Modifier.padding(12.dp)
                            )
                            Text(
                                text = "Column places items in its main axis which is 'Vertical'",
                                modifier = Modifier.padding(12.dp)
                            )
                            Text(
                                "Arrangement has relation with the main axis so Alignment has relation with the cross axis"
                            )
                            Text(
                                text = "Current choice: ${if (rcswitch) "Row" else "Column"}",
                                modifier = Modifier.padding(12.dp)
                            )

                            Button(
                                onClick = { rcswitch = !rcswitch },
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text("Change (R/C): ${if (rcswitch) "Row" else "Column"}")
                            }
                        }

                        // Call to Display function moved here
                        Display(rcswitch)
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Red)) {
                                    append("Red")
                                }
                                append(" is Cross axis: Vertical\n")
                                withStyle(style = SpanStyle(color = Color.Green)) {
                                    append("Green")
                                }
                                append(" is the main axis: Horizontal")
                            }
                        )

                    }
                }
            }
        }
    }

}

@Composable
fun Display(state: Boolean, modifier: Modifier = Modifier) {
        val st1 by remember {
            mutableStateOf(Arrangement.Start)
        }
        val st2 by remember {
            mutableStateOf(Arrangement.End)
        }
        val st3 by remember {
            mutableStateOf(Arrangement.Center)
        }
        if (state) {

            var selectedAlignment by remember { mutableStateOf(st1) }
            Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = selectedAlignment,
                verticalAlignment = Alignment.Bottom
            ) {
                repeat(4) {
                    Text(
                        text = "item ${it + 1}",
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color.DarkGray)
                            .padding(12.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                }
            }
            Box(
                modifier = modifier
                    .width(300.dp)
                    .height(30.dp)

            ) {
                Text("--------------------------------------------------------------------"
                    , fontSize = 25.sp,
                    color= Color.Green
                )
            }
                Column {
                    repeat(3) {
                        Text(
                            "                       |", fontSize = 25.sp,
                            color = Color.Red
                        )
                    }
                    Text(text = "Select a state of Arrangement")
                    Spacer(modifier = Modifier.size(16.dp))


                    Row {
                        RadioButton(
                            selected = selectedAlignment == st1,
                            onClick = { selectedAlignment = st1},
                            colors = RadioButtonDefaults.colors(Color.Green)
                        )
                        Text("Start")
                        Spacer(modifier = Modifier.size(16.dp))
                        RadioButton(
                            selected = selectedAlignment == st3,
                            onClick = { selectedAlignment = st3},
                            colors = RadioButtonDefaults.colors(Color.Green)
                        )
                        Text("Center")
                        Spacer(modifier = Modifier.size(16.dp))

                        RadioButton(
                            selected = selectedAlignment == st2,
                            onClick = { selectedAlignment = st2 },
                            colors = RadioButtonDefaults.colors(Color.Green)
                        )
                        Text("End")
                    }

                }

            }
        } else {
            Box {
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.TopCenter)
                ) {
                    Column(
                        modifier = Modifier.padding(92.dp, 15.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        repeat(4) {
                            Text(
                                text = "item ${it + 1}",
                                color = Color.White,
                                modifier = Modifier
                                    .background(color = Color.DarkGray)
                                    .padding(15.dp)
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp, top = 20.dp)
                ) {
                    Column {
                        repeat(6) {
                            Text(
                                text = "                       |",
                                fontSize = 25.sp,
                                color = Color.Green
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(
                        "-------------------------------",
                        color = Color.Red
                    )
                }
            }

        }

}
