import java.util.Comparator;

public class UserComparator4 implements Comparator {

    static int[] Tiles_hueMultiplier;

    final boolean reversed;

    public UserComparator4(boolean var1) {
        this.reversed = var1;
    }

    int compare_bridged(Buddy var1, Buddy var2) {
        return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((Buddy) var1, (Buddy) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public static class3 method684(class6 var0) {
        switch (var0.field10) {
        case 0:
            return new class0();
        default:
            throw new IllegalArgumentException();
        }
    }

    static AttackOption[] method685() {
        return new AttackOption[] { AttackOption.field1073, AttackOption.AttackOption_dependsOnCombatLevels,
                AttackOption.AttackOption_alwaysRightClick, AttackOption.field1070, AttackOption.AttackOption_hidden };
    }

    static int method683(int var0, Script var1, boolean var2) {
        if (var0 == 5306) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize
                    - 1] = GrandExchangeOfferNameComparator.getWindowedMode();
            return 1;
        } else {
            int var3;
            if (var0 == 5307) {
                var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                if (var3 == 1 || var3 == 2) {
                    Decimator.setWindowedMode(var3);
                }

                return 1;
            } else if (var0 == 5308) {
                Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class20.clientPreferences
                        .method577();
                return 1;
            } else if (var0 != 5309) {
                if (var0 == 5310) {
                    --Interpreter.Interpreter_intStackSize;
                    return 1;
                } else {
                    return 2;
                }
            } else {
                var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                if (var3 == 1 || var3 == 2) {
                    class20.clientPreferences.method576(var3);
                }

                return 1;
            }
        }
    }

    static void method681(Buffer var0, int var1) {
        byte[] var2 = var0.array;
        if (Client.randomDatData == null) {
            Client.randomDatData = new byte[24];
        }

        class384.writeRandomDat(var2, var1, Client.randomDatData, 0, 24);
        ObjTypeCustomisation.method972(var0, var1);
    }
}
