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

            //cambiamos la posicion al principio comprobamos la posición y leemos
            cambiarPosicion(0);
            comprobarPosicion();
            leerDato();

            //cambiamos a la posición 4 y leemos
            cambiarPosicion(4);
            comprobarPosicion();
            leerDatoLong();

            //ponemos a prueba de balas los errores que puedan ocasionar los ficheros
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero");
        } catch (IOException ioException) {
            System.out.println("error general de entrada salida");
        } catch (Exception Exception) {
            System.out.println("otros errores");
        } finally {
            cerrarFlujo(); //cerramos el flujo del fichero
        }
    }

    private static void leerDato() throws IOException {
        System.out.println("El resultado es: " + randomAccessFile.read() + "\n");
    }

    private static void leerDatoLong() throws IOException {
        System.out.println("El resultado es: " + randomAccessFile.readLong() + "\n");
    }

    private static void comprobarPosicion() throws IOException {
        System.out.println("Estamos en la posición " + randomAccessFile.getFilePointer());
    }
    private static void cambiarPosicion(int posicion) throws IOException {
        randomAccessFile.seek(posicion);
    }

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
