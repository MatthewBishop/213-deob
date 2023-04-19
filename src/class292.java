import java.util.HashMap;
import java.util.TimeZone;

public final class class292 {

    static final HashMap field2709 = new HashMap();

    static IndexedSprite titlebuttonSprite;

    static {
        java.util.Calendar.getInstance(method1604("Europe/London"));
    }

    static TimeZone method1604(String var0) {
        HashMap var1 = field2709;
        synchronized (field2709) {
            TimeZone var2 = (TimeZone) field2709.get(var0);
            if (var2 == null) {
                var2 = TimeZone.getTimeZone(var0);
                field2709.put(var0, var2);
            }

            return var2;
        }
    }

    public static boolean isWorldMapEvent(int var0) {
        return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16
                || var0 == 17;
    }
}
