package ie.atu.cicdproject.ffmainapp.errorHandling;

public class NoStationsFoundException extends RuntimeException {
    public NoStationsFoundException(String message) {
        super(message);
    }
}
