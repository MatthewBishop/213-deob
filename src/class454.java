public class class454 extends class456 {

    int field3892 = 0;

    int field3893 = 0;

    public class454(int var1, int var2, int var3, int var4) {
        super(var3, var4);
        this.field3892 = var1;
        this.field3893 = var2;
    }

    public int method2318() {
        double var1 = this.method2323();
        return (int) Math.round((double) this.field3892 + (double) (this.field3893 - this.field3892) * var1);
    }
}
