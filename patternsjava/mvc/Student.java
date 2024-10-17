package patternsjava.mvc;

/**
 * La clase Student representa un estudiante con un nombre y un número de matrícula.
 */
public class Student {
    private String rollNo;
    private String name;

    /**
     * Obtiene el número de matrícula del estudiante.
     *
     * @return El número de matrícula del estudiante.
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     * Establece el número de matrícula del estudiante.
     *
     * @param rollNo El número de matrícula del estudiante.
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return El nombre del estudiante.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param name El nombre del estudiante.
     */
    public void setName(String name) {
        this.name = name;
    }
}