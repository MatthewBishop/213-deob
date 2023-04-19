public class Script extends DualNode {

    static EvictingDualNodeHashTable Script_cached = new EvictingDualNodeHashTable(128);

    public static NetFileRequest NetCache_currentResponse;

    String field794;

    int[] opcodes;

    int[] intOperands;

    String[] stringOperands;

    int localIntCount;

    int localStringCount;

    int intArgumentCount;

    int stringArgumentCount;

    IterableNodeHashTable[] switches;

    IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
        return new IterableNodeHashTable[var1];
    }

    public static int method460(int var0, int var1) {
        int var2;
        for (var2 = 1; var1 > 1; var1 >>= 1) {
            if ((var1 & 1) != 0) {
                var2 = var0 * var2;
            }

            var0 *= var0;
        }

        if (var1 == 1) {
            return var0 * var2;
        } else {
            return var2;
        }
    }
}
