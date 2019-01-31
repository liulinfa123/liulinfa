package com.app.designPatternsText;

/**
 * @Author: ben
 * @Date: 2018/12/29 16:27
 */
public class Whip extends Condiment {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }

}
