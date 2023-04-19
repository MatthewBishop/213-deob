public class class172 {

    public UrlRequest field1445;

    public float[] field1444;
    // $FF: synthetic field

    final class166 this$0;

    class172(class166 var1) {
        this.this$0 = var1;
        this.field1444 = new float[4];
    }

    static long method954(CharSequence var0) {
        long var1 = 0L;
        int var3 = var0.length();

        for (int var4 = 0; var4 < var3; ++var4) {
            var1 *= 37L;
            char var5 = var0.charAt(var4);
            if (var5 >= 'A' && var5 <= 'Z') {
                var1 += (long) (var5 + 1 - 65);
            } else if (var5 >= 'a' && var5 <= 'z') {
                var1 += (long) (var5 + 1 - 97);
            } else if (var5 >= '0' && var5 <= '9') {
                var1 += (long) (var5 + 27 - 48);
            }

            if (var1 >= 177917621779460413L) {
                break;
            }
        }

        while (0L == var1 % 37L && 0L != var1) {
            var1 /= 37L;
        }

        return var1;
    }
}
