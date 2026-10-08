package hiber.Exceptions;

public class UserByCarNotFoundException extends RuntimeException {

    public UserByCarNotFoundException(String message) {
        super(message);
    }
}

