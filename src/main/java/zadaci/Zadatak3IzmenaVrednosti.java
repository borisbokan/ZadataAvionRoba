package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import model.Avion;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

/**
 U klasi Zadatak3IzmenaVrednosti, unutar main metode, izmeniti vrednost atributa opis za
 objekat Roba.
 Prikazati sve vrednosti iz tabele roba. Pronaći robu koja za opis ima postavljenu vrednost
 "Plasticna stolica" i promeniti vrednost opisa u "Drvena stolica". Izmene sačuvati u bazi.
 Prikazati sve vrednosti iz tabele roba da bi se potvrdilo da je izmenjena vrednost opisa.
 Implementiranu funkcionalnost komitovati u git repozitorijum i za tekst komit poruke napisati
 "Uradjen zadatak izmena vrednosti". Pushovati izmene na github.
 */
public class Zadatak3IzmenaVrednosti {

    private static myDB konekcija;
    private static Dao<Roba,Integer> DAORoba;
    private static Dao<Avion,Integer> DAOAvion;



    public static void main(String[] args){

        konekcija=new myDB();//kokecija sa bazom
        try {
            DAORoba= DaoManager.createDao(konekcija.getKonekcija(),Roba.class);
            DAOAvion= DaoManager.createDao(konekcija.getKonekcija(),Avion.class);

            //Prikaz svih podataka robe
            List<Roba> robe=DAORoba.queryForAll();

            Poruka.noviRed();
            Poruka.text("Prikaz liste roba");
            Poruka.linija40();
            for (Roba ro : robe) {
                 Poruka.text(ro.toString());
            }
            Poruka.nrlinr();



            //Upit za pronalazak robe sa kriterijumom...

            List<Roba> zaZamenu=DAORoba.queryForEq(Roba.POLJE_OPIS,"Plasticna stolica");
            Roba roba= zaZamenu.get(0);
            roba.setOpis("Drvena stolica");
            DAORoba.update(roba);


            //Prikaz nakon izmene
            List<Roba> robeNakon=DAORoba.queryForAll();

            Poruka.noviRed();
            Poruka.text("Prikaz liste roba nakon izmene stolice..");
            Poruka.linija40();
            for (Roba ro : robeNakon) {
                Poruka.text(ro.toString());
            }
            Poruka.nrlinr();


        } catch (SQLException e) {
            e.printStackTrace();
        }

       

    }
}
