public class class195 extends DualNode {

    static Archive field1645;

    static {
        new EvictingDualNodeHashTable(64);
    }

    public static void method1052(AbstractArchive var0) {
        ParamComposition.ParamDefinition_archive = var0;
    }

    public static int Widget_unpackTargetMask(int var0) {
        return var0 >> 11 & 63;
    }

    public static StructComposition StructDefinition_getStructDefinition(int var0) {
        StructComposition var1 = (StructComposition) StructComposition.StructDefinition_cached.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = StructComposition.StructDefinition_archive.takeFile(34, var0);
            var1 = new StructComposition();
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            var1.postDecode();
            StructComposition.StructDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }

    static final boolean method1053(int var0, int var1) {
        ObjectComposition var2 = class144.getObjectDefinition(var0);
        if (var1 == 11) {
            var1 = 10;
        }

        if (var1 >= 5 && var1 <= 8) {
            var1 = 4;
        }

        return var2.method1085(var1);
    }
}
