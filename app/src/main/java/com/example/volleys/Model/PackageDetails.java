package com.example.volleys.Model;

import java.util.List;

public class PackageDetails {
    private String thyro_profile_id;

    private String test_code;

    private String profile_name;

    private String ziffy_profile_price;

    private int ziffy_discount;

    private String test_discount_price;

    private int test_count;
    private String test_name;
    private int status;

    private String message;

    private List<Info> info;

    private List<Test> test;

    private String description;

    private String preparation;

    private String profile_img;

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


    public void setTest_name(String test_name){
        this.test_name = test_name;
    }
    public String getTest_name(){
        return this.test_name;
    }

    public void setStatus(int status){
            this.status = status;
        }
        public int getStatus(){
            return this.status;
        }
        public void setMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
        public void setInfo(List<Info> info){
            this.info = info;
        }
        public List<Info> getInfo(){
            return this.info;
        }
        public void setTest(List<Test> test){
            this.test = test;
        }
        public List<Test> getTest(){
            return this.test;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getDescription(){
            return this.description;
        }
        public void setPreparation(String preparation){
            this.preparation = preparation;
        }
        public String getPreparation(){
            return this.preparation;
        }
        public void setProfile_img(String profile_img){
            this.profile_img = profile_img;
        }
        public String getProfile_img(){
            return this.profile_img;
        }
    }



