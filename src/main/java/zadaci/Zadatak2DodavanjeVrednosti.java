package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.Avion;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by borcha on 22.04.17..
 */
public class Zadatak2DodavanjeVrednosti {

    private static myDB konekcija;

    private static Dao<Avion,Integer> DAOAvion=null;
    private static Dao<Roba,Integer> DAORoba=null;


    public static void main(String[] args){

        konekcija=new myDB();//kokecija sa bazom
        try {
            Poruka.text("Instanciram Dao za Avion");
            DAOAvion= DaoManager.createDao(konekcija.getKonekcija(),Avion.class);
            Poruka.text("Instanciram Dao za Robu");
            DAORoba=DaoManager.createDao(konekcija.getKonekcija(),Roba.class);

            //Instanciranje Aviona
            Avion avion1=new Avion("Avion1",34);
            Avion avion2=new Avion("Avion2",21);


            //Instanciranje roba sa avionima
            Roba artikal1=new Roba("Patike","Duboke patike",1);
            artikal1.setAvionn(avion1);

            Roba artikal2=new Roba("Kosulja","Na duge rukave",0.4);
            artikal2.setAvionn(avion1);

            Roba artikal3=new Roba("Voda","Voda za pice",1.4);
            artikal3.setAvionn(avion1);

            Roba artikal4=new Roba("Ploce","Drvene ploce",3.4);
            artikal4.setAvionn(avion2);

            Roba artikal5=new Roba("Stolica","Plasticna stolica",2.4);
            artikal5.setAvionn(avion2);

            Roba[]  artikli={artikal1,artikal2,artikal3,artikal4,artikal5};

            Poruka.linija40();
            Poruka.text("Unosim robu....");
            //Unosim podatke robe u bazu podataka
            for (Roba stavka : artikli ) {
                DAORoba.create(stavka);
            }
            Poruka.linija40();Poruka.text("Roba unesena u bazu..");
            Poruka.noviRed();


            Poruka.linija40();
            Poruka.text("Listanje unesene robe");
            //Pregled unesenih stavki
            List<Roba> unesenaRoba=DAORoba.queryForAll();

            for (Roba r : unesenaRoba ) {
                Poruka.text(r.toString());
            }

            Poruka.noviRed();
            Poruka.text("Artikli izlistani");
            Poruka.linija40();
            Poruka.noviRed();


        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
