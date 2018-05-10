# Testausdokumentti

Ohjelmaa on testattu JUnit testeillä.
### Sovelluslogiikan testaus
Ohjelma testaa viiden sovelluslogiikkaa sisältävän luokan. 
Testiluokat ovat: [DefaultEnzymesTest](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/src/test/java/DefaultEnzymesTest.java),
[EnzymeListTest](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/src/test/java/EnzymeListTest.java),
[EnzymeTest](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/src/test/java/EnzymeTest.java),
[SequenceSplitterTest](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/src/test/java/SequenceSplitterTest.java) ja 
[SequenceTest](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/src/test/java/SequenceTest.java).

### Testikattavuus
Käyttöliittymää lukuunottamatta ohjelman testauksen rivikattavuus on 80% ja haarautuvuuskattavuus on 87%.
<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/testit_palautus.png" width="800">

Luokkien App ja Main testaaminen osoittautui hankalaksi, joten luokille ei ole ollenkaan testejä. 
Luokasta Sequence jäi testaamatta kohta, jossa syötteenä annettu tiedosto on tiedosto, mutta sitä ei jostain syystä voikaan lukea, jos tiedosto on esimerkiksi lukittu.
Luokassa DefaultEnzymes testaaminen osoittautui hankalaksi, jos tiedosto ei toimisikaan.

### Sovellukseen jääneet laatuongelmat
Ohjelma ei tarkastele onko tekstinä annettu syöte DNA-sekvenssi vai jotain muuta. Jätin tämän tarkastelun pois, koska usein sekvensoitu sekvenssi voi sisältää monenlaista tietoa DNA-sekvenssin lisäksi ja sitä ei kannata erottaa sekvenssistä. Tarkasteltavan sekvenssin laatuää jää siis käyttäjän vastuulle. 

