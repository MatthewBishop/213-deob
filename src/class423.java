public class class423 {

    float field3784;

    float field3782;

    float field3783;

    static {
        new class423(0.0F, 0.0F, 0.0F);
        new class423(1.0F, 1.0F, 1.0F);
        new class423(1.0F, 0.0F, 0.0F);
        new class423(0.0F, 1.0F, 0.0F);
        new class423(0.0F, 0.0F, 1.0F);
    }

    class423(float var1, float var2, float var3) {
        this.field3784 = var1;
        this.field3782 = var2;
        this.field3783 = var3;
    }

    final float method2239() {
        return (float) Math.sqrt((double) (this.field3783 * this.field3783 + this.field3784 * this.field3784
                + this.field3782 * this.field3782));
    }

    public String toString() {
        return this.field3784 + ", " + this.field3782 + ", " + this.field3783;
    }
}
