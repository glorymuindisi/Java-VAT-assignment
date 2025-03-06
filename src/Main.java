import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double net_price = 9.99;
        double vat_rate = 0.23;

        double grossPrice = net_price * (1 + vat_rate);
        System.out.printf("Gross price of one product: %.2f%n", grossPrice);

        double totalGross = grossPrice * 10_000;
        System.out.printf("Total gross value for 10,000 products: %.2f%n", totalGross);

        double totalNet = totalGross / (1 + vat_rate);
        System.out.printf("Total net value for 10,000 products: %.2f%n", totalNet);

        System.out.println(" ");
        System.out.println("Now using Big Decimal: ");
        System.out.println(" ");

        BigDecimal netPrice = new BigDecimal("9.99");

        BigDecimal quantity = new BigDecimal("10000");

        // Calculate gross price
        BigDecimal bd_price_withVAT = netPrice.multiply(new BigDecimal("1.23"));
        bd_price_withVAT = bd_price_withVAT.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.printf("Gross price of one product: %.2f%n", bd_price_withVAT);

        // Calculate total gross value for 10,000 products
        BigDecimal bd_total_Gross = bd_price_withVAT.multiply(quantity).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.printf("Total gross value for 10,000 products: %.2f%n", bd_total_Gross);

        // Calculate total net value excluding VAT
        BigDecimal total_Net = bd_total_Gross.divide(new BigDecimal("1.23"), 2, BigDecimal.ROUND_HALF_EVEN);
        System.out.printf("Total net value for 10,000 products: %.2f%n", total_Net);

    }
}