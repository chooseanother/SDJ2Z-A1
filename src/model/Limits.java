package model;

public class Limits {
  private double upper;
  private double lower;

  public Limits(double upper, double lower){
    this.upper = upper;
    this.lower = lower;
  }

  public void setLower(double lower) throws Exception {
      if (lower < upper)
        this.lower = lower;
      else{
        throw new Exception("value to set is to high");
      }
  }

  public void setUpper(double upper) throws Exception {
    if(upper > lower)
    this.upper = upper;
    else{
      throw new Exception("value to set is too low");
    }
  }

  public double getLower() {
    return lower;
  }

  public double getUpper() {
    return upper;
  }

  public boolean isOverUpperLimit(double value){
    return value > upper;
  }

  public boolean isUnderLowerLimit(double value){
    return value < lower;
  }
}
