package InvoiceGenerationSoftware;

import java.util.List;

public class Main {

	private static void generateInvoice(Invoice invoice) {
	    // header
	    System.out.println("-----------------------------------");
	    System.out.printf("%-10s %-10s %-10s\n", "Product", "Price", "Tax");
	    System.out.println("-----------------------------------");

	    // Print item's details
	    for (InvoiceItem item : invoice.getItems()) {
	        Product product = item.getProduct();
	        int quantity = item.getQuantity();
	        double totalPrice = item.getTotalPrice();
	        double totalTax = item.getTotalTax();

	        System.out.printf("%-10s %-10.2f %-10.2f\n", product.getName(), totalPrice, totalTax);
	    }

	    // Print totals
	    System.out.println("-----------------------------------");
	    System.out.printf("%-10s %-10.2f %-10.2f\n", "Total", invoice.calculateTotalAmount(), invoice.calculateTotalTax());
	    System.out.printf("%-10s %-10.2f\n", "Grand Total", invoice.calculateGrandTotal());
	    System.out.println("-----------------------------------");
	}

	    private static void generateReceipt(List<Product> purchasedProducts) {
	        double totalAmount = 0.0;
	        double totalTax = 0.0;

	        // Print header
	        System.out.println("-----------------------------------");
	        System.out.printf("%-10s %-10s %-10s\n", "Product", "Price", "Tax");
	        System.out.println("-----------------------------------");

	        // Print each product's details
	        for (Product product : purchasedProducts) {
	            double price = product.getPrice();
	            double taxAmount = calculateTax(product);
	            totalAmount += price;
	            totalTax += taxAmount;
	            System.out.printf("%-10s %-10.2f %-10.2f\n", product.getName(), price, taxAmount);
	        }

	        // Print totals
	        System.out.println("-----------------------------------");
	        System.out.printf("%-10s %-10.2f %-10.2f\n", "Total", totalAmount, totalTax);
	        System.out.printf("%-10s %-10.2f\n", "Grand Total", totalAmount + totalTax);
	        System.out.println("-----------------------------------");
	    }

	    private static double calculateTax(Product product) {
	        double taxAmount = 0.0;
	        for (Tax tax : product.getTaxGroup().getTaxes()) {
	            taxAmount = (product.getPrice() * tax.getPercentage() / 100);
	        }
	        return taxAmount;
	    }
	
	public static void main(String[] args) {
        // Create individual taxes
        Tax noTax = new Tax("No Tax", 0.0);
        Tax vatTax = new Tax("VAT", 1.2); // Example percentage
        Tax sgstTax = new Tax("SGST", 1.0); // Example percentage
        Tax cgstTax = new Tax("CGST", 1.0); // Example percentage

        // Create tax groups
        TaxGroup riceTaxGroup = new TaxGroup("Rice Tax Group");
        riceTaxGroup.addTax(noTax);

        TaxGroup petrolTaxGroup = new TaxGroup("Petrol Tax Group");
        petrolTaxGroup.addTax(vatTax);

        TaxGroup soapTaxGroup = new TaxGroup("Soap Tax Group");
        soapTaxGroup.addTax(sgstTax);
        soapTaxGroup.addTax(cgstTax);

        // Create products with tax groups
        Product rice = new Product("Rice", 10.0, riceTaxGroup);
        Product petrol = new Product("Petrol", 65.0, petrolTaxGroup);
        Product soap = new Product("Soap", 10.0, soapTaxGroup);
        
     // Create an invoice
        Invoice invoice = new Invoice();
        invoice.addItem(petrol, 1); // Adding  unit of Petrol
        invoice.addItem(soap, 1);   // Adding  units of Soap

        // Generate and print invoice
        generateInvoice(invoice);
    }
}