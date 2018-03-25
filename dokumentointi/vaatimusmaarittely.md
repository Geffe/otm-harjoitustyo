# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi etsiä DNA-sekvenssistä restriktioentsyymien katkaisukohdat ja hyödyntää ohjelmaa esimerkiksi geenitekniikassa. Ohjelmalla voi valita etsittävät entsyymien katkaisukohdat spesifisesti haluttujen entsyymien mukaan.
## Käyttäjät
Ainakin alussa sovelluksella on vain yhdenlaisia käyttäjiä ilman käyttäjätunnuksia. Sovelluksen käyttö ei välttämättä vaadi jatkossakaan tunnistautumista, koska tuloksia ei hyödytä tallentaa sovellukseen vaan ne kannaattaa tallettaa jatkokäyttöä varten omalle koneelle.
## Käyttöliittymäluonnos
Sovelluksen yksinkertaisin versio sisältää kaksi näkymää. 
<img src="https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/index.jpeg" width="750">
Sovelluksen ensimmäisessä näkymässä on iso tekstikenttä, johon voi liittää DNA-sekvenssin. Sen alapuolella on lista restriktioentsyymeistä, joista voi valita haluamansa. Viimeisenä nappi, josta pääsee seuraavaan näkymään eli tulokseen. Tuloksessa eri entsyymien kohdat näkyvät eri väreillä, jotta niitä voi vartailla helposti. Samassa näkymässä tuloksen yläpuolella näkyy vielä edellinen näkymä, jotta tulosta voi halutessaan vielä muokata eli lisätä tai vähentää haettuja entsyymejä. Tuloksen alapuolella on vielä nappi, josta tuloksen voi kopioida koneelle.
## Perusversion tarjoama toiminnallisuus
- Käyttäjä voi liittää sovellukseen DNA-sekvenssin tiedostona tai tekstinä
- Käyttäjä voi itse valita haluamansa entsyymit, joiden kohtia sekvenssistä etsitään.
- Käyttäjä voi vaihtaa etsittyjä entsyymejä helposti tulosnäkymän jälkeenkin ja luoda uuden tulosnäkymän uusilla entsyymeillä.
- Käyttäjä voi kopioida tuloksen koneelleen.
## Jatkokehitysideoita
- Tulosnäkymässä näkyy myös transkription aloitus- ja lopetuskohta 
- Päällekäisten entsyymien merkkaaminen esimerkiksi punaisella
- Käyttäjä voi itse kirjoittaa erilliseen kenttään etsittävän sekvenssin.
- Sovellus osaa suositella tuloksen perusteella sopivia entsyymejä, mitä geenitekniikassa kannattaa käyttää
- Vielä pitemmälle kehitettynä käyttäjän ei tarvitse itse valita haluamiaan entsyymejä, vaan ohjelma osaa itse analysoida sekvenssin ja ehdottaa suoraan parhaimpia entsyymejä. Näin käyttäjän ei itse tarvitse analysoida tulosta. 
- Sovelluksen voi laittaa etsimään jotain muutakin kuin restriktioentsyymejä, esimerkiksi eksonit ja intronit.
- Tulosnäkymän voi muuttaa halutessaan niin, että restriktioentsyymien kohdalta tehdään rivinvaihto, jolloin tuloksen analysointi helpottuu.
