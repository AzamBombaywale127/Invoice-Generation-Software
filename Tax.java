package InvoiceGenerationSoftware;
public class Tax {
	  private double percentage;
	private String name;

	    public Tax(String name, double percentage) {
	        this.name = name;
	        this.percentage = percentage;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPercentage() {
	        return percentage;
	    }

}

