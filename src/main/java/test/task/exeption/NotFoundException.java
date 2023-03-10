package test.task.exeption;

public class NotFoundException extends DemoTestException {

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException create(String resourceName, Object identifier) {
        return new NotFoundException(resourceName + " identified by " + identifier + " not found.");
    }

}
