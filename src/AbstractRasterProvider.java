public abstract class AbstractRasterProvider {

    public int[] pixels;

    public int width;

    public int height;

    protected float[] pixelsFloat;

    public abstract void drawFull(int var1, int var2);

    public abstract void draw(int var1, int var2, int var3, int var4);

    public final void apply() {
        Rasterizer2D.method2562(this.pixels, this.width, this.height, this.pixelsFloat);
    }

    public final void method2590(boolean var1) {
        this.pixelsFloat = var1 ? new float[this.height * this.width + 1] : null;
    }
}
