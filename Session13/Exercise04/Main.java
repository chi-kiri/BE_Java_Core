package Exercise04;

public class Main {
    public static void main(String[] args) {
        ProductionLine productionLine = new ProductionLine();

        Product product1 = new Product("SP-01", "Bàn phím", 500000);
        Product product2 = new Product("SP-02", "Chuột", 300000);
        Product product3 = new Product("SP-99", "Mainboard Server", 5000000);

        productionLine.addNormalPriority(product1);
        productionLine.addNormalPriority(product2);
        productionLine.addHighPriority(product3);

        productionLine.displayProductionLine();
    }
}
