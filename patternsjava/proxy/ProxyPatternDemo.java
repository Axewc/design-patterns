package patternsjava.proxy;

/**
 * La clase ProxyPatternDemo demuestra el uso del patrón de diseño Proxy.
 */
public class ProxyPatternDemo {

    /**
     * El método principal que ejecuta el ejemplo del patrón Proxy.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        // Muestra la imagen
        image.display();
        System.out.println("testeo");

        // Muestra la imagen nuevamente
        image.display();
    }
}