public class HealthBarDefinition extends DualNode {

    public static AbstractArchive HealthBarDefinition_archive;

    public static AbstractArchive field1522;

    public static EvictingDualNodeHashTable HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);

    static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);

    public int field1521;

    public int int1 = 255;

    public int int2 = 255;

    public int int3 = -1;

    public int field1533 = 1;

    public int int5 = 70;

    int frontSpriteID = -1;

    int backSpriteID = -1;

    public int width = 30;

    public int widthPadding = 0;

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 1) {
            var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.int1 = var1.readUnsignedByte();
        } else if (var2 == 3) {
            this.int2 = var1.readUnsignedByte();
        } else if (var2 == 4) {
            this.int3 = 0;
        } else if (var2 == 5) {
            this.int5 = var1.readUnsignedShort();
        } else if (var2 == 6) {
            var1.readUnsignedByte();
        } else if (var2 == 7) {
            this.frontSpriteID = var1.method2516();
        } else if (var2 == 8) {
            this.backSpriteID = var1.method2516();
        } else if (var2 == 11) {
            this.int3 = var1.readUnsignedShort();
        } else if (var2 == 14) {
            this.width = var1.readUnsignedByte();
        } else if (var2 == 15) {
            this.widthPadding = var1.readUnsignedByte();
        }

    }

    public SpritePixels getFrontSprite() {
        if (this.frontSpriteID < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) HealthBarDefinition_cachedSprites.get((long) this.frontSpriteID);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class484.SpriteBuffer_getSprite(field1522, this.frontSpriteID, 0);
                if (var1 != null) {
                    HealthBarDefinition_cachedSprites.put(var1, (long) this.frontSpriteID);
                }

                return var1;
            }
        }
    }

    public SpritePixels getBackSprite() {
        if (this.backSpriteID < 0) {
            return null;
        } else {
            SpritePixels var1 = (SpritePixels) HealthBarDefinition_cachedSprites.get((long) this.backSpriteID);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class484.SpriteBuffer_getSprite(field1522, this.backSpriteID, 0);
                if (var1 != null) {
                    HealthBarDefinition_cachedSprites.put(var1, (long) this.backSpriteID);
                }

                return var1;
            }
        }
    }

    public static byte[] method1007(Object var0, boolean var1) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof byte[]) {
            byte[] var6 = (byte[]) ((byte[]) var0);
            if (var1) {
                int var4 = var6.length;
                byte[] var5 = new byte[var4];
                System.arraycopy(var6, 0, var5, 0, var4);
                return var5;
            } else {
                return var6;
            }
        } else if (var0 instanceof AbstractByteArrayCopier) {
            AbstractByteArrayCopier var2 = (AbstractByteArrayCopier) var0;
            return var2.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
