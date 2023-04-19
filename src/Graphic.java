public class Graphic extends Node {

    public int spotAnimation = -1;

    public int spotAnimationFrame = 0;

    public int spotAnimFrameCycle = 0;

    public int spotAnimationStartCycle = 0;

    public int spotAnimHeight = 0;

    public Graphic(int var1, int var2, int var3, int var4) {
        this.spotAnimation = var1;
        this.spotAnimHeight = var2;
        this.spotAnimationStartCycle = var3;
        this.spotAnimationFrame = var4;
    }
}
