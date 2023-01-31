package test.task.exeption;

public class BadRequestException extends DemoTestException {

    public BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException create(String resourceName) {
        return new BadRequestException(resourceName + " bad request.");
    }

}
