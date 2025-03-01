package inheritance.assignments.numberseven;

public class Customer extends Person {
    private int customerNumber;
    private boolean onMailingList;

    public Customer(int customerNumber, boolean onMailingList) {
        this.customerNumber = customerNumber;
        this.onMailingList = onMailingList;
    }

    public Customer(String name, String address, String phoneNumber, int customerNumber, boolean onMailingList) {
        super(name, address, phoneNumber);
        if(customerNumber <= 0){
            throw new IllegalArgumentException("Error: customer number uninitialized.");
        }
        this.customerNumber = customerNumber;
        this.onMailingList = onMailingList;
    }
    public boolean getMailingList(){
        return this.onMailingList;
    }
    public String getOnMailingListString(){
        final String ON_MAILING_LIST_TEXT = "You are on the mailing list.";
        final String OFF_MAILING_LIST_TEXT = "You are off the mailing list.";
        if(this.onMailingList){
            return ON_MAILING_LIST_TEXT;
        }
        return OFF_MAILING_LIST_TEXT;
    }
    public int getCustomerNumber(){
        return this.customerNumber;
    }

    public String toString(){
        return String.format("Hello, %s" +
                "\nYour address is: %s" +
                "\nYour number is:%d" +
                "\nYour phone number is: %s" +
                "\nYour mailing list selection is: %b", this.getName(),this.getAddress(),this.getCustomerNumber(),this.phoneNumber,this.getOnMailingListString());
    }
}
