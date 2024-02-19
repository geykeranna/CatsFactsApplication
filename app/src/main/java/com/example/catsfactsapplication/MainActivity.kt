package com.example.catsfactsapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.catsfactsapplication.data.models.cats_api.CatFactsGetResponse
import com.example.catsfactsapplication.ui.screens.main.MainScreen
import com.example.catsfactsapplication.ui.theme.CatsFactsApplicationTheme
import com.example.catsfactsapplication.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsFactsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var fact by remember {
                        mutableStateOf(CatFactsGetResponse())
                    }

                    val context = LocalContext.current
                    val scope = rememberCoroutineScope()

                    LaunchedEffect(key1 = true) {
                        scope.launch(Dispatchers.IO) {
                            val response = try {
                                RetrofitInstance.api.getRandomFacts()
                            } catch (e: Exception) {
                                Log.e("Exception", e.message.toString())
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(
                                        context,
                                        "http error: ${e.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                return@launch
                            }

                            if (response.isSuccessful && !response.body()?.data.isNullOrEmpty()){
                                response.body()?.data?.forEach {
                                    val translatedFact = try {
                                        RetrofitInstance.translateApi.getTranslate(q = it.fact)
                                    } catch (e: Exception) {
                                        withContext(Dispatchers.Main) {
                                            Log.e("Exception", e.message.toString())
                                            Toast.makeText(
                                                context,
                                                "http error: ${e.message}",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                        return@launch
                                    }
                                    if (translatedFact.isSuccessful && !translatedFact.body()?.responseData?.translatedText.isNullOrEmpty()){
                                        it.fact = translatedFact.body()?.responseData?.translatedText.toString()
                                    }
                                }
                                withContext(Dispatchers.Main){
                                    fact = response.body()!!
                                }
                            }
                        }
                    }

                    fact.data?.let { MainScreen(facts = it) }
                }
            }
        }
    }
}