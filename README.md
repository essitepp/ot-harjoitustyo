# Sudoku


## Dokumentaatio

[Käyttöohje](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)  

[Vaatimusmäärittely](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  

[Arkkitehtuurikuvaus](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  

[Testausdokumentti](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)  

[Työaikakirjanpito](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md) 

## Releaset


## Komentorivitoiminnot

### Testaus

Sovelluksen testit suoritetaan komennolla
```
mvn test
```
Testikattavuusrapotti generoidaan komennolla
```
mvn jacoco:report
```
Testikattavuusraportti löytyy selaimella tiedostosta _target/site/jacoco/index.html_

### Jarin generointi

Sovelluksen jar-tiedosto generoidaan komennolla
```
mvn package
```
Tiedosto löytyy hakemistosta _target_

### JavaDoc

Sovelluksen JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```
JavaDoc löytyy selaimella tiedostosta _target/site/apidocs/index.html_

### Checkstyle

Tiedostossa _checkstyle.xml_ määritetyt tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Tarkistusten tulokset löytyvät selaimella tiedostosta _target/site/checkstyle.html_


