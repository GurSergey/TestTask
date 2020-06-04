package TestTask.exception;

public class RestException extends Exception {
    private String text = "";
    public String getText(){
        return this.text;
    }
}
