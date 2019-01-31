package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:09
 * 首先让espresso 拓展自beverage类，因为他是一种饮料
 */
public class Espresso extends Beverage {

    /**
     *  为了设置饮料的描述 我们写了一个构造器  记住 description 实例变量继承自Beverage
     */
    public Espresso(){
        description = "Espresso";
    }

    /**
     *  最后需要计算出espresso 的价钱 现在不需要管调料的价钱，直接把原价返回就可以了
     * @return
     */
    @Override
    public double cost() {
        return 1.99;
    }
}
