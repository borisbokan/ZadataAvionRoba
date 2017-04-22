package zadaci;

import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.sql.SQLException;

/**
 * Created by borcha on 22.04.17..
 */
public class Zadatak1KreiranjeTabela {

    private static myDB konekcija;

    public static void main(String[] args){

        konekcija=new myDB();//kokecija sa bazom

        try {

            //Brisem tabele
            Poruka.text("Prvo brisem tabelu Roba zbog odnosa 1:N - N je roba!");
            TableUtils.dropTable(konekcija.getKonekcija(),Roba.class,true);
            Poruka.text("Tabela roba obrisana!");

            Poruka.text("Zatim brise tabelu Avion...");
            TableUtils.dropTable(konekcija.getKonekcija(),Avion.class,true);
            Poruka.text("Tabela Avion obrisana...");

            //Pravim tabele
            Poruka.text("Pravim tabelu Avion...");
            TableUtils.createTable(konekcija.getKonekcija(), Avion.class);
            Poruka.text("Pravim tabelu Roba...");
            TableUtils.createTable(konekcija.getKonekcija(), Roba.class);
            Poruka.text("Tabela roba napravljena...");

        } catch (SQLException e) {
            Poruka.text("Desila se greska pod brojem: " + e.getErrorCode() + " sa porukom: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            Poruka.text("Zatvaram konekciju sa bazom podataka.");
            konekcija.zatvoriKonekciju();//Zatvaranje konekcije sa bazom
        }


    }
}
