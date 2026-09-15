package Exercise04;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductionLine {
    private LinkedList<Product> products = new LinkedList<>();

    public void addHighPriority(Product p) {
        products.addFirst(p);
    }

    public void addNormalPriority(Product p) {
        products.addLast(p);
    }

    public void displayProductionLine() {
        Iterator<Product> it = products.iterator();
        StringBuilder result = new StringBuilder();
        int index = 1;

        while (it.hasNext()) {
            Product product = it.next();

            result.append(String.format(
                    "| [Thứ tự %d] %s | %s%n",
                    index,
                    product.getId(),
                    product.getName()
            ));

            index++;
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |            DÂY CHUYỀN SẢN XUẤT LINKEDLIST            |
                +-------------------------------------------------------+
                %s+-------------------------------------------------------+
                """, result);
    }
}
