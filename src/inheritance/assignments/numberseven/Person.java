package inheritance.assignments.numberseven;

public class Person {
    String name;
    String address;
    String phoneNumber;

    public Person() {
    }

    public Person(String name, String address, String phoneNumber) {
        final String END_OF_ERROR_MESSAGE = " cannot be null or empty.";
        final String ERROR_MESSAGE_NAME = "Name " + END_OF_ERROR_MESSAGE;
        final String ERROR_MESSAGE_ADDRESS = "Address " + END_OF_ERROR_MESSAGE;
        final String ERROR_MESSAGE_PHONE = "Phone number " + END_OF_ERROR_MESSAGE;
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME);
        }
        if(address == null || address.isEmpty()){
            throw new IllegalArgumentException(ERROR_MESSAGE_ADDRESS);
        }
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException(ERROR_MESSAGE_PHONE);
        }
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
