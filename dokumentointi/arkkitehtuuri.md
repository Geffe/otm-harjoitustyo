# Arkkitehtuurikuvaus
## Rakenne
Ohjelma sisältää viisi pakkausta: 
- _main_ sisältää vain luokan Main, joka käynnistää koko ohjelman.
- _application_ vastaa ohjelman kulusta ja sovelluslogiikasta.
- _ui_ sisältää tekstikäyttöliittymän.
- _enzymes_ vastaa entsyymeihin liittyvästä sovelluslogiikasta.
- _sequence_ vastaa sekvensseihin liittyvästä sovelluslogiikasta.

## Käyttöliittymä
Ohjelma toteuttaa tekstikäyttöliittymän, jossa käyttäjä ensin syöttää joko tiedostopolun tai valmiin DNA-sekvenssin. Tämän jälkeen käyttäjä kirjoittaa haluamansa entsyymit ja sekvenssi tulostetaan entsyymien mukaan muokattuna. Tämän jälkeen käyttäjä voi lopettaa ohjelman tai jatkaa valitsemalla eri entsyymit kuin aiemmin.
## Sovelluslogiikka
Sovelluslogiikkaa muodostavat luokat Enzyme, EnzymeList, Sequence ja SequenceSplitter, jotka käsittelevät entsyymejä ja sekvenssejä. 

Koko ohjelman toiminnallisuudesta vastaa luokka App, jonka run()-metodi ajaa koko ohjelman läpi.

## Tietojen tallennus
Ohjelma ei talleta pysyvästi tietoja tiedostoon, mutta luokka DefaultEnzymes lukee ohjelman suorituksen alussa xml-tiedostosta oletusentsyymit,joista käyttäjä voi valita haluamansa entsyymit. 

### Tiedostot
Pakkauksessa _enzymes_ on defaultEnzymes.xml tiedosto,jossa oletusentsyymit sijaitsevat. Pakkausessa _ui_ sijaitsee tekstitiedostoja, joiden sisältöä voi käyttää esimerkkinä kokeillessa ohjelmaa. Tiedoston example_sequence.txt tiedostopolun voi suoraan syöttää ohjelmaan ja tiedoston sequenceExamples sisällöstä voi valita haluamansa sekvenssin ja syöttää ohjelmaan. Todellisuudessa ohjelmalla käytettäisiin huomattavasti suurempia sekvenssejä, mutta esimerkkisevenssit ovat tarkoituksella huomattavasti lyhyempiä.

## Päätoiminnallisuudet
Kronologisessa järjestyksessä:

### Oletusentsyymien hakeminen tiedostosta
Yksinkertaistettuna: 

<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/S1defaultEnzymes.png" width="1000">

### Käyttöliittymän alku ja entsyymien valinta
Noudattaa kulkua, jossa käyttäjä syöttää oikeita ja toimivia syötteitä.
<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/S2k%C3%A4ytt%C3%B6liittym%C3%A4nAlku-valitutEntsyymit.png" width="900">

### Sekvenssin muokkaaminen entsyymien mukaan

<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/S3sekvenssinSplittaus.png" width="900">



