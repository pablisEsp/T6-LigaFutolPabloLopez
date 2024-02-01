import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    public static Scanner leerFrase = new Scanner(System.in);
    public static Scanner teclado = new Scanner(System.in);

    public static ArrayList<Object> listaPer = new ArrayList<>();
    public static void main(String[] args) {
        int respuesta;
        do {
            menu();
            respuesta = leerInt("-------->");

            switch (respuesta){
                case 1: //insertar jugador
                    insertarJugador();
                    break;
                case 2: //insertar arbitro
                    insertarArbitro();
                    break;

                case 3: //mostrar array
                    if (!listaPer.isEmpty()){
                        mostrarTodo();
                    }else{
                        System.out.println("No se puede mostrar ninguna persona, crea una antes.");
                    }
                    break;

                case 4: //ordenar por velocidad
                    if (listaPer.size() > 1){
                        //ordenarPorVelo();
                        ordenarPorVeloRecursivo(0, 1); // 0 = i, 0 = j
                    }else{
                        System.out.println("Crea al menos 2 personas para ordenarlas.");
                    }

                    break;

                case 5: //mostrar jugadores
                    if (!listaPer.isEmpty()){
                        mostrarJugadores();
                    }else{
                        System.out.println("No se puede mostrar ningun jugador, crea uno antes.");
                    }
                    break;

                case 6: //buscar persona por nombre
                    if (listaPer.size() > 1){
                        System.out.println("Dime el nombre de la persona que quieras buscar");
                        String nombre = leerFrase.next();
                        int posNom = buscarPersonaRecursivo(nombre, 0);
                        if (posNom == -1){
                            System.out.println("No se ha encontrado ninguna persona");
                        }else{
                            System.out.println(listaPer.get(posNom).toString());
                        }
                    }else if (!listaPer.isEmpty()) {
                        System.out.println("Solo existe una persona, crea más para poder realizar una búsqueda.");
                    }else{
                        System.out.println("Crea personas para poder realizar una búsqueda.");
                    }
                    break;

                case 7: //jugador con más regate
                    int regate = 0;
                    if (!listaPer.isEmpty()){
                        if (jugadorMasRegateRecursivo(regate, -1, 0, 1) == -1){
                            System.out.println("No existe ningún jugador");
                        }else{
                            System.out.println(listaPer.get(jugadorMasRegateRecursivo(regate, -1, 0, 1)).toString());
                        }

                    }else{
                        System.out.println("No existe ningún jugador.");
                    }
                    break;

                case 8: //sumar todas las velocidades
                    int sumaTotal = 0;
                    if (!listaPer.isEmpty()){
                        System.out.println("La suma total de las velocidades es: " + sumaVelocidadesRecursivo(sumaTotal, 0));
                    }else{
                        System.out.println("No existe ninguna persona. Crea antes una para poder sumar.");
                    }
                    break;

                case 9:
                    System.out.println("FIN PROGRAMA");
                    break;

                default:
                    System.out.println("Introduce un número correcto.");
                    break;
            }
        }while (respuesta != 9);
    }

    public static void menu(){
        System.out.println("1) Insertar jugador");
        System.out.println("2) Insertar arbitro");
        System.out.println("3) Mostrar todo el array");
        System.out.println("4) Ordenar personas por velocidad");
        System.out.println("5) Mostrar solo jugadores");
        System.out.println("6) Buscar jugador y aribitro por nombre");
        System.out.println("7) Jugador con más regate");
        System.out.println("8) Suma todas las velocidades");
        System.out.println("9) Salir");

    }

    public static void insertarJugador(){
        Jugador j = new Jugador();

        System.out.println("Dime el nombre del jugador:");
        j.setNombre(leerFrase.next());

        System.out.println("Dime en qué posición juega el jugador:");
        j.setPosicion(teclado.next());

        j.setVelocidad(1);
        j.setRegate(1);

        boolean respuesta = false;
        boolean check = false;
        do {
            System.out.println("¿Está lesionado? (true or false)");
            try{
                respuesta = teclado.nextBoolean();
                check = true;
            }catch (Exception e){
                System.err.println("Introduce true o false");
                teclado.nextLine();
            }
        }while(!check);


        j.setLesionado(respuesta);
        listaPer.add(j);
    }

    public static void insertarArbitro(){
        Arbitro a = new Arbitro();

        System.out.println("Dime el nombre del arbitro:");
        a.setNombre(leerFrase.next());

        System.out.println("Dime que tipo de colegiado es:");
        a.setColegio(teclado.next());

        a.setVelocidad(1);
        a.setAcierto(1);

        boolean respuesta = false;
        boolean check = false;
        do {
            System.out.println("¿Está activo? (true or false)");
            try{
                respuesta = teclado.nextBoolean();
                check = true;
            }catch (Exception e){
                System.err.println("Introduce true o false");
                teclado.nextLine();
            }
        }while(!check);
        a.setActivo(respuesta);
        listaPer.add(a);
    }

    public static void mostrarTodo(){
        for (Object i : listaPer){
            System.out.println(i.toString());
        }
    }

    public static void mostrarJugadores(){
        boolean cont = false;
        for (Object i : listaPer){
            if (i instanceof Jugador){
                System.out.println(i);
                cont = true;
            }
        }
        if (!cont){
            System.out.println("No existe ningún jugador que mostrar.");
        }
    }

    public static void ordenarPorVelo(){
        int veli, velj;
        Object aux;
        for (int i = 0; i < listaPer.size() - 1; i++){
            for (int j = 1 + i; j < listaPer.size(); j++) {
                if (listaPer.get(j) instanceof Jugador){
                    velj = ((Jugador) listaPer.get(j)).getVelocidad();

                }else{
                    velj = ((Arbitro) listaPer.get(j)).getVelocidad();
                }
                if (listaPer.get(i) instanceof Jugador){
                    veli = ((Jugador) listaPer.get(i)).getVelocidad();

                }else{
                    veli = ((Arbitro) listaPer.get(i)).getVelocidad();
                }

                if (veli > velj){
                    aux = listaPer.get(i);
                    listaPer.set(i, listaPer.get(j));
                    listaPer.set(j, aux);
                }
            }
        }
    }

    public static void ordenarPorVeloRecursivo(int i, int j){
        int veli, velj;
        Object aux;
        if (i == listaPer.size() - 1){ //caso base

        }else{ //caso recursivo
            if (listaPer.get(j) instanceof Jugador){
                velj = ((Jugador) listaPer.get(j)).getVelocidad();

            }else{
                velj = ((Arbitro) listaPer.get(j)).getVelocidad();
            }
            if (listaPer.get(i) instanceof Jugador){
                veli = ((Jugador) listaPer.get(i)).getVelocidad();

            }else{
                veli = ((Arbitro) listaPer.get(i)).getVelocidad();
            }

            if (veli > velj){
                aux = listaPer.get(i);
                listaPer.set(i, listaPer.get(j));
                listaPer.set(j, aux);
            }
            if (j == listaPer.size()-1){
                ordenarPorVeloRecursivo(i+1, i+2);

            }else{
                ordenarPorVeloRecursivo(i, j+1);
            }
        }
    }

    public static int buscarPersona(String nombre){
        String posNombre = "";
        for (int i = 0; i < listaPer.size(); i++)
        {
            if (listaPer.get(i) instanceof Jugador){
                posNombre = ((Jugador) listaPer.get(i)).getNombre();
            }
            if (listaPer.get(i) instanceof Arbitro){
                posNombre = ((Arbitro) listaPer.get(i)).getNombre();
            }
            if (nombre.equalsIgnoreCase(posNombre)){
                return i;
            }
        }
        return -1;
    }

    public static int buscarPersonaRecursivo(String nombre, int i){
        String posNombre = "";
        if (i == listaPer.size()){
            return -1;
        }
        if (listaPer.get(i) instanceof Jugador){
            posNombre = ((Jugador) listaPer.get(i)).getNombre();
        }
        if (listaPer.get(i) instanceof Arbitro){
            posNombre = ((Arbitro) listaPer.get(i)).getNombre();
        }
        if (nombre.equalsIgnoreCase(posNombre)){
            return i;
        }

        return buscarPersonaRecursivo(nombre, i + 1);
    }

    public static int jugadorMasRegate(){
        int regate, posi = 0;
        boolean cont = false;
        for (int i = 0; i < listaPer.size()-1; i++){
            if (listaPer.get(i) instanceof Jugador){
                regate = ((Jugador) listaPer.get(i)).getRegate();
                for (int j = 1; j < listaPer.size(); j++) {
                    if (listaPer.get(j) instanceof Jugador){
                        if (((Jugador) listaPer.get(j)).getRegate() > regate){
                            regate = ((Jugador) listaPer.get(j)).getRegate();
                            posi = j;
                            cont = true;
                        }
                    }
                }
            }
        }
        if (!cont){
            return -1;
        }
        return posi;
    }

    //jugadorMasRegateRecursivo(regate, 0, 0, 1);
    public static int jugadorMasRegateRecursivo(int regate, int posi, int i, int j){
         //posi = -1 al principio ya que en el case tengo un if -1 y así noo lo tengo que cambiar :)
        if (i == listaPer.size()-1){ //caso base
            return posi;
        }else{ //caso recursivo
            if (listaPer.get(i) instanceof Jugador){
                regate = ((Jugador) listaPer.get(i)).getRegate();
            }
            if (listaPer.get(j) instanceof Jugador) {
                if (((Jugador) listaPer.get(j)).getRegate() > regate) {
                    regate = ((Jugador) listaPer.get(j)).getRegate();
                    posi = j;
                }
            }
        }
        return jugadorMasRegateRecursivo(regate, posi,i+1, i+2);
    }

    public static int sumaVelocidadesRecursivo(int sumaVelocidad, int i){
        if (i == listaPer.size()){
            return sumaVelocidad;
        }else{
            if (listaPer.get(i) instanceof Jugador){
                sumaVelocidad += ((Jugador) listaPer.get(i)).getVelocidad();
            }
            if (listaPer.get(i) instanceof Arbitro){
                sumaVelocidad += ((Arbitro) listaPer.get(i)).getVelocidad();
            }
        }
        return sumaVelocidadesRecursivo(sumaVelocidad, i + 1);
    }

    public static int leerInt(String frase){
        boolean verdadero = false;
        int numReal = 0;
        do{
            try{
                System.out.println(frase);
                String num = teclado.next();
                numReal = Integer.parseInt(num);
                verdadero = true;

            }catch (Exception e){
                System.err.println("Introduce un número valido.");
            }
        }while(!verdadero);
        return numReal;
    }
}