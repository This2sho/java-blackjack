package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String YES = "y";
    private static final String NO = "n";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = scanner.next();
        validateNames(input);
        return Arrays.stream(input.split(DELIMITER))
            .collect(Collectors.toUnmodifiableList());
    }

    private static void validateNames(String input) {
        validateBlank(input);
        validateDelimiter(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(",로 끝날수 없습니다.");
        }
    }

    public static boolean readYesOrNo(String personName) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 %s, 아니오는 %s)%n", personName, YES, NO);
        String input = scanner.next();
        validateYesOrNo(input);
        return input.equals(YES);
    }

    private static void validateYesOrNo(String input) {
        if (input.equals(YES) || input.equals(NO)) {
            return;
        }
        throw new IllegalArgumentException(String.format("예는 %s, 아니오는 %s을 입력해야합니다.%n", YES, NO));
    }
}