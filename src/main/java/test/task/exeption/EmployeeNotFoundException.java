package test.task.exeption;

public class EmployeeNotFoundException extends DemoTestException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public static EmployeeNotFoundException create(String resourceName, Object identifier) {
        return new EmployeeNotFoundException(resourceName + " identified by " + identifier + " not found.");
    }

}
