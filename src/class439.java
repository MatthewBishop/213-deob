public class class439 {

    static final int[] field3829 = new int[16384];

    static final int[] field3830 = new int[16384];

    static IndexedSprite field3828;

    static {
        double var0 = 3.834951969714103E-4D;

        for (int var2 = 0; var2 < 16384; ++var2) {
            field3829[var2] = (int) (16384.0D * Math.sin(var0 * (double) var2));
            field3830[var2] = (int) (16384.0D * Math.cos(var0 * (double) var2));
        }

    }
}
