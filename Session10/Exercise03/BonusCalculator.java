package Exercise03;

public class BonusCalculator {
    public double calculateBonus(double salary) {
        return salary * 0.1;
    }

    public double calculateBonus(double salary, double performanceRate) {
        return salary * performanceRate;
    }

    public double calculateBonus(double salary, double performanceRate, int seniorityYears) {
        return salary * performanceRate + seniorityYears * 500000;
    }
}
