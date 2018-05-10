# Enzyme-finder
Sovellus on tarkoitettu DNA-sekvenssien analysointiin ja ohjelmalla pystyy etsimään annetusta sekvenssistä yleisimpien restriktioentsyymien katkaisukohdat. 

## Dokumentaatio
[Käyttöohje](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/testaus.md)

[Työaikakirjanpito](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)


## Releaset

[palautus](https://github.com/Geffe/otm-harjoitustyo/releases/tag/palautus)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Enzyme-finder-1.0-SNAPSHOT.jar_

### Javadoc
JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_





