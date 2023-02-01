package test;

import test.task.model.EmployeeModel;
import test.task.model.RequestModel;

import java.util.Random;

public class Generator {

    private static final Random RAND = new Random();

    private static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int VALID_MIN_LENGTH_STRING = 1;
    private static final int VALID_MAX_LENGTH_STRING = 4986;


    public static int randomInt(int max, int min) {
        return RAND.nextInt(max + 1 - min) + min;
    }

    public static String randomString(int max, int min) {
        int length = randomInt(max, min);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (alpha.length() * Math.random());
            sb.append(alpha.charAt(index));
        }
        return sb.toString();
    }


    public static boolean randomBoolean() {
        return RAND.nextBoolean();
    }

    public static EmployeeModel generateEmptyEmployeeModel() {
        return new EmployeeModel();
    }

    public static EmployeeModel generateEmployeeModel() {
        EmployeeModel employeeModel = new EmployeeModel();
        //todo
        return employeeModel;
    }


    public static RequestModel generateEmptyRequestModel() {
        return new RequestModel();
    }

    public static RequestModel generateValidRequestModel() {
        RequestModel requestModel = new RequestModel();
        requestModel.setPolicyNumber("policyNumber_" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setName("name" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setSurname("surname" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setDescription("description" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setKindOfRequest("kindOfRequest" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        return requestModel;
    }

    public static RequestModel generateNotValidRequestModel() {
        RequestModel requestModel = new RequestModel();
        requestModel.setPolicyNumber("policyNumber" + randomInt(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setName("name" + randomString(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setSurname("surname" + randomString(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setDescription("description" + randomString(VALID_MAX_LENGTH_STRING, VALID_MIN_LENGTH_STRING));
        requestModel.setKindOfRequest("kindOfRequest" + randomString(VALID_MIN_LENGTH_STRING + 1, VALID_MIN_LENGTH_STRING + 2));
        return requestModel;
    }

}