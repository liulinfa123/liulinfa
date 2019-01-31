package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:23
 */
public class Soy extends Condiment {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
