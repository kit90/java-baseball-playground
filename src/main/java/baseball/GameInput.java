package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameInput {
    public static List<Integer> getPlayerNumbers(String input){
        List<String> inputList = Arrays.asList(input.split(""));
        validateDuplication(inputList);
        return inputList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateDuplication(List<String> inputList) {
        boolean duplicated = inputList.stream()
                .distinct()
                .count() != inputList.size();
        if(duplicated) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }
}
