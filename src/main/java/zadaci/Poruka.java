package zadaci;

/**
 * Created by borcha on 22.04.17..
 */
public class Poruka {

        public synchronized   static void text(String _sadrzajPoruke){
            System.out.println(_sadrzajPoruke);
        }


        public synchronized static void linija40(){
            System.out.println("----------------------------------------");
        }


        public synchronized static void noviRed(){
            System.out.println();
        }


    /**
     * Nov red + isprekidana linija + nov red
     */
    public static void nrlinr(){
            System.out.println("\n----------------------------------------\n");
        }
}
