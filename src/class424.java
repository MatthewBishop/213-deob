public final class class424 {

    static class424[] field3787 = new class424[0];

    static int field3785;

    static int field3786;

    float field3788;

    float field3789;

    float field3790;

    float field3791;

    static {
        class310.method1689(100);
        new class424();
    }

    class424() {
        this.method2244();
    }

    public void method2243() {
        class424[] var1 = field3787;
        synchronized (field3787) {
            if (field3786 < field3785 - 1) {
                field3787[++field3786 - 1] = this;
            }

        }
    }

    void method2240(float var1, float var2, float var3, float var4) {
        this.field3788 = var1;
        this.field3789 = var2;
        this.field3790 = var3;
        this.field3791 = var4;
    }

    public void method2241(float var1, float var2, float var3, float var4) {
        float var5 = (float) Math.sin((double) (var4 * 0.5F));
        float var6 = (float) Math.cos((double) (var4 * 0.5F));
        this.field3788 = var5 * var1;
        this.field3789 = var5 * var2;
        this.field3790 = var3 * var5;
        this.field3791 = var6;
    }

    final void method2244() {
        this.field3790 = 0.0F;
        this.field3789 = 0.0F;
        this.field3788 = 0.0F;
        this.field3791 = 1.0F;
    }

    public final void method2242(class424 var1) {
        this.method2240(
                var1.field3789 * this.field3790 + var1.field3788 * this.field3791 + var1.field3791 * this.field3788
                        - this.field3789 * var1.field3790,
                var1.field3789 * this.field3791 + (this.field3789 * var1.field3791 - this.field3790 * var1.field3788)
                        + this.field3788 * var1.field3790,
                this.field3790 * var1.field3791 + var1.field3788 * this.field3789 - var1.field3789 * this.field3788
                        + var1.field3790 * this.field3791,
                this.field3791 * var1.field3791 - var1.field3788 * this.field3788 - this.field3789 * var1.field3789
                        - this.field3790 * var1.field3790);
    }

    public String toString() {
        return this.field3788 + "," + this.field3789 + "," + this.field3790 + "," + this.field3791;
    }

    public int hashCode() {
        boolean var1 = true;
        float var2 = 1.0F;
        var2 = var2 * 31.0F + this.field3788;
        var2 = var2 * 31.0F + this.field3789;
        var2 = var2 * 31.0F + this.field3790;
        var2 = this.field3791 + var2 * 31.0F;
        return (int) var2;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class424)) {
            return false;
        } else {
            class424 var2 = (class424) var1;
            return this.field3788 == var2.field3788 && this.field3789 == var2.field3789
                    && this.field3790 == var2.field3790 && var2.field3791 == this.field3791;
        }
    }

    static float method2245(float[] var0, int var1, float var2) {
        float var3 = var0[var1];

        for (int var4 = var1 - 1; var4 >= 0; --var4) {
            var3 = var0[var4] + var3 * var2;
        }

        return var3;
    }
}
