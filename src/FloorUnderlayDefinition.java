public class FloorUnderlayDefinition extends DualNode {

    public static AbstractArchive FloorUnderlayDefinition_archive;

    public static EvictingDualNodeHashTable FloorUnderlayDefinition_cached = new EvictingDualNodeHashTable(64);

    static int field1642;

    static Archive archive11;

    static PrivateChatMode privateChatMode;

    int rgb = 0;

    public int hue;

    public int saturation;

    public int lightness;

    public int hueMultiplier;

    public void postDecode() {
        this.setHsl(this.rgb);
    }

    public void decode(Buffer var1, int var2) {
        while (true) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.decodeNext(var1, var3, var2);
        }
    }

    void decodeNext(Buffer var1, int var2, int var3) {
        if (var2 == 1) {
            this.rgb = var1.readMedium();
        }

    }

    void setHsl(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var10 + var8) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var2 == var10) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = 4.0D + (var2 - var4) / (var10 - var8);
            }
        }

        var12 /= 6.0D;
        this.saturation = (int) (var14 * 256.0D);
        this.lightness = (int) (var16 * 256.0D);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }

        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }

        if (var16 > 0.5D) {
            this.hueMultiplier = (int) ((1.0D - var16) * var14 * 512.0D);
        } else {
            this.hueMultiplier = (int) (512.0D * var16 * var14);
        }

        if (this.hueMultiplier < 1) {
            this.hueMultiplier = 1;
        }

        this.hue = (int) ((double) this.hueMultiplier * var12);
    }

    public static String base37DecodeLong(long var0) {
        if (var0 > 0L && var0 < 6582952005840035281L) {
            if (var0 % 37L == 0L) {
                return null;
            } else {
                int var2 = 0;

                for (long var3 = var0; 0L != var3; var3 /= 37L) {
                    ++var2;
                }

                StringBuilder var5;
                char var8;
                for (var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
                    long var6 = var0;
                    var0 /= 37L;
                    var8 = class373.base37Table[(int) (var6 - var0 * 37L)];
                    if (var8 == '_') {
                        int var9 = var5.length() - 1;
                        var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                        var8 = 160;
                    }
                }

                var5.reverse();
                var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
                return var5.toString();
            }
        } else {
            return null;
        }
    }

    public static void method1050() {
        class475.midiPcmStream.clear();
        class297.musicPlayerStatus = 1;
        class297.musicTrackArchive = null;
    }
}
