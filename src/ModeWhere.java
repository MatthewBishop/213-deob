import java.util.HashSet;
import java.util.Set;

public enum ModeWhere implements class356 {

    field3573("", 0, new class355[] { class355.field3539 }),

    field3558("", 1, new class355[] { class355.field3540, class355.field3539 }),

    field3559("", 2, new class355[] { class355.field3540, class355.field3541, class355.field3539 }),

    field3568("", 3, new class355[] { class355.field3540 }),

    field3561("", 4),

    field3564("", 5, new class355[] { class355.field3540, class355.field3539 }),

    field3557("", 6, new class355[] { class355.field3539 }),

    field3560("", 8, new class355[] { class355.field3540, class355.field3539 }),

    field3565("", 9, new class355[] { class355.field3540, class355.field3541 }),

    field3566("", 10, new class355[] { class355.field3540 }),

    field3567("", 11, new class355[] { class355.field3540 }),

    field3572("", 12, new class355[] { class355.field3540, class355.field3539 }),

    field3562("", 13, new class355[] { class355.field3540 });

    public static String operatingSystemName;

    static String field3571;

    final int id;

    final Set field3570 = new HashSet();

    static {
        $values();
    }

    ModeWhere(String var3, int var4, class355[] var5) {
        this.id = var4;
        class355[] var6 = var5;

        for (int var7 = 0; var7 < var6.length; ++var7) {
            class355 var8 = var6[var7];
            this.field3570.add(var8);
        }

    }

    ModeWhere(String var3, int var4) {
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    static ModeWhere[] $values() {
        return new ModeWhere[] { field3557, field3565, field3564, field3573, field3568, field3567, field3558, field3572,
                field3560, field3559, field3561, field3562, field3566 };
    }

    static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
        if (var0.field2954 == null) {
            throw new RuntimeException();
        } else {
            if (var0.field2952 == null) {
                var0.field2952 = new int[var0.field2954.length];
            }

            var0.field2952[var1] = Integer.MAX_VALUE;
        }
    }

    static String method1953(String var0) {
        PlayerType[] var1 = StudioGame.PlayerType_values();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            PlayerType var3 = var1[var2];
            if (var3.modIcon != -1 && var0.startsWith(ArchiveDiskActionHandler.addImageTag(var3.modIcon))) {
                var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
                break;
            }
        }

        return var0;
    }
}
