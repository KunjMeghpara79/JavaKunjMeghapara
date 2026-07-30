import java.io.IOException;

public class LibraryDataException extends IOException {

    public LibraryDataException(String message) {
        super(message);
    }

    public LibraryDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
