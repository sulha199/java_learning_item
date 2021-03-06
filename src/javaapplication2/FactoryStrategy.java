/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Source : https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns
*/

package javaapplication2;

enum AccountTypes {
    CURRENT, SAVINGS, STANDARD_MONEY_MARKET, HIGH_ROLLER_MONEY_MARKET
}

class InterestCalculationStrategyFactory {

    private final InterestCalculationStrategy currentAccountInterestCalculationStrategy = new CurrentAccountInterestCalculation();
    private final InterestCalculationStrategy savingsAccountInterestCalculationStrategy = new SavingsAccountInterestCalculation();
    private final InterestCalculationStrategy moneyMarketAccountInterestCalculationStrategy = new MoneyMarketInterestCalculation();
    private final InterestCalculationStrategy highRollerMoneyMarketAccountInterestCalculationStrategy = new HighRollerMoneyMarketInterestCalculation();
    private final InterestCalculationStrategy noInterestCalculationStrategy = new NoInterestCalculation();

    //A factory can create a new instance of a class for each request, but since our calculation strategies are stateless,
    //we can hang on to a single instance of each strategy and return that whenever someone asks for it.
    public InterestCalculationStrategy getInterestCalculationStrategy(AccountTypes accountType) {
        switch (accountType) {
            case CURRENT:
                return currentAccountInterestCalculationStrategy;
            case SAVINGS:
                return savingsAccountInterestCalculationStrategy;
            case STANDARD_MONEY_MARKET:
                return moneyMarketAccountInterestCalculationStrategy;
            case HIGH_ROLLER_MONEY_MARKET:
                return highRollerMoneyMarketAccountInterestCalculationStrategy;
            default:
                return noInterestCalculationStrategy;
        }
    }
}

interface InterestCalculationStrategy {

    double calculateInterest(double accountBalance);  //Note the absence of an access modifier - interface methods are implicitly public.
}

class CurrentAccountInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return accountBalance * (0.02 / 12);
    }
}

class SavingsAccountInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return accountBalance * (0.04 / 12);
    }
}

class MoneyMarketInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return accountBalance * (0.06 / 12);
    }
}

class HighRollerMoneyMarketInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return accountBalance < 100000.00 ? 0 : accountBalance * (0.075 / 12);
    }
}

class NoInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return 0;
    }
}
