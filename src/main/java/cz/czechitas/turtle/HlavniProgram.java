package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {

        Turtle zofka = new Turtle();
        zofka.setPenColor(Color.magenta);

        Turtle leonardo = new Turtle();
        leonardo.setPenColor(Color.black);

        zofka.turnRight(90);
        zofka.setLocation(100, 100);
        nakresliRovnostrannyTrojuhelnik(zofka);

        zofka.setLocation(100, 200);
        nakresliCtverec(zofka, 100);

        zofka.setLocation(100, 400);
        nakresliKolecko(zofka, 15);

        zofka.setLocation(100, 600);
        nakresliObdelnik(zofka, 60.0, 120.0);
        zofka.setLocation(450, 100);

        nakresliZmrzlinu(leonardo);
        leonardo.setLocation(450, 100);

        zofka.setLocation(800, 600);
        nakresliSnehulaka(zofka);


    }

    private void nakresliSnehulaka(Turtle zofka) {
        zofka.setPenColor(Color.gray);
        zofka.turnRight(130);
        nakresliKolecko(zofka, 28);

        zofka.setLocation(800, 460);
        zofka.turnRight(20);
        nakresliKolecko(zofka, 20);

        zofka.setLocation(800, 390);
        zofka.turnRight(58);
        nakresliKolecko(zofka, 15);

        zofka.setLocation(850, 480);
        zofka.turnLeft(90);
        nakresliKolecko(zofka, 5);

        zofka.setLocation(625, 480);
        zofka.turnLeft(90);
        nakresliKolecko(zofka, 5);
    }

    private void nakresliMnohouhelnik(Turtle zofka, double delkaStrany, int pocetStran) {
        double uhel = 360.0 / pocetStran;
        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
    }

    private void nakresliCtverec(Turtle zofka, double delkaStrany) {
        for (int i = 0; i < 7; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }

    private void nakresliZmrzlinu(Turtle leonardo) {
        nakresliKornout(leonardo, 150);
        leonardo.penUp();
        leonardo.turnLeft(80);
        leonardo.move(15);
        leonardo.penDown();
        leonardo.setPenColor(Color.PINK);
        nakresliKolecko(leonardo, 15);
        leonardo.turnRight(20);
        leonardo.penUp();
    }

    private void nakresliKornout(Turtle leonardo, double velikostKornoutu) {
        leonardo.setLocation(300, 300);
        leonardo.turnRight(75);
        nakresliRovnoramennyTrojuhelnik(leonardo, velikostKornoutu, 30.00);
        leonardo.setPenColor(Color.GRAY);
    }

    private void nakresliRovnoramennyTrojuhelnik(Turtle zofka, double delkaStranyAB, double uhel) {
        zofka.turnRight(90);
        double stranaC = vypocitejDelkuTretiStrany(delkaStranyAB, uhel);
        double druhyUhel = (180 - uhel) / 2;
        zofka.move(delkaStranyAB);
        zofka.turnLeft(180 - uhel);
        zofka.move(delkaStranyAB);
        zofka.turnLeft(180 - druhyUhel);
        zofka.move(stranaC);
        zofka.turnRight(150);
    }

    private void nakresliKolecko(Turtle zofka, double delkaStrany) {
        nakresliMnohouhelnik(zofka, delkaStrany, 24);
    }

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0)) * 2.0);
        return tretiStrana;
    }

    private void nakresliRovnostrannyTrojuhelnik(Turtle zofka) {
        zofka.move(100);
        zofka.turnLeft(120.0);
        zofka.move(100);
        zofka.turnLeft(120.0);
        zofka.move(100);
        zofka.turnLeft(120.0);
    }

    private void nakresliObdelnik(Turtle zofka, double delkaKratsiStrany, double delkaDelsiStrany) {
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaKratsiStrany);
            zofka.turnRight(90);
            zofka.move(delkaDelsiStrany);
            zofka.turnRight(90);
        }
    }
}