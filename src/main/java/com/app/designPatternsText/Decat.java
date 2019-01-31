package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:15
 * 这也是一种饮料，做法跟espresso 一样
 */
public class Decat extends Beverage {

    public Decat(){
        description = "Dark Roast";
    }


    @Override
    public double cost() {
        return 1.99;
    }

}
