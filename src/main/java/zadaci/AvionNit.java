package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import model.Avion;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by borcha on 23.04.17..
 */
public class AvionNit extends  Thread{

      private   Boolean dozvola=false;

      Avion avion;



      public AvionNit(Avion _avion){
          this.avion=_avion;
      }


      private void poletanje(){

          proveraOpreme();
          trazimDozvolu();

           synchronized (dozvola){
               do{

                   try {
                       Poruka.text("Avion " + this.avion.getOznaka() + " izlazi na pistu i poleće");
                       sleep(2000);
                       
                       dozvola=false;

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }while (dozvola);
           }



      }


      private void trazimDozvolu(){
          synchronized (dozvola){
              Poruka.text("Trazaim dozvolu?");
                  try {
                      sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                      dozvola=true;
              Poruka.text("Uzletanje odobreno!");
                  }



      }


      
    private void proveraOpreme(){
        Poruka.linija40();
        Poruka.text("Pocinjem proveru za  avion " + this.avion.getOznaka());

        try {

           sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Poruka.text("Avion " + this.avion.getOznaka() +" je spreman za poletanje i čeka dozvolu za poletanje");
        Poruka.linija40();

    }






    @Override
    public void run(){
             poletanje();
    }



    //Testiranje
    public static void main(String[] args){

        myDB db=new myDB();
        Avion avion1=null;
        Avion avion2=null;

        Dao<Avion,Integer> DAOAvion= null;
        try {
            DAOAvion = DaoManager.createDao(db.getKonekcija(), Avion.class);
            List<Avion> avioni=DAOAvion.queryForAll();

             avion1=avioni.get(0);
             avion2=avioni.get(1);
            

            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.zatvoriKonekciju();
        }


            AvionNit avi1=new AvionNit(avion1);
            AvionNit avi2=new AvionNit(avion2);


            avi1.start();
            avi2.start();


        try {
            avi1.join();
            avi2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }

}
