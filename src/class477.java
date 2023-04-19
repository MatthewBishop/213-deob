final class class477 implements class474 {

    static SpritePixels[] mapDotSprites;

    public void vmethod8274(Object var1, Buffer var2) {
        this.method2427((Long) var1, var2);
    }

    public Object vmethod8273(Buffer var1) {
        return var1.readLong();
    }

    void method2427(Long var1, Buffer var2) {
        var2.writeLong(var1);
    }
}
