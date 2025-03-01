package utility;

public class InputValidation {


    private InputValidation(){
    }
    public enum NumberType {
        INTEGER,DOUBLE,LONG
    }
    public static boolean isNumericInteger(String userString, String errorMessage,NumberType numericType){
        int parsedInt;
        double parsedDouble;
        long parsedLong;
        if(userString == null){
            return false;
        }
        try{
            switch(numericType){
                case INTEGER -> Integer.parseInt(userString);
                case DOUBLE -> Double.parseDouble(userString);
                case LONG -> Long.parseLong(userString);
                default -> throw new IllegalArgumentException("Unsupported number type for parsing");
            }
        }catch(NumberFormatException e){
            System.err.println(errorMessage);
            return false;
        }
        return true;
    }
    public static boolean isValidInput(String userString, String errorMessage, NumberType numericType){
        if(isNumericInteger(userString, errorMessage,numericType)){
            Double num = Double.parseDouble(userString);
            return num >= 0 || num <= 100;
        }
        return false;
    }
    public static <T extends Comparable <T>> boolean isWithinBounds(T value,T lowerLimit,T upperLimit){
        if(value == null || lowerLimit == null || upperLimit == null){
            throw new IllegalArgumentException("values cannot be null.");
        }
        return value.compareTo(lowerLimit) >= 0 && value.compareTo(upperLimit) <= 0;
    }
}
