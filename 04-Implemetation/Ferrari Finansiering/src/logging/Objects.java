package logging;

public class Objects
{
  private String title;
  private String message;
  private Errors error;
  
  public String getTitle() {
  
    return title;
  }
  
  public String getMessage() {
  
    return message;
  }
  
  public Errors getErrorType() {
  
    return error;
  }
  
  public void setTitle(String title) {
  
    this.title = title;
  }
  
  public void setMessage(String message) {
  
    this.message = message;
  }
  
  public void setErrorType(Errors error) {
  
    this.error = error;
  }
}
