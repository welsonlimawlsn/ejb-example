package br.com.welson.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class InterestCalculator implements InterestCalculatorRemote {

    @Override
    public double calculatePercentage(double value, double percentage) {
        return value + (value / 100 * percentage);
    }
}
