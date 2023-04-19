public class class426 {

    static Archive field3811;

    float field3810;

    float field3799;

    float field3800;

    float field3801;

    float field3802;

    float field3803;

    float field3804;

    float field3805;

    float field3806;

    float field3807;

    float field3808;

    float field3809;

    static {
        new class426();
    }

    class426() {
        this.method2269();
    }

    void method2269() {
        this.field3809 = 0.0F;
        this.field3808 = 0.0F;
        this.field3807 = 0.0F;
        this.field3805 = 0.0F;
        this.field3804 = 0.0F;
        this.field3803 = 0.0F;
        this.field3801 = 0.0F;
        this.field3800 = 0.0F;
        this.field3799 = 0.0F;
        this.field3806 = 1.0F;
        this.field3802 = 1.0F;
        this.field3810 = 1.0F;
    }

    void method2266(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3799;
        float var5 = this.field3802;
        float var6 = this.field3805;
        float var7 = this.field3808;
        this.field3799 = var4 * var2 - this.field3800 * var3;
        this.field3800 = this.field3800 * var2 + var3 * var4;
        this.field3802 = var2 * var5 - var3 * this.field3803;
        this.field3803 = this.field3803 * var2 + var5 * var3;
        this.field3805 = var6 * var2 - var3 * this.field3806;
        this.field3806 = this.field3806 * var2 + var3 * var6;
        this.field3808 = var2 * var7 - this.field3809 * var3;
        this.field3809 = var3 * var7 + var2 * this.field3809;
    }

    void method2267(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3810;
        float var5 = this.field3801;
        float var6 = this.field3804;
        float var7 = this.field3807;
        this.field3810 = var3 * this.field3800 + var2 * var4;
        this.field3800 = var2 * this.field3800 - var4 * var3;
        this.field3801 = var3 * this.field3803 + var5 * var2;
        this.field3803 = this.field3803 * var2 - var5 * var3;
        this.field3804 = var3 * this.field3806 + var2 * var6;
        this.field3806 = this.field3806 * var2 - var3 * var6;
        this.field3807 = var2 * var7 + var3 * this.field3809;
        this.field3809 = var2 * this.field3809 - var7 * var3;
    }

    void method2268(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3810;
        float var5 = this.field3801;
        float var6 = this.field3804;
        float var7 = this.field3807;
        this.field3810 = var4 * var2 - this.field3799 * var3;
        this.field3799 = var2 * this.field3799 + var4 * var3;
        this.field3801 = var5 * var2 - this.field3802 * var3;
        this.field3802 = var3 * var5 + var2 * this.field3802;
        this.field3804 = var2 * var6 - this.field3805 * var3;
        this.field3805 = var2 * this.field3805 + var3 * var6;
        this.field3807 = var2 * var7 - var3 * this.field3808;
        this.field3808 = var2 * this.field3808 + var3 * var7;
    }

    void method2265(float var1, float var2, float var3) {
        this.field3807 += var1;
        this.field3808 += var2;
        this.field3809 += var3;
    }

    public String toString() {
        return this.field3810 + "," + this.field3801 + "," + this.field3804 + "," + this.field3807 + "\n"
                + this.field3799 + "," + this.field3802 + "," + this.field3805 + "," + this.field3808 + "\n"
                + this.field3800 + "," + this.field3803 + "," + this.field3806 + "," + this.field3809;
    }

    static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
        if (var4 != null) {
            int var6 = Client.camAngleY & 2047;
            int var7 = var3 * var3 + var2 * var2;
            if (var7 <= 6400) {
                int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
                int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
                int var10 = var9 * var2 + var3 * var8 >> 16;
                int var11 = var3 * var9 - var8 * var2 >> 16;
                if (var7 > 2500) {
                    var4.method2609(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2,
                            var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
                } else {
                    var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2,
                            var5.height / 2 + var1 - var11 - var4.height / 2);
                }

            }
        }
    }
}
