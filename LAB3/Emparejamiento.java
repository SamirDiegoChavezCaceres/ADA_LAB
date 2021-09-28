package LAB3;

/**
 * Samir Diego Chavez Caceres
 */

//Ejercicio 
public class Emparejamiento {
    public static class Persona {
        
        private int[]preferencias;
        private String nombre;
        private int id;
        
        private static int numParejas = 0;
        private Persona pareja = null;
        
        public Persona(String nombr, int[] pref, int id){
            
            this.preferencias = pref;
            this.nombre = nombr;
            this.id = id;
        }
        
        //empareja dos personas
        public static void emparejar(Persona a, Persona b){
            Persona.numParejas++;
            a.pareja = b;
            b.pareja = a;
        }
        
        //busca si el pretendiente es mejor a su actual pareja y la cambia
        public boolean esMejor(Persona pretendiente){
            for(int i = 0; i < preferencias.length ; i++){
                if(preferencias[i] == pareja.id)
                    return false;
                else if (preferencias[i] == pretendiente.id)
                    return true;
            }
            return false;
        }
        
        //cambia de pareja
        public Persona cambiarPor(Persona pretendiente){
            Persona ex = this.pareja;
            this.pareja.pareja = null;
            Persona.numParejas--;
            Persona.emparejar(this, pretendiente);
            return ex;
        }
        
        //despues de ser rechazado la persona busca a la siguiente en su lista
        public int buscarSigVict(Persona ex){
            for(int i = 0; i < preferencias.length ; i++)
                if(preferencias[i] == ex.id)
                    return ++i;
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        String[] VarNombres = {"Andy","Beto","Carlo","Denis"};
        String[] MujNombres = {"Wendy","Xena","Yvonne","Zoe"};
        int a = VarNombres.length;
        int b = MujNombres.length;
        
        Persona[] hombres = new Persona[a];
        Persona[] mujeres = new Persona[b];
        
        hombres[0] = new Persona(VarNombres[0], new int[]{1,0,2,3}, 0);
        hombres[1] = new Persona(VarNombres[1], new int[]{2,3,1,0}, 1);
        hombres[2] = new Persona(VarNombres[2], new int[]{2,1,3,0}, 2);
        hombres[3] = new Persona(VarNombres[3], new int[]{0,3,2,1}, 3);
        
        mujeres[0] = new Persona(MujNombres[0], new int[]{2,3,1,0}, 0);
        mujeres[1] = new Persona(MujNombres[1], new int[]{2,1,0,3}, 1);
        mujeres[2] = new Persona(MujNombres[2], new int[]{0,1,2,3}, 2);
        mujeres[3] = new Persona(MujNombres[3], new int[]{3,2,1,0}, 3);
        
        for(int i = 0; i < MujNombres.length ; i++){
            for(int j = 0; j < VarNombres.length ; j++){
                System.out.print(MujNombres[hombres[i].preferencias[j]]+" ");
            }
            System.out.println();
        }
        for(int i = 0; i < VarNombres.length ; i++){
            for(int j = 0; j < MujNombres.length ; j++){
                System.out.print(VarNombres[mujeres[i].preferencias[j]]+" ");
            }
            System.out.println();
        }
        
        
        double inicio = System.currentTimeMillis();
        emparejar(hombres, mujeres); 
        double fin = System.currentTimeMillis();
        System.out.println(fin+" - " +inicio+" = "+(fin-inicio));
        
        for(int i = 0; i < VarNombres.length ; i++){
            System.out.println(hombres[i].nombre+" "+hombres[i].pareja.nombre);
        }
    }
    
    //empareja dos listas
    public static void emparejar(Persona[] a, Persona[] b){
        int j = 0;
        while(Persona.numParejas != a.length) {
            Persona cazador = a[buscarPrimerSoltero(a)]; //Persona que busca pareja
            Persona presa = b[cazador.preferencias[j]]; //la persona solicitada a formar pareja
            if(presa.pareja == null){
                Persona.emparejar(cazador, presa);
                j = 0;
            } else if (presa.esMejor(cazador)){
                Persona ex = presa.cambiarPor(cazador);
                j = ex.buscarSigVict(presa);
            } else {
                j++;
            }
        }
    }
    
    //coge al primer soltero
    public static int buscarPrimerSoltero(Persona[]a){
        //for(int i = 0 ; i < varones.length ; i++)
        for(int i = a.length - 1 ; i > 0 ; i--)
            if(a[i].pareja == null)
                return i;
        return 0;
    }
}

