package patternsjava.mvc;

/**
 * La clase MVCPatternDemo demuestra el uso del patrón de diseño MVC.
 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        // Obtiene el registro del estudiante basado en su número de matrícula de la base de datos
        Student model = retriveStudentFromDatabase();

        // Crea una vista: para escribir los detalles del estudiante en la consola
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // Actualiza los datos del modelo
        controller.setStudentName("John");

        controller.updateView();
    }

    /**
     * Simula la recuperación de un estudiante de la base de datos.
     *
     * @return Un objeto Student con datos simulados.
     */
    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}