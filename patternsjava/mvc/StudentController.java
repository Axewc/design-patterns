package patternsjava.mvc;

/**
 * La clase StudentController actúa como intermediario entre el modelo Student y la vista StudentView.
 */
public class StudentController {
    private Student model;
    private StudentView view;

    /**
     * Constructor que crea una instancia de StudentController.
     *
     * @param model El modelo Student.
     * @param view La vista StudentView.
     */
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Establece el nombre del estudiante en el modelo.
     *
     * @param name El nombre del estudiante.
     */
    public void setStudentName(String name) {
        model.setName(name);
    }

    /**
     * Obtiene el nombre del estudiante del modelo.
     *
     * @return El nombre del estudiante.
     */
    public String getStudentName() {
        return model.getName();
    }

    /**
     * Establece el número de matrícula del estudiante en el modelo.
     *
     * @param rollNo El número de matrícula del estudiante.
     */
    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    /**
     * Obtiene el número de matrícula del estudiante del modelo.
     *
     * @return El número de matrícula del estudiante.
     */
    public String getStudentRollNo() {
        return model.getRollNo();
    }

    /**
     * Actualiza la vista para mostrar los detalles del estudiante.
     */
    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}