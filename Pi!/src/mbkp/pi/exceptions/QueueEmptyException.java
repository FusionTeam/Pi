package mbkp.pi.exceptions;
 
public class QueueEmptyException extends RuntimeException {
 
    /**
	 * Exception if queue is full
	 */
	private static final long serialVersionUID = 1L;

	public QueueEmptyException(){
        super();
    }
     
    public QueueEmptyException(String message){
        super(message);
    }
     
    public QueueEmptyException(String message, Throwable cause){
        super(message, cause);
    }
}