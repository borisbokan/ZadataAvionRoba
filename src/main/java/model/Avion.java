package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by borcha on 22.04.17..
 */
@DatabaseTable(tableName = "avion")
public class Avion {


    public static final String POLJE_OZNAKA= "oznaka";
    public static final String POLJE_RASPON_KRILA ="raspon_krila";

    @DatabaseField(columnName = "id",generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA,canBeNull = false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_RASPON_KRILA,canBeNull = false)
    private int rasponKrila;

   @ForeignCollectionField(foreignFieldName = "avionn")
     ForeignCollection<Roba> robe;



    public Avion(){}

    public Avion(String _oznaka,int _rasponKrila){
            
            this.oznaka=_oznaka;
            this.rasponKrila=_rasponKrila;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    public ForeignCollection<Roba> getRobe() {
        return robe;
    }

    public void setRobe(ForeignCollection<Roba> robe) {
        this.robe = robe;
    }

    public String toString(){
        return " >ID:" +this.id + " - Oznaka Av." + this.getOznaka() + " - " + "Raspon: " +this.rasponKrila;
    }
}
