package day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompressAlgorithmTest {

    @Test
    void name() throws IOException {
        List<String> strings = Arrays.asList("AAAAAA", "AAAAABCC", "", null, "ABC", "ABBBBBC");
        List<String> expected = Arrays.asList("6A", "5AB2C", "", null, "ABC", "A5BC");

        CompressAlgorithm day3 = new CompressAlgorithm();
        for (int i = 0; i < strings.size(); i++) {
            String result = day3.compress(strings.get(i));
            assertEquals(expected.get(i), result);
        }
    }
}