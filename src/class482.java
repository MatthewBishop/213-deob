import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class class482 extends DualNode {

    class478[] field4038;

    List field4037;

    public class482(AbstractArchive var1, int var2) {
        byte[] var3 = var1.takeFile(var2, 0);
        this.method2447(new Buffer(var3));
    }

    public class482(AbstractArchive var1, int var2, int var3) {
        byte[] var4 = var1.takeFile(var2, var3 + 1);
        this.method2447(new Buffer(var4));
    }

    void method2447(Buffer var1) {
        int var2 = var1.method2493();
        this.field4038 = new class478[var2];
        this.field4037 = new ArrayList(var2);

        for (int var3 = 0; var3 < var2; ++var3) {
            this.field4038[var3] = (class478) StructComposition.findEnumerated(class478.method2432(),
                    var1.readUnsignedByte());
            int var4 = var1.method2493();
            HashMap var5 = new HashMap(var4);

            while (var4-- > 0) {
                Object var6 = this.field4038[var3].method2435(var1);
                int var7 = var1.method2493();
                ArrayList var8 = new ArrayList();

                while (var7-- > 0) {
                    int var9 = var1.method2493();
                    var8.add(var9);
                }

                var5.put(var6, var8);
            }

            this.field4037.add(var3, var5);
        }

    }

    public List method2448(Object var1, int var2) {
        if (var2 < 0) {
            var2 = 0;
        }

        Map var3 = (Map) this.field4037.get(var2);
        return (List) var3.get(var1);
    }
}
