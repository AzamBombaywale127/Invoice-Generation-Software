package InvoiceGenerationSoftware;

import java.util.ArrayList;
import java.util.List;

public class TaxGroupCombination {
	 private String name;
	    private List<TaxGroup> taxGroups;

	    public TaxGroupCombination(String name) {
	        this.name = name;
	        this.taxGroups = new ArrayList<>();
	    }

	    public void addTaxGroup(TaxGroup taxGroup) {
	        taxGroups.add(taxGroup);
	    }

	    public String getName() {
	        return name;
	    }

	    public List<TaxGroup> getTaxGroups() {
	        return taxGroups;
	    }

}
