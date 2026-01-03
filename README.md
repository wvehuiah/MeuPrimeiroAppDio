# DIO – Cognizant - Mobile Developer

## 👤 Autor
**wvehuiah**  
🔗 GitHub: https://github.com/wvehuiah

---

### 📱 Criando um App Android com Suporte a Vários Idiomas

Projeto desenvolvido no contexto do desafio **“Criando um App Android utilizando o conceito de internacionalização (i18n)”**, proposto pela plataforma **DIO (Digital Innovation One)**.

🔗 [**Descrição oficial do desafio**](https://web.dio.me/project/criando-um-app-android-com-suporte-a-varios-idiomas/learning/9ca0e571-7150-4eef-81a7-f0b1e5a31eb8)  
<sub>Obs.: O acesso ao link requer uma conta ativa na plataforma DIO.</sub>

---  

>### DESCRIÇÃO
>Use o conhecimento adquirido nesse módulo para construir um projeto utilizando o conceito de internacionalização (i18n), ou seja, um App que terá suporte a diversas línguas, como inglês, português e espanhol. Nesse projeto, você poderá desenvolver sua capacidade abstrair um problema, analisar e aplicar implementações que forem necessárias para a conclusão deste desafio.

**Android | Kotlin**

---

### 🧩 Tecnologias
**Android | Kotlin | Jetpack Compose (Material 3)**

---

## MeuPrimeiroAppDio (Android • Kotlin • Jetpack Compose)

Aplicação Android em Kotlin usando **Jetpack Compose (Material 3)** com **internacionalização (i18n)** e **troca de idioma em runtime** por botões (PT-BR / EN / ES).

---

## ✅ O que este app demonstra  

- UI em **Jetpack Compose**
- Strings externalizadas em `strings.xml`
- Pastas de recursos por idioma:
    - `res/values/` (fallback/padrão)
    - `res/values-en/` (Inglês)
    - `res/values-es/` (Espanhol)
    - `res/values-pt-rBR/` (Português Brasil explícito)
- Uso de `stringResource()` no Compose
- Troca de idioma em runtime sem travar:
    - o idioma é controlado por **estado** no Compose
    - um `Context` localizado é aplicado para que `stringResource()` reflita a mudança imediatamente

---

## 📦 Requisitos

- Android Studio (Giraffe+ recomendado)
- Kotlin / Gradle
- Emulator/Device Android
- SDK instalado compatível com seu `compileSdk` (ex.: API 35)

---

## 🌍 Internacionalização

### Estrutura (exemplo)
- `app/src/main/res/values/strings.xml`
- `app/src/main/res/values-en/strings.xml`
- `app/src/main/res/values-es/strings.xml`
- `app/src/main/res/values-pt-rBR/strings.xml`

### Exemplo de string com placeholder
  
`values/strings.xml` (fallback/padrão):
```xml
<resources>
    <string name="hello_name">Olá %1$s!</string>
</resources>
```

`values-en/strings.xml`:
```xml
<resources>
    <string name="hello_name">Hello %1$s!</string>
</resources>
```

`values-es/strings.xml`:
```xml
<resources>
    <string name="hello_name">¡Hola %1$s!</string>
</resources>
```

`values-values-pt-rBR/strings.xml`:
```xml
<resources>
    <string name="hello_name">Olá %1$s!</string>
</resources>
```

**Uso no Compose**
```plaintext
Text(text = stringResource(R.string.hello_name, "Android"))
```

### 🔁 Troca de idioma em runtime (botões)
A troca de idioma é feita em tempo de execução via estado no Compose, aplicando um `Context` localizado.
Isso evita travamentos e elimina a necessidade de `recreate()`.

Exemplo conceitual:

```kotlin
var langTag by rememberSaveable { mutableStateOf("pt-BR") }
// ao clicar: langTag = "en" / "es" / "pt-BR"
```

Tags usadas:

- `pt-BR`
- `en`
- `es`

### ▶️ Como rodar

1. Clone o repositório
2. Abra no Android Studio
3. Sync Gradle
4. Execute no emulador/dispositivo

### 🔍 Observações úteis

- Preview do Compose não executa onClick no modo padrão.
    - Para testar cliques: rode no emulador/dispositivo ou use **Interactive Preview** quando disponível.
- Se uma string estiver faltando em `values-en` ou `values-es`, o Android faz fallback para `values/`.
- Se você quiser separar explicitamente pt-BR, use `values-pt-rBR/` (observação: é `pt-rBR`, com `r`).

### 📄 Licença

Este projeto está licenciado sob a Apache License 2.0. Consulte o arquivo `LICENSE`.

