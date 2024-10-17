package patternsjava.proxy;

/**
 * La clase ProxyImage actúa como un proxy para RealImage.
 * Implementa la interfaz Image.
 */
public class ProxyImage implements Image {

    /**
     * La instancia de RealImage que se carga bajo demanda.
     */
    private RealImage realImage;

    /**
     * El nombre del archivo de la imagen.
     */
    private String fileName;

    /**
     * Constructor que crea una instancia de ProxyImage.
     *
     * @param fileName El nombre del archivo de la imagen.
     */
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Muestra la imagen. Si la imagen real no ha sido cargada, la carga desde el disco.
     */
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}