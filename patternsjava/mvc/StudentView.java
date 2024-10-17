package patternsjava.mvc;

/**
 * La clase StudentView es responsable de mostrar los detalles del estudiante en la consola.
 */
public class StudentView {
    /**
     * Imprime los detalles del estudiante en la consola.
     *
     * @param studentName El nombre del estudiante.
     * @param studentRollNo El número de matrícula del estudiante.
     */
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}