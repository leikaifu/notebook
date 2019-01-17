package parameter;

/**
 * @author huang
 */
public interface IResponseCheck {

  boolean isPass();

  String getCheckMessage();

  String responseText();

  long readResponseLength();

}
