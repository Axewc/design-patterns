package patternsjava.proxy;

/**
 * La clase RealImage representa una imagen real que se carga desde el disco.
 * Implementa la interfaz Image.
 */
public class RealImage implements Image {

    /**
     * El nombre del archivo de la imagen.
     */
    private String fileName;

    /**
     * Constructor que crea una instancia de RealImage y carga la imagen desde el disco.
     *
     * @param fileName El nombre del archivo de la imagen.
     */
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    /**
     * Muestra la imagen en la consola.
     */
    @Override
    public void display() {
        System.out.println("Mostrando " + fileName);
    }

    /**
     * Carga la imagen desde el disco.
     *
     * @param fileName El nombre del archivo de la imagen.
     */
    private void loadFromDisk(String fileName) {
        System.out.println("Cargando " + fileName);
    }
}