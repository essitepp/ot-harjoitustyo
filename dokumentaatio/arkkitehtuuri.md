# Arkkitehtuurikuvaus


## Pakkausrakenne

![pakkauskaavio](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)

Pakkaus sudoku.ui sisältää ohjelman käyttöliittymän, pakkaus sudoku.domain sovelluslogiikan, ja pakkaus sudoku.dao koodin tietokannan käsittelyyn.


## Käyttöliittymä

Sovelluksen käyttöliittymän eri näkymiä ovat:
- Päänäkymä, joka sisältää peliruudukon sekä painikkeet sudokun vaihtamiseen, tyhjentämiseen ja tarkistamiseen sekä tuloslistan näyttämiseen.
- Tarkistusnäkymä, kun ratkaisu on oikein. Näkymä sisältää tekstin, joka kertoo ratkaisun olevan oikein, sekä painikkeet tuloksen tallentamiseen ja seuraavan tuloksen aloittamiseen.
- Tarkistusnäkymä, kun ratkaisu on väärin. Näkymä sisältää tekstin, joka kertoo ratkaisun olevan väärin.
- Tulosnäkymä, joka sisältää listan kymmenestä parhaasta tuloksesta.

## Sovelluslogiikka

Sovelluksen luokka/pakkauskaavio:
![luokkakaavio](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)

## Tietojen tallennus

Sovelluksen tiedot tallennetaan tietokantaan, jota käsitellään luokkien SqlSudokuDao ja SqlScoreDao avulla.

### Tietokanta

Sovelluksen tietokanta sisältää tietokantataulut Sudoku, johon ratkaistavat sudokut on tallennettu, sekä Score, johon pelaajien tulokset tallennetaan.

## Päätoiminnallisuudet

#### Uuden sudokun aloittaminen

Kun käyttäjä klikkaa painiketta "Uusi sudoku", sovellus toimii seuraavasti:
![sekvenssikaavio](https://github.com/essitepp/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png)

