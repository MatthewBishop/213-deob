public class class489 {

    int[] field4054 = new int[8];

    short[] field4053 = new short[8];

    public class489(NPCComposition var1) {
        int var2 = 0;
        if (var1.method1028()) {
            var2 = var1.method1029().length;
            System.arraycopy(var1.method1029(), 0, this.field4054, 0, var2);
            System.arraycopy(var1.method1031(), 0, this.field4053, 0, var2);
        }

        for (int var3 = var2; var3 < 8; ++var3) {
            this.field4054[var3] = -1;
            this.field4053[var3] = -1;
        }

    }

    public int[] method2546() {
        return this.field4054;
    }

    public short[] method2544() {
        return this.field4053;
    }

    public void method2545(int var1, int var2, short var3) {
        this.field4054[var1] = var2;
        this.field4053[var1] = var3;
    }

    public void method2547(int[] var1, short[] var2) {
        this.field4054 = var1;
        this.field4053 = var2;
    }
}
