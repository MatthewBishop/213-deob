public class ItemContainer extends Node {

    static NodeHashTable itemContainers = new NodeHashTable(32);

    static int currentPort;

    static boolean field844;

    int[] ids = new int[] { -1 };

    int[] quantities = new int[] { 0 };

    public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
        SpotAnimationDefinition var1 = (SpotAnimationDefinition) SpotAnimationDefinition.SpotAnimationDefinition_cached
                .get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
            var1 = new SpotAnimationDefinition();
            var1.id = var0;
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }

    public static SequenceDefinition SequenceDefinition_get(int var0) {
        SequenceDefinition var1 = (SequenceDefinition) SequenceDefinition.SequenceDefinition_cached.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
            var1 = new SequenceDefinition();
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            var1.postDecode();
            SequenceDefinition.SequenceDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }

    static final String method480(int var0, int var1) {
        int var2 = var1 - var0;
        if (var2 < -9) {
            return class383.colorStartTag(16711680);
        } else if (var2 < -6) {
            return class383.colorStartTag(16723968);
        } else if (var2 < -3) {
            return class383.colorStartTag(16740352);
        } else if (var2 < 0) {
            return class383.colorStartTag(16756736);
        } else if (var2 > 9) {
            return class383.colorStartTag(65280);
        } else if (var2 > 6) {
            return class383.colorStartTag(4259584);
        } else if (var2 > 3) {
            return class383.colorStartTag(8453888);
        } else {
            return var2 > 0 ? class383.colorStartTag(12648192) : class383.colorStartTag(16776960);
        }
    }
}
