public abstract class class456 {

    int field3896 = 0;

    int field3894 = 0;

    double field3897 = 0.0D;

    int field3895 = 0;

    class456(int var1, int var2) {
        this.field3896 = var1;
        this.field3894 = 0;
        this.field3895 = var2 >= 0 && var2 <= 27 ? var2 : 0;
        this.field3897 = class70.method443(this.field3894, this.field3896, this.field3895);
    }

    public void method2322() {
        if (this.field3894 < this.field3896) {
            ++this.field3894;
            this.field3897 = class70.method443(this.field3894, this.field3896, this.field3895);
        }

    }

    double method2323() {
        return this.field3897;
    }
}
