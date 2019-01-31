package com.app.designPatternsText;

import java.io.BufferedInputStream;
import java.io.LineNumberInputStream;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:14
 * 这也是一种饮料，做法跟espresso 一样
 */
public class DarkRoast extends Beverage {


    public DarkRoast(){
        description = "Dark Roast";
    }


    @Override
    public double cost() {
        return 1.21;
    }
}
