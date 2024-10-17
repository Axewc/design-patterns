# MVC Pattern

MVC Pattern son las siglas de Model-View-Controller Pattern. Este patrón se usa para separar las preocupaciones de la aplicación.

- *Model* - El modelo representa un objeto o JAVA POJO que lleva datos. También puede tener lógica para actualizar el controlador si sus datos cambian.

- *View* - La vista representa la visualización de los datos que contiene el modelo.

- *Controller* - El controlador actúa tanto en el modelo como en la vista. Controla el flujo de datos hacia el objeto del modelo y actualiza la vista cada vez que cambian los datos. Mantiene la vista y el modelo separados.

## Implementación

Vamos a crear un objeto Student que actúa como modelo. StudentView será una clase de vista que puede imprimir los detalles del alumno en la consola y StudentController es la clase controladora responsable de almacenar datos en el objeto Student y actualizar la vista StudentView en consecuencia.

MVCPatternDemo, nuestra clase de demostración, utilizará StudentController para demostrar el uso del patrón MVC.

![UML Diagram](mvc_pattern_uml_diagram.jpg)

## Paso 1

Crear Modelo.

> Student.java

```java
public class Student {
   private String rollNo;
   private String name;

   public String getRollNo() {
      return rollNo;
   }

   public void setRollNo(String rollNo) {
      this.rollNo = rollNo;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
```

## Paso 2

Crear vista.

> StudentView.java

```java
public class StudentView {
   public void printStudentDetails(String studentName, String studentRollNo){
      System.out.println("Student: ");
      System.out.println("Name: " + studentName);
      System.out.println("Roll No: " + studentRollNo);
   }
}
```

## Paso 3

Crear Controlador.

> StudentController.java

```java
public class StudentController {
   private Student model;
   private StudentView view;

   public StudentController(Student model, StudentView view){
      this.model = model;
      this.view = view;
   }

   public void setStudentName(String name){
      model.setName(name);
   }

   public String getStudentName(){
      return model.getName();
   }

   public void setStudentRollNo(String rollNo){
      model.setRollNo(rollNo);
   }

   public String getStudentRollNo(){
      return model.getRollNo();
   }

   public void updateView(){
      view.printStudentDetails(model.getName(), model.getRollNo());
   }
}
```

## Paso 4

Utilice los métodos StudentController para demostrar el uso del patrón de diseño MVC.

> MVCPatternDemo.java

```java
public class MVCPatternDemo {
   public static void main(String[] args) {

      //fetch student record based on his roll no from the database
      Student model  = retriveStudentFromDatabase();

      //Create a view : to write student details on console
      StudentView view = new StudentView();

      StudentController controller = new StudentController(model, view);

      controller.updateView();

      //update model data
      controller.setStudentName("John");

      controller.updateView();
   }

   private static Student retriveStudentFromDatabase(){
      Student student = new Student();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }
}
```

## Paso 5

Verifique la salida.

```note
Student:
Name: Robert
Roll No: 10
Student:
Name: John
Roll No: 10
```

---


El patrón MVC (Modelo-Vista-Controlador) es un patrón de diseño arquitectónico que separa una aplicación en tres componentes principales: el Modelo, la Vista y el Controlador. Este patrón se utiliza para organizar el código de manera que separe la lógica de negocio, la interfaz de usuario y el control de flujo, facilitando así el mantenimiento y la escalabilidad de la aplicación.

### Componentes del Patrón MVC

1. **Modelo (Model)**: Representa los datos de la aplicación y la lógica de negocio. El modelo no tiene conocimiento de la vista ni del controlador.
2. **Vista (View)**: Representa la interfaz de usuario. La vista muestra los datos del modelo y envía las acciones del usuario al controlador.
3. **Controlador (Controller)**: Actúa como intermediario entre el modelo y la vista. El controlador recibe las entradas del usuario, las procesa (posiblemente actualizando el modelo) y actualiza la vista.

### Ejemplo en el código

En tu proyecto, el patrón MVC se utiliza para gestionar los datos de un estudiante y mostrarlos en la consola. Aquí tienes una explicación detallada de cómo se implementa:

1. **Modelo ([`Student`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FMVCPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A6%2C%22character%22%3A8%7D%7D%5D%2C%22908f20de-80ea-4113-a414-3e0d4fbe4be9%22%5D "Go to definition"))**: La clase que representa los datos del estudiante.

    ```java
    package patternsjava.mvc;

    public class Student {
        private String rollNo;
        private String name;

        public String getRollNo() {
            return rollNo;
        }

        public void setRollNo(String rollNo) {
            this.rollNo = rollNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    ```

2. **Vista ([`StudentView`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FMVCPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A9%2C%22character%22%3A8%7D%7D%5D%2C%22908f20de-80ea-4113-a414-3e0d4fbe4be9%22%5D "Go to definition"))**: La clase que representa la interfaz de usuario para mostrar los datos del estudiante.

    ```java
    package patternsjava.mvc;

    public class StudentView {
        public void printStudentDetails(String studentName, String studentRollNo) {
            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("Roll No: " + studentRollNo);
        }
    }
    ```

3. **Controlador ([`StudentController`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FMVCPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A11%2C%22character%22%3A8%7D%7D%5D%2C%22908f20de-80ea-4113-a414-3e0d4fbe4be9%22%5D "Go to definition"))**: La clase que actúa como intermediario entre el modelo y la vista.

    ```java
    package patternsjava.mvc;

    public class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentRollNo(String rollNo) {
            model.setRollNo(rollNo);
        }

        public String getStudentRollNo() {
            return model.getRollNo();
        }

        public void updateView() {
            view.printStudentDetails(model.getName(), model.getRollNo());
        }
    }
    ```

4. **Clase Principal ([`MVCPatternDemo`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FMVCPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22pos%22%3A%7B%22line%22%3A2%2C%22character%22%3A13%7D%7D%5D%2C%22908f20de-80ea-4113-a414-3e0d4fbe4be9%22%5D "Go to definition"))**: La clase que demuestra el uso del patrón MVC.

    ```java
    package patternsjava.mvc;

    public class MVCPatternDemo {
        public static void main(String[] args) {

            // fetch student record based on his roll no from the database
            Student model = retriveStudentFromDatabase();

            // Create a view : to write student details on console
            StudentView view = new StudentView();

            StudentController controller = new StudentController(model, view);

            controller.updateView();

            // update model data
            controller.setStudentName("John");

            controller.updateView();
        }

        private static Student retriveStudentFromDatabase() {
            Student student = new Student();
            student.setName("Robert");
            student.setRollNo("10");
            return student;
        }
    }
    ```

### Explicación del Flujo

1. **Inicialización del Modelo**: En la clase principal [`MVCPatternDemo`](command:_github.copilot.openSymbolInFile?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FMVCPatternDemo.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%2C%22MVCPatternDemo%22%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "/home/axew/Documentos/design-patterns/patternsjava/mvc/MVCPatternDemo.java"), se crea una instancia de [`Student`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%22file%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FStudent.java%22%2C%22pos%22%3A%7B%22line%22%3A0%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") con datos simulados de una base de datos.

2. **Inicialización de la Vista**: Se crea una instancia de [`StudentView`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%22file%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FStudentView.java%22%2C%22pos%22%3A%7B%22line%22%3A0%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") para mostrar los detalles del estudiante.

3. **Inicialización del Controlador**: Se crea una instancia de [`StudentController`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%22file%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FStudentController.java%22%2C%22pos%22%3A%7B%22line%22%3A0%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") con el modelo y la vista.

4. **Actualización de la Vista**: El controlador llama al método [`updateView`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%22file%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FStudentController.java%22%2C%22pos%22%3A%7B%22line%22%3A52%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") para mostrar los detalles del estudiante en la consola.

5. **Actualización del Modelo**: El controlador actualiza el nombre del estudiante en el modelo y luego llama nuevamente al método [`updateView`](command:_github.copilot.openSymbolFromReferences?%5B%22%22%2C%5B%7B%22uri%22%3A%22file%22%2C%22path%22%3A%22%2Fhome%2Faxew%2FDocumentos%2Fdesign-patterns%2Fpatternsjava%2Fmvc%2FStudentController.java%22%2C%22pos%22%3A%7B%22line%22%3A52%2C%22character%22%3A8%7D%7D%5D%2C%22f2d596b8-a502-4a84-a7da-a162c48d35ed%22%5D "Go to definition") para reflejar los cambios en la vista.

Este enfoque permite una clara separación de responsabilidades, facilitando el mantenimiento y la escalabilidad de la aplicación.
