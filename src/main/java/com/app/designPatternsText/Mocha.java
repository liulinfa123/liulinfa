package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:17
 *  mocha 是一个装饰者 ，所以让他拓展自condiment
 */
public class Mocha extends Condiment {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
