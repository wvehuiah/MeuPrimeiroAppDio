# DIO – Cognizant - Mobile Developer

## 👤 Autor
**wvehuiah**  
🔗 GitHub: https://github.com/wvehuiah

---

### 📱 Criando um App Android com Suporte a Vários Idiomas

Projeto desenvolvido no contexto do desafio **“Utilização Prática no Cenário de Microsserviços”**, proposto pela plataforma **DIO (Digital Innovation One)**.

🔗 [**Descrição oficial do desafio**](https://web.dio.me/lab/docker-utilizacao-pratica-no-cenario-de-microsservicos/learning/01c90219-29e6-46da-bad9-9542f621b9c2)  
<sub>Obs.: O acesso ao link requer uma conta ativa na plataforma DIO.</sub>

---  

>### DESCRIÇÃO
>Use o conhecimento adquirido nesse módulo para construir um projeto utilizando o conceito de internacionalização (i18n), ou seja, um App que terá suporte a diversas línguas, como inglês, português e espanhol. Nesse projeto, você poderá desenvolver sua capacidade abstrair um problema, analisar e aplicar implementações que forem necessárias para a conclusão deste desafio.

**Android | Kotlin**

---

### MeuPrimeiroAppDio (Android • Kotlin • Jetpack Compose)

Projeto Android em Kotlin usando **Jetpack Compose (Material 3)** com **internacionalização (i18n)** e **troca de idioma em runtime** por botões (PT-BR / EN / ES).

---

### ✅ O que este app demonstra

- UI em **Jetpack Compose**
- Strings externalizadas em `strings.xml`
- Pastas de recursos por idioma:
    - `res/values/` (fallback/padrão)
    - `res/values-en/` (Inglês)
    - `res/values-es/` (Espanhol)
- Uso de `stringResource()` no Compose
- Troca de idioma do app via:
    - `AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(...))`
    - `recreate()` para aplicar imediatamente

---

### 📦 Requisitos

- Android Studio (Giraffe+ recomendado)
- Kotlin
- Gradle
- Emulator/Device Android

---

### 🧩 Dependências principais

- Jetpack Compose (Material3)
- AppCompat (para aplicar locales por app)

No `build.gradle(.kts)` do módulo `app` (exemplo):

```kotlin
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    // demais libs do Compose via BOM...
}
```

### 🎨 Tema (IMPORTANTE)

Para usar ```AppCompatActivity``` (necessário para troca de idioma via AppCompat), o tema precisa herdar de **Theme.AppCompat.**

Em:
- res/values/themes.xml
- res/values-night/themes.xml

Exemplo:
```xml
<style name="Theme.MeuPrimeiroAppDio" parent="Theme.AppCompat.DayNight.NoActionBar" />
```

### 🌍 Internacionalização

Estrutura:
- ```app/src/main/res/values/strings.xml```
- ```app/src/main/res/values-en/strings.xml```
- ```app/src/main/res/values-es/strings.xml```

**Exemplo de string com placeholder**  
```values/strings.xml``` (pt-BR ou fallback):
```xml
<resources>
    <string name="hello_name">Olá %1$s!</string>
</resources>
```

```values-en/strings.xml```:
```xml
<resources>
    <string name="hello_name">Hello %1$s!</string>
</resources>
```

```values-es/strings.xml```:
```xml
<resources>
    <string name="hello_name">¡Hola %1$s!</string>
</resources>
```

**Uso no Compose**
```plaintext
Text(text = stringResource(R.string.hello_name, "Android"))
```

### 🔁 Troca de idioma em runtime (botões)

Implementação:
```kotlin
fun setAppLanguage(langTag: String) {
    AppCompatDelegate.setApplicationLocales(
        LocaleListCompat.forLanguageTags(langTag)
    )
}
```

No ```onClick```:
```kotlin
setAppLanguage("pt-BR")
recreate()
```

Tags usadas:

- ```pt-BR```
- ```en```
- ```es```

### ▶️ Como rodar

1. Clone o repositório
2. Abra no Android Studio
3. Sync Gradle
4. Execute no emulador/dispositivo

### 🔍 Observações úteis

- Preview **não executa onClick** no modo padrão. Para testar clique:
    - Rode no emulador/dispositivo, ou
    - Use ***Interactive Preview*** (quando disponível).
- Se uma string estiver faltando em values-en ou values-es, o Android faz fallback para values/.

### 📄 ## Licença

Este projeto está licenciado sob a Apache License 2.0. Consulte o arquivo `LICENSE`.

