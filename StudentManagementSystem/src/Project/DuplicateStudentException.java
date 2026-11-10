package Project;

public class DuplicateStudentException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateStudentException(String message) {
        super(message);
    }
}
