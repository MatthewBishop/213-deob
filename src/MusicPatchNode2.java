public class MusicPatchNode2 {

    byte[] field2718;

    byte[] field2717;

    int field2719;

    int field2720;

    int field2725;

    int field2722;

    int field2723;

    int field2724;

    int field2721;

    public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
        if (!var0.isValidFileName(var1, var2)) {
            return null;
        } else {
            int var3 = var0.getGroupId(var1);
            int var4 = var0.getFileId(var3, var2);
            byte[] var7 = var0.takeFile(var3, var4);
            boolean var6;
            if (var7 == null) {
                var6 = false;
            } else {
                class485.SpriteBuffer_decode(var7);
                var6 = true;
            }

            IndexedSprite var5;
            if (!var6) {
                var5 = null;
            } else {
                var5 = Strings.method1852();
            }

            return var5;
        }
    }
}
