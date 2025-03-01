package chapter11.programmingchallenges.retailitem;

public class RetailItem {
    private String description;
    private int unitsOnHand;
    private double price;
    public RetailItem(String description, int unitsOnHand, double price){
        setDescription(description);
        setUnitsOnHand(unitsOnHand);
        setPrice(price);

    }

    public String getDescription() {
        return description;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        if(description == null || description.isEmpty() || description.isBlank()){
            throw new IllegalArgumentException("Error: Description must be filled out. Cannot be empty or null.");
        }
        this.description = description;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        final int NEGATIVE_UNITS = -1;
        if(unitsOnHand <= NEGATIVE_UNITS){
            throw new IllegalArgumentException("Error: parameter for units cannot be negative.");
        }
        this.unitsOnHand = unitsOnHand;
    }

    public void setPrice(double price) {
        final int NEGATIVE_PRICE = -1;
        if(price <= NEGATIVE_PRICE){
            throw new IllegalArgumentException("Error: parameter for price cannot be negative.");
        }
        this.price = price;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Description: ").append(this.getDescription()).append("\n")
                .append("Units: ").append(this.getUnitsOnHand()).append("\n")
                .append("Price: ").append(this.getPrice());
    return sb.toString();
    }
}
