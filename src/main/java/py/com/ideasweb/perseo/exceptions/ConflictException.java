package py.com.ideasweb.perseo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rodrigovillalba on 2/16/18.
 * <p>
 * Simple exception with a message, that returns an Internal Server Error code.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    public ConflictException(String msg) {
        super(msg);
    }

    public ConflictException(Throwable e) {
        super(e);
    }

}
