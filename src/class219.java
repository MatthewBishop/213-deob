public class class219 {

    class122[] field2001;

    int field2002;

    class219(Buffer var1, int var2) {
        this.field2001 = new class122[var2];
        this.field2002 = var1.readUnsignedByte();

        for (int var3 = 0; var3 < this.field2001.length; ++var3) {
            class122 var4 = new class122(this.field2002, var1, false);
            this.field2001[var3] = var4;
        }

        this.method1218();
    }

    void method1218() {
        class122[] var1 = this.field2001;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            class122 var3 = var1[var2];
            if (var3.field1195 >= 0) {
                var3.field1192 = this.field2001[var3.field1195];
            }
        }

    }

    public int method1217() {
        return this.field2001.length;
    }

    class122 method1219(int var1) {
        return var1 >= this.method1217() ? null : this.field2001[var1];
    }

    class122[] method1220() {
        return this.field2001;
    }

    void method1221(class133 var1, int var2) {
        this.method1222(var1, var2, (boolean[]) null, false);
    }

    void method1222(class133 var1, int var2, boolean[] var3, boolean var4) {
        int var5 = var1.method773();
        int var6 = 0;
        class122[] var7 = this.method1220();

        for (int var8 = 0; var8 < var7.length; ++var8) {
            class122 var9 = var7[var8];
            if (var3 == null || var4 == var3[var6]) {
                var1.method771(var2, var9, var6, var5);
            }

            ++var6;
        }

    }
}
