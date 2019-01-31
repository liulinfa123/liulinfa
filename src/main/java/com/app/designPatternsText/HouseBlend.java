package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:13
 *  这也是一种饮料，做法跟espresso 一样
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "House Blend Coffee";
    }


    @Override
    public double cost() {
        return 0.89;
    }
}
