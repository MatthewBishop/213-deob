public class class244 {

    static java.awt.Font fontHelvetica13;

    public static String method1393(long var0) {
        if (var0 > 0L && var0 < 6582952005840035281L) {
            if (0L == var0 % 37L) {
                return null;
            } else {
                int var2 = 0;

                for (long var3 = var0; var3 != 0L; var3 /= 37L) {
                    ++var2;
                }

                StringBuilder var5 = new StringBuilder(var2);

                while (var0 != 0L) {
                    long var6 = var0;
                    var0 /= 37L;
                    var5.append(class373.base37Table[(int) (var6 - var0 * 37L)]);
                }

                return var5.reverse().toString();
            }
        } else {
            return null;
        }
    }

    static int method1391(int var0, Script var1, boolean var2) {
        Widget var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
        if (var0 == 1500) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
            return 1;
        } else if (var0 == 1501) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
            return 1;
        } else if (var0 == 1502) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
            return 1;
        } else if (var0 == 1503) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
            return 1;
        } else if (var0 == 1504) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
            return 1;
        } else if (var0 == 1505) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
            return 1;
        } else {
            return 2;
        }
    }

    static void method1392(int var0) {
        Client.oculusOrbState = var0;
    }
}
