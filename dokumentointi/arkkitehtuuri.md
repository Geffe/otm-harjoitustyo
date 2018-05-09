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


Alustava luokkakaavio: 

<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png" width="500">

Alustava sekvenssikaavio:

<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/sekvenssikaavio-Enzyme-f.png" width="700">
