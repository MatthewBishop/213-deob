public final class ObjectSound extends Node {

    static NodeDeque objectSounds = new NodeDeque();

    static byte[][] regionMapArchives;

    int plane;

    int x;

    int y;

    int maxX;

    int maxY;

    int field673;

    int soundEffectId;

    RawPcmStream stream1;

    int field681;

    int field682;

    int[] soundEffectIds;

    int field679;

    RawPcmStream stream2;

    ObjectComposition obj;

    void set() {
        int var1 = this.soundEffectId;
        ObjectComposition var2 = this.obj.transform();
        if (var2 != null) {
            this.soundEffectId = var2.ambientSoundId;
            this.field673 = var2.int7 * 128;
            this.field681 = var2.int5;
            this.field682 = var2.int6;
            this.soundEffectIds = var2.soundEffectIds;
        } else {
            this.soundEffectId = -1;
            this.field673 = 0;
            this.field681 = 0;
            this.field682 = 0;
            this.soundEffectIds = null;
        }

        if (var1 != this.soundEffectId && this.stream1 != null) {
            class130.pcmStreamMixer.removeSubStream(this.stream1);
            this.stream1 = null;
        }

    }
}
