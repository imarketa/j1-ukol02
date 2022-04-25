package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {

        Turtle zofka = new Turtle();
        zofka.setPenColor(Color.magenta);

        Turtle leonardo = new Turtle();
        leonardo.setPenColor(Color.black);

        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().height);

        zofka.turnRight(90);
        zofka.setLocation(100, 100);
        nakresliRovnostrannyTrojuhelnik(zofka, 100);

        zofka.setLocation(100, 300);
        nakresliCtverec(zofka, 100);

        zofka.setLocation(150, 500);
        nakresliKolecko(zofka, 15);

        zofka.setLocation(100, 650);
        nakresliObdelnik(zofka, 100.0, 50.0);

        zofka.setLocation(450, 100);

        leonardo.setLocation(300, 300);
        nakresliZmrzlinu(leonardo);
        leonardo.setLocation(450, 100);

        zofka.setLocation(800, 600);
        nakresliSnehulaka(zofka);

        zofka.setLocation(1300, 740);
        zofka.setPenColor(Color.black);
        nakresliVlak(zofka);

    }

    private void nakresliVlak(Turtle zofka) {
        nakresliObdelnik(zofka, 160.0, 240.0);
        zofka.turnLeft(90);
        //lezici obdelnik
        nakresliObdelnik(zofka, 120.0, 220.0);
        //velke kolo
        zofka.setLocation(1460, 740);
        nakresliKolecko(zofka, 22);
        //male kola
        zofka.setLocation(1250, 770);
        nakresliKolecko(zofka, 8);

        zofka.setLocation(1150, 770);
        nakresliKolecko(zofka, 8);

        zofka.setX(960);
        nakresliRovnoramennyTrojuhelnik(zofka,120,90);
    }

    private void nakresliSnehulaka(Turtle zofka) {
        zofka.setPenColor(Color.gray);
        //velke kolo
        nakresliKolecko(zofka, 28);
        //stredni kolo
        zofka.setLocation(800, 380);
        nakresliKolecko(zofka, 20);
        //hlava
        zofka.setLocation(800, 220);
        nakresliKolecko(zofka, 15);
        //ruce
        zofka.setLocation(910, 320);
        nakresliKolecko(zofka, 5);

        zofka.setLocation(710, 320);
        nakresliKolecko(zofka, 5);
    }

    private void nakresliMnohouhelnik(Turtle zofka, double delkaStrany, int pocetStran) {
        double uhel = 360.0 / pocetStran;
        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnLeft(uhel);
        }
    }

    private void nakresliCtverec(Turtle zofka, double delkaStrany) {
        nakresliObdelnik(zofka, delkaStrany, delkaStrany);
    }

    private void nakresliZmrzlinu(Turtle leonardo) {
        nakresliKornout(leonardo, 150, Color.GRAY);
        leonardo.penUp();
        leonardo.turnRight(180);
        leonardo.move(30);
        leonardo.penDown();
        leonardo.setPenColor(Color.PINK);
        nakresliKolecko(leonardo, 12);
        leonardo.turnRight(20);
        leonardo.penUp();
    }

    private void jdibokemvpravo(Turtle zelva, double vzdalenost) {
        zelva.turnRight(90);
        zelva.move(vzdalenost);
        zelva.turnLeft(90);
    }

    private void zacouvej(Turtle zelva, double vzdalenost) {
        zelva.turnRight(180);
        zelva.move(vzdalenost);
        zelva.turnRight(180);
    }

    private void nakresliKornout(Turtle leonardo, double velikostKornoutu, Color barvaKornoutu) {
        leonardo.turnRight(75);
        nakresliRovnoramennyTrojuhelnik(leonardo, velikostKornoutu, 30.00);
        leonardo.setPenColor(barvaKornoutu);
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
    }

    private void nakresliKolecko(Turtle zofka, double delkaStrany) {
        nakresliMnohouhelnik(zofka, delkaStrany, 24);
    }

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0)) * 2.0);
        return tretiStrana;
    }

    private void nakresliRovnostrannyTrojuhelnik(Turtle zofka, double delkaStrany) {
        zofka.move(delkaStrany);
        zofka.turnLeft(120.0);
        zofka.move(delkaStrany);
        zofka.turnLeft(120.0);
        zofka.move(delkaStrany);
        zofka.turnLeft(120.0);
    }

    private void nakresliObdelnik(Turtle zofka, double stranaA, double stranaB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(stranaA);
            zofka.turnLeft(90);
            zofka.move(stranaB);
            zofka.turnLeft(90);
        }
    }
}