# WeatherApp

## Retrofit
Retrofit on kirjasto HTTP-pyyntöjen tekemiseen Androidissa. Se helpottaa API-kutsujen tekemistä määrittelemällä rajapinnan (interface), jonka kautta data haetaan verkosta.

## JSON → dataluokat
API palauttaa datan JSON-muodossa. Gson muuntaa JSON-vastauksen automaattisesti Kotlinin dataluokiksi Retrofitin kautta.

## Coroutines
API-kutsu suoritetaan coroutineilla taustasäikeessä, jotta käyttöliittymä ei jäädy. Kun data saapuu, UI päivittyy automaattisesti.

## UI-tila
ViewModel hallitsee WeatherUiState-tilaa. Jetpack Compose reagoi tilan muutoksiin ja päivittää näkymän automaattisesti.

## API-avain
API-key tallennetaan local.properties-tiedostoon → siirretään BuildConfig-muuttujaan → käytetään Retrofit API-kutsussa.
