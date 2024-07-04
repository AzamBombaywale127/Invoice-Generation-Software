package InvoiceGenerationSoftware;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	  private List<InvoiceItem> items;

	    public Invoice() {
	        this.items = new ArrayList<>();
	    }

	    public void addItem(Product product, int quantity) {
	        items.add(new InvoiceItem(product, quantity));
	    }

	    public List<InvoiceItem> getItems() {
	        return items;
	    }

	    public double calculateTotalAmount() {
	        double totalAmount = 0.0;
	        for (InvoiceItem item : items) {
	            totalAmount += item.getTotalPrice();
	        }
	        return totalAmount;
	    }

	    public double calculateTotalTax() {
	        double totalTax = 0.0;
	        for (InvoiceItem item : items) {
	            totalTax += item.getTotalTax();
	        }
	        return totalTax;
	    }

	    public double calculateGrandTotal() {
	        return calculateTotalAmount() + calculateTotalTax();
	    }
	}

	class InvoiceItem {
	    private Product product;
	    private int quantity;

	    public InvoiceItem(Product product, int quantity) {
	        this.product = product;
	        this.quantity = quantity;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public double getTotalPrice() {
	        return product.getPrice() * quantity;
	    }

	    public double getTotalTax() {
	        double totalTax = 0.0;
	        for (Tax tax : product.getTaxGroup().getTaxes()) 
	        {
	            totalTax += (product.getPrice() * quantity * tax.getPercentage() / 100);
	        }
	        return totalTax;
	    }
}
