package pl.piotrowski.checkResult;

import java.util.*;

public class ValidationNumbers {

    static void validateUserNumbers(int[] source, GameType type) throws NumberValidationException {
        validateLength(source, type);
        validateNumbersDistinction(source);

    }

    private static void validateLength(int[] source, GameType type) throws NumberValidationException {
        if (source.length != type.maxNumbers) {
            throw new NumberValidationException("Niepoprawna ilość liczb! Dla danego tupu " + type.toString()
                    + " podaj " + type.maxNumbers + " liczb");
        }
    }

    static void validateNumbersDistinction(int[] source) throws NumberValidationException {

        if (Arrays.stream(source).distinct().count() != source.length){
            throw new NumberValidationException("Liczby nie mogą się powtarzać!");
        }

//        if (new HashSet(Arrays.asList(source)).size() != source.length) {
//            throw new NumberValidationException("Liczby nie mogą się powtarzać!");
//        }

    }
}
