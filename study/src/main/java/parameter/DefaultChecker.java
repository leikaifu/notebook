package parameter;

/**
 * @author huang
 */
public class DefaultChecker implements IResponseCheck {

  private boolean pass = false;
  private String checkMessage;

  public DefaultChecker() {
    this(false, null);
  }

  public DefaultChecker(String message) {
    this(false, message);
  }

  public DefaultChecker(boolean pass, String checkMessage) {
    this.pass = pass;
    this.checkMessage = checkMessage;
  }

  @Override
  public boolean isPass() {
    return pass;
  }

  protected void setPass(boolean pass) {
    this.pass = pass;
  }

  @Override
  public String getCheckMessage() {
    return checkMessage;
  }

  protected void setCheckMessage(String checkMessage) {
    this.checkMessage = checkMessage;
  }

  @Override
  public String responseText() {
    return null;
  }

  @Override
  public long readResponseLength() {
    return -1;
  }

}
