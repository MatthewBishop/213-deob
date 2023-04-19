public class class161 extends class139 {

    static int[][][] field1407;

    long field1408;

    String field1406;
    // $FF: synthetic field

    final class142 this$0;

    class161(class142 var1) {
        this.this$0 = var1;
        this.field1408 = -1L;
        this.field1406 = null;
    }

    void vmethod3254(Buffer var1) {
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            this.field1408 = var1.readLong();
        }

        this.field1406 = var1.readStringCp1252NullTerminatedOrNull();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method857(this.field1408, this.field1406);
    }

    static int method907(int var0, byte var1, byte var2, byte var3, byte var4) {
        int var5 = var0 >> 10 & 63;
        int var6 = var0 >> 7 & 7;
        int var7 = var0 & 127;
        int var8 = var4 & 255;
        if (var1 != -1) {
            var5 += var8 * (var1 - var5) >> 7;
        }

        if (var2 != -1) {
            var6 += var8 * (var2 - var6) >> 7;
        }

        if (var3 != -1) {
            var7 += var8 * (var3 - var7) >> 7;
        }

        return (var5 << 10 | var6 << 7 | var7) & '\uffff';
    }

    static void method908(int var0, int var1, int var2) {
        if (var0 != 0) {
            int var3 = var0 >> 8;
            int var4 = var0 >> 4 & 7;
            int var5 = var0 & 15;
            Client.soundEffectIds[Client.soundEffectCount] = var3;
            Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
            Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
            Client.soundEffects[Client.soundEffectCount] = null;
            int var6 = (var1 - 64) / 128;
            int var7 = (var2 - 64) / 128;
            Client.soundLocations[Client.soundEffectCount] = var5 + (var7 << 8) + (var6 << 16);
            ++Client.soundEffectCount;
        }
    }
}
