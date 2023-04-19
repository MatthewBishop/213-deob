public class ScriptEvent extends Node {

    static int field851;

    static AbstractArchive Widget_spritesArchive;

    Object[] args;

    boolean field849;

    Widget widget;

    int mouseX;

    int mouseY;

    int opIndex;

    Widget dragTarget;

    int keyTyped;

    int keyPressed;

    String targetName;

    int field859;

    int type = 76;

    public void setArgs(Object[] var1) {
        this.args = var1;
    }

    public void setType(int var1) {
        this.type = var1;
    }

    public void method491(Widget var1) {
        this.widget = var1;
    }

    public static boolean method492(int var0) {
        return (var0 >> 21 & 1) != 0;
    }

    static Object method489(int var0) {
        return Language.method1948((class478) StructComposition.findEnumerated(class478.method2432(), var0));
    }
}
