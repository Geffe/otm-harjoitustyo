
## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Testikattavuusraportti](https://github.com/Geffe/otm-harjoitustyo/blob/master/dokumentointi/kuvat/testikattavuusraportti24.4.png)

## Releaset

[viikko 5](https://github.com/Geffe/otm-harjoitustyo/releases)

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

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/Geffe/otm-harjoitustyo/blob/master/Enzyme-finder/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_





