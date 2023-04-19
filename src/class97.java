public class class97 {

    public static int[] SpriteBuffer_spriteWidths;

    int field1069;

    int field1066;

    int field1067;

    int field1065;

    class97(int var1, int var2, int var3, int var4) {
        this.field1069 = var1;
        this.field1066 = var2;
        this.field1067 = var3;
        this.field1065 = var4;
    }

    int method615() {
        return this.field1069;
    }

    int method613() {
        return this.field1066;
    }

    int method614() {
        return this.field1067;
    }

    int method616() {
        return this.field1065;
    }

    static int method617(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        } else if (var0 == -1) {
            if (var1 < 0) {
                var1 = 0;
            } else if (var1 > 127) {
                var1 = 127;
            }

            var1 = 127 - var1;
            return var1;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 'ﾀ') + var1;
        }
    }
}
