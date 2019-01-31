package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:05
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();

}
