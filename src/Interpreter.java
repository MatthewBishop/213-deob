import java.util.ArrayList;

public class Interpreter {

    static int[] Interpreter_intLocals;

    static String[] Interpreter_stringLocals;

    static int[] Interpreter_arrayLengths = new int[5];

    static int[][] Interpreter_arrays = new int[5][5000];

    static int[] Interpreter_intStack = new int[1000];

    static int Interpreter_intStackSize;

    static String[] Interpreter_stringStack = new String[1000];

    static int Interpreter_frameDepth = 0;

    static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];

    static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();

    static final String[] Interpreter_MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec" };

    static boolean field700 = false;

    static boolean field704 = false;

    static ArrayList field690 = new ArrayList();

    static int field703 = 0;

    static final double field702 = Math.log(2.0D);

    public static void method427(AbstractArchive var0, AbstractArchive var1, boolean var2) {
        ObjectComposition.ObjectDefinition_archive = var0;
        class157.ObjectDefinition_modelsArchive = var1;
        ObjectComposition.ObjectDefinition_isLowDetail = var2;
    }

    static World getNextWorldListWorld() {
        return World.World_listCount < World.World_count ? class31.World_worlds[++World.World_listCount - 1] : null;
    }
}
