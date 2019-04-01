package hsl;

public class HSL {

    public static void main(String[] args) {

        HKLLaitehallinto laitehallinto = new HKLLaitehallinto();

        Lataajalaite rautatietori = new Lataajalaite();
        Lukijalaite ratikka6 = new Lukijalaite();
        Lukijalaite bussi244 = new Lukijalaite();

        laitehallinto.lisaaLataaja(rautatietori);
        laitehallinto.lisaaLukija(ratikka6);
        laitehallinto.lisaaLukija(bussi244);

        Kioski lippuLuukku = new Kioski();
        Matkakortti artonKortti = lippuLuukku.ostaMatkakortti("Arto");

        rautatietori.lataaArvoa(artonKortti, 3);

        ratikka6.ostaLippu(artonKortti, 0);
        bussi244.ostaLippu(artonKortti, 2);
    }

}
