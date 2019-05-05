# Käyttöohje

Lataa tiedostot sudoku.jar ja database.db

## Kongigurointi

Sovelluksen käyttämä tietokanta määritetään konfiguraatiotiedostossa config.properties. Määritys on muodossa
```
database=database.db
```

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla
```
java -jar sudoku.jar
```

## Sudokun ratkaiseminen

Päänäkymän painikkeesta "Uusi sudoku" voi aloittaa uuden sudokun. 
Painikkeella "Tyhjennä" käyttäjä voi tyhjentää keskeneräisestä sudokusta syöttämänsä numerot.
Sudokuruudukon numeroita muutetaan ruutuja klikkaamalla. 
Ratkaisun voi tarkistaa klikkaamalla painiketta "Tarkista".
![kaytto-ohje](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoohje_1.png)

## Tuloksen tallentaminen

Kun käyttäjä on klikannut "Tarkista"-painiketta ratkaisun ollessa oikein, avautuu uusi näkymä, jossa on painike "Tallenna tulos".   
![kaytto-ohje](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoohje_2.png)  
Tätä painiketta klikkaamalla sovellus siirtyy näkymään, jossa käyttäjä voi syöttää nimimerkin ja tallentaa tuloksensa.  
![kaytto-ohje](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoohje_3.png)

## Tuloslista näyttäminen

Tuloslistaa pääsee katsomaan klikkaamalla päänäkymän painiketta "Tulokset". Tuloslistassa listataan kymmenen parasta tulosta.


