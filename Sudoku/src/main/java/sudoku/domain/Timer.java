package sudoku.domain;

/**
 * Luokka pitää kirjaa kuluneesta ajasta minuutteina ja sekunteina.
 */
public class Timer {

    private int seconds;
    private int minutes;

    public Timer() {
        this.seconds = 0;
        this.minutes = 0;
    }

    @Override
    public String toString() {
        String s = "";
        if (this.minutes < 10) {
            s += 0;
            s += this.minutes;
        } else {
            s += this.minutes;
        }
        s += ":";
        if (this.seconds < 10) {
            s += 0;
            s += this.seconds;
        } else {
            s += this.seconds;
        }
        return s;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Metodi kasvattaa aikaa yhdellä.
     */
    public void increase() {
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
        }
    }

    /**
     * Metodi palauttaa ajan nollaan.
     */
    public void reset() {
        this.seconds = 0;
        this.minutes = 0;
    }

}
