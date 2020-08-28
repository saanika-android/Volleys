package com.example.volleys.Model;

public class Info extends PackageDetails {
    private String thyro_profile_id;

    private String test_code;

    private String profile_name;

    private String ziffy_profile_price;

    private int ziffy_discount;

    private String test_discount_price;

    private int test_count;
  public void setThyro_profile_id (String profile_id) {
      this.thyro_profile_id=thyro_profile_id;
}
    public String getThyro_profile_id(){
        return this.thyro_profile_id;
    }
    public void setTest_code(String test_code){
        this.test_code = test_code;
    }
    public String getTest_code(){
        return this.test_code;
    }
    public void setProfile_name(String profile_name){
        this.profile_name = profile_name;
    }
    public String getProfile_name(){
        return this.profile_name;
    }
    public void setZiffy_profile_price(String ziffy_profile_price){
        this.ziffy_profile_price = ziffy_profile_price;
    }
    public String getZiffy_profile_price(){
        return this.ziffy_profile_price;
    }
    public void setZiffy_discount(int ziffy_discount){
        this.ziffy_discount = ziffy_discount;
    }
    public int getZiffy_discount(){
        return this.ziffy_discount;
    }
    public void setTest_discount_price(String test_discount_price){
        this.test_discount_price = test_discount_price;
    }
    public String getTest_discount_price(){
        return this.test_discount_price;
    }
    public void setTest_count(int test_count){
        this.test_count = test_count;
    }
    public int getTest_count(){
        return this.test_count;
    }
}
