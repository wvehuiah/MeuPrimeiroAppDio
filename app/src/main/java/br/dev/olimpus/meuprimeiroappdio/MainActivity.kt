package br.dev.olimpus.meuprimeiroappdio

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.dev.olimpus.meuprimeiroappdio.ui.theme.MeuPrimeiroAppDioTheme
import java.util.Locale

private fun Context.localized(langTag: String): Context {
    val config = Configuration(resources.configuration)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        config.setLocales(LocaleList.forLanguageTags(langTag))
    } else {
        @Suppress("DEPRECATION")
        config.setLocale(Locale.forLanguageTag(langTag))
    }
    return createConfigurationContext(config)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var langTag by rememberSaveable { mutableStateOf("pt-BR") }

            MeuPrimeiroAppDioTheme {
                MainScreen(
                    langTag = langTag,
                    onChangeLanguage = { langTag = it }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    langTag: String,
    onChangeLanguage: (String) -> Unit,
) {
    val base = LocalContext.current
    val localizedContext = remember(base, langTag) { base.localized(langTag) }

    CompositionLocalProvider(LocalContext provides localizedContext) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(12.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { onChangeLanguage("pt-BR") },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("PT-BR") }
                Button(
                    onClick = { onChangeLanguage("en") },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("EN") }
                Button(
                    onClick = { onChangeLanguage("es") },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("ES") }

                Text(text = stringResource(R.string.selected_language, langTag))
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.hello_name, "Android"))
            }
        }
    }
}
