package model;

public class Limits {
  private double upper;
  private double lower;

  public Limits(double upper, double lower){
    this.upper = upper;
    this.lower = lower;
  }

  public void setLower(double lower) {
    if(lower < upper)
    this.lower = lower;
  }

  public void setUpper(double upper) {
    if(upper > lower)
    this.upper = upper;
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

  public boolean isOverLowerLimit(double value){
    return value < lower;
  }
}
