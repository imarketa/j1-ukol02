package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;
import net.sevecek.util.web.AcceptHeaderAccordingToUrlExtensionFilter;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {

        Turtle zofka = new Turtle();
        zofka.setPenColor(Color.magenta);


        zofka.turnRight(90);
        zofka.setLocation(100, 100);
        nakresliRovnostrannyTrojuhelnik(zofka, 100);

        zofka.setLocation(100, 200);
        nakresliCtverec(zofka);

        zofka.setLocation(100, 400);
        nakresliKolecko(zofka, 13);

        zofka.setLocation(100, 600);
        nakresliObdelnik(zofka, 60, 120);
    }


    private void nakresliKolecko(Turtle zofka, double delkaStrany) {
        int pocetStran = 24;
        double uhel = 360.0 / pocetStran;
        for (int i = 0; i < 24; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
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

    private void nakresliPravouhlyTrojuhelnik(Turtle zofka, double delkaStranyA, double delkaStranyB) {
    }

    private void nakresliObdelnik(Turtle zofka, double delkaKratsiStrany, double delkaDelsiStrany) {
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaKratsiStrany);
            zofka.turnRight(90);
            zofka.move(delkaDelsiStrany);
            zofka.turnRight(90);
        }
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

    private void nakresliCtverec(Turtle zofka) {
        for (int i = 0; i < 7; i++) {
            zofka.move(100);
            zofka.turnRight(90);
        }
    }
}