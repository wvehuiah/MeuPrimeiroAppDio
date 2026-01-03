package br.dev.olimpus.meuprimeiroappdio

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import br.dev.olimpus.meuprimeiroappdio.ui.theme.MeuPrimeiroAppDioTheme

@Composable
fun MainScreen(
    onPt: () -> Unit,
    onEn: () -> Unit,
    onEs: () -> Unit,
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onPt,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("PT-BR") }

                Button(
                    onClick = onEn,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("EN") }

                Button(
                    onClick = onEs,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("ES") }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.hello_name, "Android"))
        }
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MeuPrimeiroAppDioTheme {
                MainScreen(
                    onPt = { setAppLanguage("pt-BR"); recreate() },
                    onEn = { setAppLanguage("en"); recreate() },
                    onEs = { setAppLanguage("es"); recreate() },
                )
            }
        }
    }
}

fun setAppLanguage(langTag: String) {
    AppCompatDelegate.setApplicationLocales(
        LocaleListCompat.forLanguageTags(langTag)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.hello_name, name),
        modifier = modifier
    )
}

@Preview(showBackground = true, locale = "pt")
@Composable
fun GreetingPreviewPt() {
    MeuPrimeiroAppDioTheme { Greeting("Android") }
}

@Preview(showBackground = true, locale = "en")
@Composable
fun GreetingPreviewEn() {
    MeuPrimeiroAppDioTheme { Greeting("Android") }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun GreetingPreviewEs() {
    MeuPrimeiroAppDioTheme { Greeting("Android") }
}
