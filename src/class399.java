public final class class399 implements Comparable {

    static short[] foundItemIds;

    static Clock clock;

    static Archive archive6;

    Object field3699;

    Object field3700;

    long field3701;

    long field3702;

    class399(Object var1, Object var2) {
        this.field3699 = var1;
        this.field3700 = var2;
    }

    int method2128(class399 var1) {
        if (this.field3702 < var1.field3702) {
            return -1;
        } else {
            return this.field3702 > var1.field3702 ? 1 : 0;
        }
    }

    public boolean equals(Object var1) {
        if (var1 instanceof class399) {
            return this.field3700.equals(((class399) var1).field3700);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int hashCode() {
        return this.field3700.hashCode();
    }

    public int compareTo(Object var1) {
        return this.method2128((class399) var1);
    }

    public static PrivateChatMode method2129(int var0) {
        PrivateChatMode[] var1 = new PrivateChatMode[] { PrivateChatMode.field4163, PrivateChatMode.field4162,
                PrivateChatMode.field4161 };
        PrivateChatMode[] var2 = var1;

        for (int var3 = 0; var3 < var2.length; ++var3) {
            PrivateChatMode var4 = var2[var3];
            if (var0 == var4.id) {
                return var4;
            }
        }

        return null;
    }
}
