# Käyttöohje

## Konfigurointi
Ohjelman pakkauksesa _enzymes_ on tiedosto, josta ohjelma hakee kaikki oletusentsyymit. 

```
defaultEnzymes.xml

```
## Ohjelman käynnistäminen
Ohjelman käynnistys komennolla:
```
java -jar Enzyme-finder.jar
```
## Ohjelman kulku

Ohjelma kysyy käyttäjältä ensin DNA-sekvenssiä tai tiedostopolkua. Jos käyttäjä antaa virheellisen syötteen, kuten toimimattoman tiedostopolun tai tiedostoa ei pystytä avaamaan, niin ohjelma kysyy uutta syötettä. 
(Pakkauksesta _ui_ löytyy tiedosto example_sequence.txt, jonka tiedostopolkua voi käyttää tiedoston lukemisen kokeiluun. Pakkauksesta löytyy myös tiedosto, jonka sisällä on valmiina pari entsyymeillä merkattua sekvenssiä, joita voi käyttää sekvenssin lukemisen kokeiluun.)

Kun syötteen lukeminen on onnistunut, ohjelma näyttää listan valittavista oletusentsyymeistä. 
Ohjelma kysyy käyttäjältä käyttäjän haluamia entsyymien nimiä. Entsyymien valinnan voi lopettaa syötteellä "x". 

Tämän jälken ohjelma tulostaa käyttäjän antaman sekvenssin entsyymeillä muokattuna. Käytännössä tämä tarkoittaa, että sekvenssistä löytyvät entsyymien kohdat on korvattu kyseisestä kohdasta entsyymin nimellä. 

Ohjelma kysyy haluaako käyttäjä jatkaa vai lopettaa. Syöte "lopeta" lopettaa ohjelman. Syöte "jatka" palaa taas entsyymien valintaan, jolloin käyttäjä voi testata löytyykö sekvenssistä muita entsyymejä.
