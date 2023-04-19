import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

public class class394 {

    public static int[] SpriteBuffer_spritePalette;

    final Map field3683 = new HashMap();

    final Map field3685 = new HashMap();

    final DecimalFormat field3686 = new DecimalFormat();

    public class394() {
        this.field3686.setMaximumFractionDigits(2);
    }

    public void method2104(HttpsURLConnection var1) {
        Iterator var2 = this.field3683.entrySet().iterator();

        while (var2.hasNext()) {
            Entry var3 = (Entry) var2.next();
            var1.setRequestProperty((String) var3.getKey(), (String) var3.getValue());
        }

    }

    public Map method2105() {
        return this.field3683;
    }

    public void method2106(String var1, String var2) {
        if (var1 != null && !var1.isEmpty()) {
            this.field3683.put(var1, var2 != null ? var2 : "");
        }

    }

    public void method2115(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            this.field3683.remove(var1);
        }

    }

    void method2107(class393 var1, String var2) {
        String var3 = String.format("%s %s", var1.method2102(), var2);
        this.method2106("Authorization", var3);
    }

    public void method2114(String var1) {
        this.method2107(class393.field3681, var1);
    }

    public void method2108(String var1) {
        this.method2107(class393.field3680, var1);
    }

    public void method2109(class435 var1) {
        this.field3683.put("Content-Type", var1.method2287());
    }

    public void method2110() {
        this.field3683.remove("Content-Type");
    }

    public void method2111(class435 var1) {
        this.method2112(var1, 1.0F);
    }

    void method2112(class435 var1, float var2) {
        this.field3685.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
        this.method2113();
    }

    void method2113() {
        this.field3683.remove("Accept");
        if (!this.field3685.isEmpty()) {
            this.field3683.put("Accept", this.method2116());
        }

    }

    String method2116() {
        ArrayList var1 = new ArrayList(this.field3685.entrySet());
        Collections.sort(var1, new class395(this));
        StringBuilder var2 = new StringBuilder();
        Iterator var3 = var1.iterator();

        while (var3.hasNext()) {
            Entry var4 = (Entry) var3.next();
            if (var2.length() > 0) {
                var2.append(",");
            }

            var2.append(((class435) var4.getKey()).method2287());
            float var5 = (Float) var4.getValue();
            if (var5 < 1.0F) {
                String var6 = this.field3686.format((double) var5);
                var2.append(";q=").append(var6);
            }
        }

        return var2.toString();
    }

    static void method2117(Component var0) {
        var0.addMouseListener(MouseHandler.MouseHandler_instance);
        var0.addMouseMotionListener(MouseHandler.MouseHandler_instance);
        var0.addFocusListener(MouseHandler.MouseHandler_instance);
    }
}
