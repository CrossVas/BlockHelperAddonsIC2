package reforged.mods.blockhelper.addons;

public class BarElement {

    String TEXT;
    TextColor COLOR;
    int CURRENT;
    int MAX;
    int SIZE = 25; // default

    public BarElement(int current, int max, TextColor color, String text) {
        this.CURRENT = current;
        this.MAX = max;
        this.COLOR = color;
        this.TEXT = text;
    }

    public BarElement size(int size) {
        this.SIZE += size;
        return this;
    }

    @Override
    public String toString() {
        int maxBarSize = SIZE;
        int remainPercent = (((100 * CURRENT) / MAX) * maxBarSize) / 100;
        int textLength = TEXT.length();
        if (CURRENT > MAX) {
            remainPercent = maxBarSize;
        }

        char defaultChar = '\u25AF';
        String icon = "\u25AE";
        String bar = new String(new char[maxBarSize]).replace('\0', defaultChar);
        StringBuilder barDone = new StringBuilder();
        for (int i = 0; i < remainPercent; i++) {
            barDone.append(icon);
        }
        String barRemain = bar.substring(remainPercent);
        String finalString = barDone + barRemain;
        int mid = finalString.length() / 2;
        String firstHalf = finalString.substring(0, mid - textLength / 2);
        String secondHalf = finalString.substring(mid + textLength / 2);
        String finalBar = TextColor.WHITE.literal("[") + COLOR.literal(firstHalf + TEXT + secondHalf) + TextColor.WHITE.literal("]");
        return finalBar;
    }

    public static String bar(int current, int total, TextColor color, String text) {
        return new BarElement(current, total, color, text).toString();
    }

    public static String bar(int current, int total, TextColor color, String text, int sizeExtra) {
        return new BarElement(current, total, color, text).size(sizeExtra).toString();
    }
}
