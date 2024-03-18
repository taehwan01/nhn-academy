import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class TestSimpleTegexMatches {
    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect() {
        String source = "foo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {
        String source = "foofoo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        int matches = 0;
        while (matcher.find()) { // iterator와 같은 역할, 찾은 다음에 다음으로 넘어가라
            matches++;
        }

        assertEquals(matches, 2);
    }

    @Test
    public void givenText_whenMatchesWithDotMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    @Test
    void givenORSet_whenMatchesAny_theCorrect() {
        int matches = runTest("[abc]", "a");

        assertEquals(1, matches);
    }

    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() {
        int matches = runTest("[^abc]", "ababㅎabcc"); // abc 이외의 문자가 존재하는지 확인

        assertTrue(matches > 0);
    }

    @Test
    public void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
        int matches = runTest("[a-z]", "abc");

        // "[a-z]", "TWO UPPERCASE ALPHABETS 24 OVERALLs");
        // a-z 사이의 문자가 존재하는지 확인
        // assertEquals(matches, 26);
        assertEquals(matches, 3);
    }

    @Test
    public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() {
        int matches = runTest(
                "[a-zA-Z]", "TWO UPPERCASE ALPHABETS 34 OVERall");
        // "[a-zA-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 28);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect2() {
        int matches = runTest(
                "3[0-5]", "Two Uppercase alphabets 34 overall");
        // 30, 31, 32, 33, 34, 35
        // int matches = runTest("\\d", "123"); // 0-9 사이의 숫자가 존재하는지 확인
        // d는 digit의 약자
        // D는 digit이 아닌 것
        // s는 space
        // S는 space가 아닌 것
        // w는 word, 변수나 함수 이름에 사용되는 문자
        // W는 word가 아닌 것
        assertEquals(matches, 1);
    }

    @Test
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3[7-9]]", "123456789");
        /*
         * 1-37, 1-38, 1-39 -> 1,2,3,7 1,2,3,8 1,2,3,9 -> 1,2,3,7,8,9
         */

        assertEquals(matches, 6);
    }

    @Test
    public void givenTwoSets_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[1-6&&[3-9]]", "123456789");

        assertEquals(matches, 4);
    }

    @Test
    public void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[0-9&&[^2468]]", "12345678888862429");
        // ^NOT

        assertEquals(matches, 5);
    }

    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a+", "hi");
        // ?는 0번 또는 1번 나타나는 것을 찾는다. 있거나 없거나, 있어도 되고 없어도 되고
        // 2번 나타나는 건? 2번 나타나는 건 안된다.
        // a는 1번 이상 나타나는 것을 찾는다.

        // assertEquals(matches, 3);
        assertFalse(matches > 0);
    }

    @Test
    public void givenBraceQuantifierWithRange_whenMatches_thenCorrect() {
        int matches = runTest("a{2,3}", "aaaaaa");

        assertEquals(matches, 3);
    }

    @Test
    public void givenCapturingGrounp_whenMatchesWithBackReference_thenCorrect() {
        int matches = runTest("(\\d\\d)\\1\\1\\1", "12121212");

        assertEquals(matches, 1);
    }

    @Test
    public void integerMatch() {
        // 정수 패턴 만들어보기
        // String regex = "[+-]?\\d+";
        String regex = "\\b[+-]?(0|[1-9][0-9]{0,9})\\b";
        // +-는 0번 또는 1번 나타나는 것을 찾는다. 있거나 없거나, 있어도 되고 없어도 되고
        // ?는 0번 또는 1번 나타나는 것을 찾는다. 있거나 없거나, 있어도 되고 없어도 되고
        // [+-]?는 +나 -가 있거나 없거나. 왜 [+-]만 쓰면 안 돼? [+-]는 +나 -를 찾는다. 그래서 [+-]?는 +나-가 있거나없거나
        // \d는 숫자를 찾는다. \d+는 숫자가 1번 이상 나타나는 것을 찾는다.
        assertEquals(1, runTest(regex, "0"));
        assertEquals(1, runTest(regex, "1"));
        assertEquals(1, runTest(regex, "123"));
        assertEquals(0, runTest(regex, "12345678901"));
        assertEquals(1, runTest(regex, "+0"));
        assertEquals(1, runTest(regex, "+1"));
        assertEquals(0, runTest(regex, "+01"));
        assertEquals(1, runTest(regex, "+123"));
        assertEquals(0, runTest(regex, "+12345678901"));
        assertEquals(1, runTest(regex, "-0"));
        assertEquals(1, runTest(regex, "-1"));
        assertEquals(0, runTest(regex, "-01")); // 실패해야돼 왜냐하면 -가 2번 나타나는 것이다.
        assertEquals(1, runTest(regex, "-123"));
        assertEquals(0, runTest(regex, "-12345678901"));
        // \\b: 이것은 단어 경계를 나타내는 메타 문자입니다. 단어 경계는 문자와 공백 사이의 위치를 가리킵니다.

        // [+-]?: 이 부분은 부호를 나타냅니다. [ ]는 문자 집합을 나타내며, +와 -는 각각 양수와 음수를 나타내는 부호입니다. ?는 해당
        // 부호가 0번 또는 1번 나타날 수 있음을 나타냅니다. 따라서 이 부분은 부호가 나타날 수도 있고, 나타나지 않을 수도 있다는 것을
        // 의미합니다.

        // (0|[1-9][0-9]{0,9}): 이 부분은 숫자를 나타냅니다. 0은 단일 숫자 0을 나타냅니다. |[ ]는 또 다른 선택지를
        // 나타냅니다. 따라서 이 부분은 숫자가 0이거나, 또는 [1-9]로 시작하여 [0-9]{0,9}의 패턴을 따르는 경우를 나타냅니다. 여기서
        // [1-9]는 1에서 9까지의 숫자를 나타내며, [0-9]{0,9}는 0에서 9까지의 숫자가 0번부터 9번까지 나타날 수 있는 것을
        // 의미합니다.

        // \\b: 마지막으로 다시 단어 경계를 나타냅니다.
    }
}
