package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by borcha on 22.04.17..
 */
@DatabaseTable(tableName = "roba")
public class Roba {

    public static final String POLJE_NAZIV="vrednost";
    public static final String POLJE_OPIS="opis";
    public static final String POLJE_TEZINA= "tezina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false)
    private String naziv;
    @DatabaseField(columnName=POLJE_OPIS,canBeNull = false)
    private String opis;
    @DatabaseField(columnName=POLJE_TEZINA,canBeNull = false)
    private double tezina;

    //VEZA sa avionom
    @DatabaseField(foreign =true,foreignAutoRefresh = true,canBeNull = false)
    private Avion avionn;

    
    public Roba(){ }

    public Roba(String _naziv,String _opis,double _tezina){
        this.naziv= _naziv;
        this.opis=_opis;
        this.tezina=_tezina;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public Avion getAvionn() {
        return avionn;
    }

    public void setAvionn(Avion avionn) {
        this.avionn = avionn;
    }

    public String toString(){
        return "AVION { " + this.id + " - " + this.naziv+ " " + this.opis+ " " + this.tezina + "}";
    }
}
