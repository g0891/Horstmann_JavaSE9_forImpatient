package ch08;

public class Ch08_06 {
    public static void main(String[] args) {
        System.out.println("'Imagination' contains only alphabetical characters: " + isAlphabeticWord("Imagination"));
        System.out.println("'Sym89!sd' contains only alphabetical characters: " + isAlphabeticWord("Sym89!sd"));

        System.out.println("'_123' is valid identifier: " + isValidJavaIdentifier("_123"));
        System.out.println("'D123!' is valid identifier: " + isValidJavaIdentifier("D123!"));

    }

    public static boolean isAlphabeticWord(String s) {
        return s != null && s.length() != 0 && s.codePoints().allMatch(Character::isAlphabetic);
    }

    public static boolean isValidJavaIdentifier(String s) {
        if (s == null || s.length() == 0) return false;

        int dollar = "$".codePointAt(0);
        int lowDash = "_".codePointAt(0);
        int firstCodePoint = s.codePointAt(0);

        return (firstCodePoint == dollar || firstCodePoint == lowDash || Character.isAlphabetic(firstCodePoint)) &&
                s.codePoints().skip(1).allMatch(cp -> cp == dollar || cp == lowDash || Character.isDigit(cp) || Character.isAlphabetic(cp));
    }
}
