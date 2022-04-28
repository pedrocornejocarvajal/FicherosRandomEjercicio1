import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomEjercicio1 {

    static File file = null;
    static RandomAccessFile randomAccessFile = null;
    public static void run() {
        int entero1 = 1;
        int entero2 = 2;
        int entero3 = 3;
        int entero4 = 4;
        long long1 = 1;
        long long2 = 2;
        long long3 = 3;
        long long4 = 4;

        try {
            file = new File("Ejercicio1.bin");
            randomAccessFile = new RandomAccessFile(file, "rw");

            //escribimos los datos dentro del fichero
            randomAccessFile.write(entero1);
            randomAccessFile.write(entero2);
            randomAccessFile.write(entero3);
            randomAccessFile.write(entero4);
            randomAccessFile.writeLong(long1);
            randomAccessFile.writeLong(long2);
            randomAccessFile.writeLong(long3);
            randomAccessFile.writeLong(long4);
            //Leemos la longitud teniendo en cuenta que un entero ocupa 2 byte y un long ocupa 8 bytes
            System.out.println("La longitud del fichero es: " + randomAccessFile.length() + "\n");

            //comprobamos la posicion del puntero y leemos el primer elemento del fichero
            comprobarPosicion();
            System.out.println("");

            //Nos posicionamos en la posición 1, comprobamos la posición y leemos el dato
            cambiarPosicion(1);
            comprobarPosicion();
            leerDato();

            //cambiamos la posición al principio comprobamos la posición y leemos
            cambiarPosicion(0);
            comprobarPosicion();
            leerDato();

            //cambiamos a la posición 4 y leemos
            cambiarPosicion(4);
            comprobarPosicion();
            leerDatoLong();

            //ponemos a prueba de balas los errores que puedan ocasionar los ficheros
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error, no se ha encontrado el fichero seleccionado");
        } catch (IOException ioException) {
            System.out.println("Error en la entrada o salida del fichero");
        } catch (Exception Exception) {
            System.out.println("Error 404");
        } finally {
            cerrarFlujo(); //cerramos el flujo del fichero
        }
    }

    /**
     * Método para leer un dato de tipo int en el fichero
     * @throws IOException
     */
    private static void leerDato() throws IOException {
        System.out.println("El resultado es: " + randomAccessFile.read() + "\n");
    }

    /**
     * Método para leer un tipo de tipo long en el fichero
     * @throws IOException
     */
    private static void leerDatoLong() throws IOException {
        System.out.println("El resultado es: " + randomAccessFile.readLong() + "\n");
    }

    /**
     * Método para comprobar la posicion en el fichero
     * @throws IOException
     */
    private static void comprobarPosicion() throws IOException {
        System.out.println("Estamos en la posición " + randomAccessFile.getFilePointer());
    }

    /**
     * Método para cambiar la posición en el fichero
     * @param posicion
     * @throws IOException
     */
    private static void cambiarPosicion(int posicion) throws IOException {
        randomAccessFile.seek(posicion);
    }

    /**
     * Método para cerrar los flujos del fichero
     */
    private static void cerrarFlujo(){
        try {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception exception) {
            System.out.println("error en el cierre del fichero");
        }
    }
}
