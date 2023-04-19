public class class484 {

    static final int field4044 = (int) (Math.pow(2.0D, 4.0D) - 1.0D);

    static final int field4045 = (int) (Math.pow(2.0D, 8.0D) - 1.0D);

    public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
        byte[] var4 = var0.takeFile(var1, var2);
        boolean var3;
        if (var4 == null) {
            var3 = false;
        } else {
            class485.SpriteBuffer_decode(var4);
            var3 = true;
        }

        return !var3 ? null : ObjTypeCustomisation.method973();
    }
}
