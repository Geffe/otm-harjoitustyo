# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi etsiä DNA-sekvenssistä restriktioentsyymien katkaisukohdat ja hyödyntää ohjelmaa esimerkiksi geenitekniikassa. Ohjelmalla voi valita etsittävät entsyymien katkaisukohdat spesifisesti haluttujen entsyymien mukaan.
## Käyttäjät
Ainakin alussa sovelluksella on vain yhdenlaisia käyttäjiä ilman käyttäjätunnuksia. Sovelluksen käyttö ei välttämättä vaadi jatkossakaan tunnistautumista, koska tuloksia ei hyödytä tallentaa sovellukseen vaan ne kannaattaa tallettaa jatkokäyttöä varten omalle koneelle.
## Käyttöliittymäluonnos
Sovelluksen tekstikäyttöliittymä:
Ohjelma kysyy käyttäjältä tiedostopolkua tai sekvenssiä, joka syötetään sen jälkeen.
Ohjelma näyttää listan valittavista restriktioentsyymeistä.
Ohjelma pyytää käyttäjää kirjoittamaan haluamansa entsyymien nimet.
Ohjelma tulostaa DNA-sekvenssin, jossa entsyymien kohdat on korvattu entsyymien nimillä.
Ohjelma pyytää uudestaan käyttäjää kirjoittamaan haluamansa ensyymit, jos käyttäjä haluaa kokeilla muita entsyymejä.
Ohjelma tulostaa taas DNA-sekvenssin uusilla entsyymeillä merkattuna.

## Perusversion tarjoama toiminnallisuus
- Käyttäjä voi liittää sovellukseen DNA-sekvenssin tiedostona tai tekstinä
- Käyttäjä voi valita entsyymi-listasta haluamansa entsyymit, joiden kohtia sekvenssistä etsitään.
- Käyttäjä voi vaihtaa etsittyjä entsyymejä helposti tulosteen jälkeenkin ja luoda uuden tulosteen uusilla entsyymeillä.

## Jatkokehitysideoita
- Ohjelmasta voisi tehdä graafisen
- Käyttäjä voi valita automaattisesti esimerkiksi 5 yleisintä entsyymiä yhdellä valinnalla. 
- Käyttäjä voi kopioida tuloksen koneelleen.
- Tulosnäkymässä näkyy myös transkription aloitus- ja lopetuskohta 
- Päällekäisten entsyymien merkkaaminen esimerkiksi punaisella
- Käyttäjä voi itse kirjoittaa erilliseen kenttään etsittävän (entsyymi)sekvenssin.
- Sovellus osaa suositella tuloksen perusteella sopivia entsyymejä, mitä geenitekniikassa kannattaa käyttää
- Vielä pitemmälle kehitettynä käyttäjän ei tarvitse itse valita haluamiaan entsyymejä, vaan ohjelma osaa itse analysoida sekvenssin ja ehdottaa suoraan parhaimpia entsyymejä. Näin käyttäjän ei itse tarvitse analysoida tulosta. 
- Sovelluksen voi laittaa etsimään jotain muutakin kuin restriktioentsyymejä, esimerkiksi eksonit ja intronit.
- Tulosnäkymän voi muuttaa halutessaan niin, että restriktioentsyymien kohdalta tehdään rivinvaihto, jolloin tuloksen analysointi helpottuu.
-Graafinen käyttöliittymä: Sovelluksen ensimmäisessä näkymässä on iso tekstikenttä, johon voi liittää DNA-sekvenssin. Sen alapuolella on lista restriktioentsyymeistä, joista voi valita haluamansa. Viimeisenä nappi, josta pääsee seuraavaan näkymään eli tulokseen. Tuloksessa eri entsyymien kohdat näkyvät eri väreillä, jotta niitä voi vartailla helposti. Samassa näkymässä tuloksen yläpuolella näkyy vielä edellinen näkymä, jotta tulosta voi halutessaan vielä muokata eli lisätä tai vähentää haettuja entsyymejä. Tuloksen alapuolella on vielä nappi, josta tuloksen voi kopioida koneelle.
