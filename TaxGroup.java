package InvoiceGenerationSoftware;

import java.util.ArrayList;
import java.util.List;

public class TaxGroup {

    private String name;
    private List<Tax> taxes;

    public TaxGroup(String name) {
        this.name = name;
        this.taxes = new ArrayList<>();
    }

    public void addTax(Tax tax) {
        taxes.add(tax);
    }

    public String getName() {
        return name;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

}
