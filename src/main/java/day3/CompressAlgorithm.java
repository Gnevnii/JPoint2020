package day3;

import java.io.IOException;
import java.io.StringReader;

public class CompressAlgorithm {

    public String compress(String targetString) throws IOException {
        if (targetString == null || targetString.equals("")) {
            return targetString;
        }

        StringReader sr = new StringReader(targetString);
        StringBuilder sb = new StringBuilder();

        int lastRead = -1;
        int currentRead;
        int currentCount = 0;

        while ((currentRead = sr.read()) != -1) {
            if (lastRead == -1) {
                lastRead = currentRead;
                currentCount++;
                continue;
            }

            if (currentRead == lastRead) {
                currentCount++;
                continue;
            }

            append(sb, lastRead, currentCount);

            currentCount = 1;
            lastRead = currentRead;
        }

        append(sb, lastRead, currentCount);

        if (sb.toString().equals("")) {
            sb.append(currentCount).append(Character.toString(lastRead));
        }

        return sb.toString();
    }

    private void append(final StringBuilder sb, final int lastRead, final int currentCount) {
        if (currentCount == 1) {
            sb.append(Character.toString(lastRead));
        } else {
            sb.append(currentCount).append(Character.toString(lastRead));
        }
    }
}
