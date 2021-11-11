package be.vdab.eindoefeningmovies.exceptions;

public class GeenKlantenGevondenException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public GeenKlantenGevondenException(String message) {
        super(message);
    }
}
