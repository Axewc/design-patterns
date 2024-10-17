# Proxy Pattern

En el patrón de proxy, una clase representa la funcionalidad de otra clase. Este tipo de patrón de diseño viene bajo patrón estructural.

En el patrón de proxy, creamos un objeto que tiene un objeto original para interconectar su funcionalidad con el mundo exterior.

## Implementación

Vamos a crear una interfaz de imagen y clases concretas implementando la interfaz de imagen. ProxyImage es una clase de proxy para reducir la huella de memoria de la carga de objetos RealImage.

ProxyPatternDemo, nuestra clase de demostración, utilizará ProxyImage para que un objeto Image se cargue y muestre según sea necesario.

![UML Diagram](proxy_pattern_uml_diagram.jpg)

## Paso 1

Crea una interfaz.

> Image.java

```java
public interface Image {
   void display();
}
```

## Paso 2

Crea clases concretas implementando la misma interfaz.

> RealImage.java

```java
public class RealImage implements Image {

   private String fileName;

   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }

   @Override
   public void display() {
      System.out.println("Displaying " + fileName);
   }

   private void loadFromDisk(String fileName){
      System.out.println("Loading " + fileName);
   }
}
```

> ProxyImage.java

```java
public class ProxyImage implements Image{

   private RealImage realImage;
   private String fileName;

   public ProxyImage(String fileName){
      this.fileName = fileName;
   }

   @Override
   public void display() {
      if(realImage == null){
         realImage = new RealImage(fileName);
      }
      realImage.display();
   }
}
```

## Paso 3

Utilice ProxyImage para obtener el objeto de la clase RealImage cuando sea necesario.

> ProxyPatternDemo.java

```java
public class ProxyPatternDemo {

   public static void main(String[] args) {
      Image image = new ProxyImage("test_10mb.jpg");

      //image will be loaded from disk
      image.display();
      System.out.println("");

      //image will not be loaded from disk
      image.display();
   }
}
```

## Paso 4

Verifique la salida.

```note
Loading test_10mb.jpg
Displaying test_10mb.jpg

Displaying test_10mb.jpg
```

---

El patrón Proxy es un patrón de diseño estructural que proporciona un sustituto o punto de acceso a otro objeto para controlar el acceso a él. Este patrón se utiliza para crear un objeto que representa otro objeto. El objeto proxy actúa como un intermediario entre el cliente y el objeto real, permitiendo realizar ciertas operaciones antes o después de acceder al objeto real.

### Funcionamiento del Patrón Proxy

El patrón Proxy se compone de los siguientes componentes:

1. **Interfaz Común**: Define los métodos que tanto el objeto real como el proxy deben implementar.
2. **Objeto Real**: La clase que define el objeto real que el proxy representa.
3. **Proxy**: La clase que implementa la misma interfaz que el objeto real y controla el acceso a él.

### Ejemplo de Implementación

El patrón Proxy se utiliza para controlar el acceso a una imagen. Aquí tienes una explicación detallada de cómo se implementa:

1. **Interfaz Común ([`Image`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A13%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition"))**: Define el método [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") que tanto el objeto real como el proxy deben implementar.

    ```java
    public interface Image {
        void display();
    }
    ```

2. **Objeto Real (`RealImage`)**: La clase que representa la imagen real y que realiza la carga y visualización de la imagen.

    ```java
    public class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk(fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }

        private void loadFromDisk(String fileName) {
            System.out.println("Loading " + fileName);
        }
    }
    ```

3. **Proxy ([`ProxyImage`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A13%2C%22character%22%3A26%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition"))**: La clase que controla el acceso a la imagen real. Solo carga la imagen real cuando es necesario.

    ```java
    public class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }
    ```

4. **Clase Principal ([`ProxyPatternDemo`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A5%2C%22character%22%3A13%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition"))**: Demuestra el uso del patrón Proxy.

    ```java
    public class ProxyPatternDemo {
        public static void main(String[] args) {
            Image image = new ProxyImage("test_image.jpg");

            // Muestra la imagen
            image.display();
            System.out.println("testeo");

            // Muestra la imagen nuevamente
            image.display();
        }
    }
    ```

### Explicación del Flujo

1. **Creación del Proxy**: En la clase principal [`ProxyPatternDemo`](command:_github.copilot.openSymbolInFile?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatterns_java%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22ProxyPatternDemo%22%2C%221fd72ebe-4592-4c5a-a622-cb3d8efdcddc%22%5D "/home/axew/Documentos/design-patterns/patterns_java/proxy/ProxyPatternDemo.java"), se crea una instancia de [`ProxyImage`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A13%2C%22character%22%3A26%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") con el nombre del archivo de la imagen.

2. **Primera Llamada a [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition")**: Cuando se llama al método [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") en el proxy, este verifica si la imagen real ya ha sido cargada. Si no es así, crea una instancia de `RealImage` y carga la imagen desde el disco. Luego, llama al método [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") de `RealImage`.

3. **Segunda Llamada a [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition")**: La segunda vez que se llama al método [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition"), el proxy ya tiene la imagen real cargada, por lo que simplemente llama al método [`display`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fproxy%2FProxyPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A16%2C%22character%22%3A14%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") de `RealImage` sin volver a cargar la imagen.

Este enfoque permite diferir la carga de la imagen hasta que realmente se necesite, mejorando así el rendimiento y reduciendo el uso de recursos.
