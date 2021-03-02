package utility;

import javafx.util.StringConverter;

public class DoubleStringConverter extends StringConverter<Double>
{
  @Override
  public String toString(Double aDouble) {
    return aDouble == null || aDouble == 0.0 ? "" : aDouble.toString();
  }

  @Override public Double fromString(String s)
  {
    try
    {
      return Double.parseDouble(s);
    }
    catch (Exception e)
    {
      return 0.0;
    }
  }
}