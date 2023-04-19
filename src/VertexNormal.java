public class VertexNormal {

    int x;

    int y;

    int z;

    int magnitude;

    VertexNormal() {
    }

    VertexNormal(VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    static int method1346(int var0) {
        return (int) Math.pow(2.0D, (double) ((float) var0 / 256.0F + 7.0F));
    }
}
