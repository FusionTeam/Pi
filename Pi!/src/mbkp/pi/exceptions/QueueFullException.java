package mbkp.pi.exceptions;
 
/**
 * @author Max
 */

public class QueueFullException extends RuntimeException {
 
    /**
	 * Exception if queue is full
	 */
	private static final long serialVersionUID = 1L;

	public QueueFullException(){
        super();
    }
     
    public QueueFullException(String message){
        super(message);
    }
     
    public QueueFullException(String message, Throwable cause){
        super(message, cause);
    }
}