package calculator;

import java.util.ArrayList;

// entire class is specific to this program
public class MathFn {
    public Integer add(String input) {
        ArrayList<Integer> numbers = getNumbersFromString(input);
        Integer result = 0;

        for(Integer i : numbers) {
            result += i;
        }

        return result;
    }

    public Integer multiply(String input) {
        ArrayList<Integer> numbers = getNumbersFromString(input);
        Integer result = 1;

        for(Integer i : numbers) {
            result *= i;
        }

        return result;
    }

    public Integer minus(String input) {
        ArrayList<Integer> numbers = getNumbersFromString(input);
        Integer result = 0;

        for(Integer i : numbers) {
            if(numbers.indexOf(i) == 0) {
                // if first item in the list set it as the result
                result = i;
            } else {
                // do subtraction on the result otherwise
                result -= i;
            }
        }

        return result;
    }

    public Integer divide(String input) {
        ArrayList<Integer> numbers = getNumbersFromString(input);
        Integer result = 0;

        for(Integer i : numbers) {
            if(numbers.indexOf(i) == 0) {
                // if first item in the list set it as the result
                result = i;
            } else {
                // do integer division on the result otherwise
                result /= i;
            }
        }

        return result;
    }

    private ArrayList<Integer> getNumbersFromString(String input) {
        String[] array = input.split(" ");
        ArrayList<Integer> result = new ArrayList<>();

        for(Integer i = 0; i < array.length; i++) {
            try {
                result.add(Integer.parseInt(array[i]));
            } catch (NumberFormatException ex) {
                System.out.println("Non-numerical input detected and skipped.");
            }
        }
        
        return result;
    }
}
