package TestTask.exception;

public class IdNotFound extends RestException {
    String text = "Error! Not Found id.";
    public String getText(){
        return this.text;
    }
}
