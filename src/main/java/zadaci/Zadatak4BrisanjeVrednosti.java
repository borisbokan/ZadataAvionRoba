package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

/**
 U klasi Zadatak4BrisanjeVrednosti, unutar main metode, obrisati jednu Robu.
 Prikazati sve vrednosti iz tabele roba. Pronaći robu koja za naziv ima postavljenu vrednost
 "Voda" i obrisati tu robu iz baze.
 Prikazati sve vrednosti iz tabele roba da bi se potvrdilo da je roba obrisana.
 Implementiranu funkcionalnost komitovati u git repozitorijum i za tekst komit poruke napisati
 "Uradjen zadatak brisanja vrednosti". Pushovati izmene na github.
 */
public class Zadatak4BrisanjeVrednosti {

    private static myDB konekcija;

    private static Dao<Roba,Integer> DAORoba=null;

    public static void main(String[] args){

        konekcija=new myDB();//kokecija sa bazom
        try {
            DAORoba= DaoManager.createDao(konekcija.getKonekcija(),Roba.class);


            List<Roba> robe=DAORoba.queryForAll();
            Poruka.noviRed();
            Poruka.text("Prikaz liste pre brisanja robe...");
            Poruka.linija40();
            for (Roba stavka : robe) {
                          Poruka.text(stavka.toString());
            }
            Poruka.nrlinr();

            //Brisanje robe
            Poruka.text("Brisem robu...");
            List<Roba> zaBrisanje=DAORoba.queryForEq(Roba.POLJE_NAZIV,"Voda");
            Roba roba=zaBrisanje.get(0);
            DAORoba.delete(roba);
            Poruka.text("Roba obrisana..");
            Poruka.noviRed();

              //Nakon brisanja
            List<Roba> robeNakon=DAORoba.queryForAll();
            Poruka.noviRed();
            Poruka.text("Prikaz liste nakon brisanja robe...");
            Poruka.linija40();
            for (Roba stavka : robeNakon) {
                Poruka.text(stavka.toString());
            }
            Poruka.nrlinr();



            



        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            konekcija.zatvoriKonekciju();
        }

    }
}
