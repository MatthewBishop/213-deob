public final class class4 {

    static int field6;

    static byte[][] regionLandArchives;

    static class330[] method7() {
        return new class330[] { class330.field3071, class330.field3072 };
    }

    public static void method10(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2,
            AbstractArchive var3) {
        int var4 = 0;
        if (var0 != null) {
            UserComparator3.Widget_archive = var0;
            DynamicObject.field813 = var1;
            ScriptEvent.Widget_spritesArchive = var2;
            class146.Widget_fontsArchive = var3;
            var4 = UserComparator3.Widget_archive.getGroupCount();
        }

        VerticalAlignment.Widget_interfaceComponents = new Widget[var4][];
        class264.Widget_loadedInterfaces = new boolean[var4];
    }

    public static boolean method8() {
        return class297.musicPlayerStatus != 0 ? true : class475.midiPcmStream.isReady();
    }

    public static void method9() {
        KitDefinition.KitDefinition_cached.clear();
    }

    static int method11(Widget var0) {
        if (var0.type != 11) {
            Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            return 1;
        } else {
            String var1 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var0
                    .method1809(var1);
            return 1;
        }
    }
}
