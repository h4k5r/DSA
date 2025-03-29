package hari.engineer.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class IsRectangle {
    public static boolean isRectangle(String path) {
        char[] split = path.toCharArray();
        Stack<Map.Entry<Character, Integer>> charactersEntry = new Stack<>();

        for (char c : split) {
            if (!charactersEntry.isEmpty()) {
                Map.Entry<Character, Integer> entry = charactersEntry.peek();
                if (entry.getKey().equals(c)) {
                    entry = charactersEntry.pop();
                    charactersEntry.push(Map.entry(c, entry.getValue() + 1));
                } else {
                    charactersEntry.push(Map.entry(c, 1));
                }
            } else {
                charactersEntry.push(Map.entry(c, 1));
            }
        }

        if (charactersEntry.size() == 4) {
            List<String> expectedNext = new ArrayList<>();
            int up = 0, down = 0, left = 0, right = 0;

            for (Map.Entry<Character, Integer> entry : charactersEntry) {
                if (expectedNext.size() == 0) {
                    switch (entry.getKey()) {
                        case '^' -> {
                            up = entry.getValue();
                            expectedNext.addAll(List.of("<", ">"));
                        }
                        case '>' -> {
                            right = entry.getValue();
                            expectedNext.addAll(List.of("v", "^"));
                        }
                        case 'v' -> {
                            down = entry.getValue();
                            expectedNext.addAll(List.of("<", ">"));

                        }
                        case '<' -> {
                            left = entry.getValue();
                            expectedNext.addAll(List.of("v", "^"));
                        }
                    }

                } else {
                    char key = entry.getKey();
                    if (
                            (key == 'v' || key == '^') && expectedNext.stream().anyMatch(s -> s.equals("v") || s.equals("^")) ||
                                    (key == '<' || key == '>') && expectedNext.stream().anyMatch(s -> s.equals("<") || s.equals(">"))
                    ) {
                        switch (key) {
                            case '^' -> {
                                up = entry.getValue();
                                expectedNext = List.of("<", ">");
                            }
                            case '>' -> {
                                right = entry.getValue();
                                expectedNext = List.of("v", "^");
                            }
                            case 'v' -> {
                                down = entry.getValue();
                                expectedNext = List.of("<", ">");
                            }
                            case '<' -> {
                                left = entry.getValue();
                                expectedNext = List.of("v", "^");
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            return (up == down) && (right == left);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRectangle("^^>>vv<<"));
        System.out.println(isRectangle("^^>>vv<<>"));
        System.out.println(isRectangle("^^>v<<vv>>"));
        System.out.println(isRectangle("^^^>>>vvv<<<"));
        System.out.println(isRectangle("^^>vv<<>"));
        System.out.println(isRectangle("^^>><<vv"));
        System.out.println(isRectangle("^>v<^>v<"));
        System.out.println(isRectangle("^^>v<^<v>^>"));
        System.out.println(isRectangle("^>v<^^>>vv<<"));

    }
}
