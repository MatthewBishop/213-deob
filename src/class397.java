import java.util.Comparator;

class class397 implements Comparator {

    static int field3691;
    // $FF: synthetic field

    final class398 this$0;

    class397(class398 var1) {
        this.this$0 = var1;
    }

    int method2119(class399 var1, class399 var2) {
        if (var1.field3701 > var2.field3701) {
            return 1;
        } else {
            return var1.field3701 < var2.field3701 ? -1 : 0;
        }
    }

    public int compare(Object var1, Object var2) {
        return this.method2119((class399) var1, (class399) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public static String method2120(CharSequence var0) {
        int var1 = var0.length();
        StringBuilder var2 = new StringBuilder(var1);

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.'
                    && var4 != '-' && var4 != '*' && var4 != '_') {
                if (var4 == ' ') {
                    var2.append('+');
                } else {
                    byte var5 = class100.charToByteCp1252(var4);
                    var2.append('%');
                    int var6 = var5 >> 4 & 15;
                    if (var6 >= 10) {
                        var2.append((char) (var6 + 55));
                    } else {
                        var2.append((char) (var6 + 48));
                    }

                    var6 = var5 & 15;
                    if (var6 >= 10) {
                        var2.append((char) (var6 + 55));
                    } else {
                        var2.append((char) (var6 + 48));
                    }
                }
            } else {
                var2.append(var4);
            }
        }

        return var2.toString();
    }
}
