import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class class166 {

    int field1419 = -1;

    String field1420;

    UrlRequest field1418;

    String field1421 = null;

    float[] field1422 = new float[4];

    ArrayList field1423 = new ArrayList();

    ArrayList field1424 = new ArrayList();

    ArrayList field1425 = new ArrayList();

    Map field1426 = new HashMap();

    Map field1417 = new HashMap();

    public boolean method924(String var1, UrlRequester var2) {
        if (var1 != null && !var1.isEmpty()) {
            if (var2 == null) {
                return false;
            } else {
                this.method932();

                try {
                    this.field1420 = var1;
                    this.field1418 = var2.request(new URL(this.field1420));
                    this.field1419 = 0;
                    return true;
                } catch (MalformedURLException var4) {
                    this.method932();
                    this.field1419 = 100;
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public void method925(UrlRequester var1) {
        switch (this.field1419) {
        case 0:
            this.method943(var1);
            break;
        case 1:
            this.method928();
            break;
        default:
            return;
        }

    }

    public int method926() {
        return this.field1419;
    }

    public int method933(String var1) {
        return this.field1426.containsKey(var1) ? (Integer) this.field1426.get(var1) : -1;
    }

    public String method927(String var1) {
        return (String) ((String) (this.field1417.containsKey(var1) ? this.field1417.get(var1) : null));
    }

    public ArrayList method929() {
        return this.field1424;
    }

    public ArrayList method942() {
        return this.field1425;
    }

    public String method940() {
        return this.field1421;
    }

    public float[] method930() {
        return this.field1422;
    }

    public ArrayList method931() {
        return this.field1423;
    }

    void method932() {
        this.field1418 = null;
        this.field1421 = null;
        this.field1422[0] = 0.0F;
        this.field1422[1] = 0.0F;
        this.field1422[2] = 1.0F;
        this.field1422[3] = 1.0F;
        this.field1423.clear();
        this.field1424.clear();
        this.field1425.clear();
        this.field1426.clear();
        this.field1417.clear();
    }

    void method943(UrlRequester var1) {
        if (this.field1418 != null && this.field1418.isDone()) {
            byte[] var2 = this.field1418.getResponse();
            if (var2 == null) {
                this.method932();
                this.field1419 = 100;
            } else {
                try {
                    this.method937(new class437(var2), var1);
                } catch (UnsupportedEncodingException var4) {
                    this.method932();
                    this.field1419 = 102;
                    return;
                }

                this.field1419 = this.field1424.size() > 0 ? 1 : 2;
                this.field1418 = null;
            }
        }
    }

    void method928() {
        Iterator var1 = this.field1424.iterator();

        class172 var2;
        do {
            if (!var1.hasNext()) {
                var1 = this.field1424.iterator();

                while (var1.hasNext()) {
                    var2 = (class172) var1.next();
                    if (var2.field1445 != null) {
                        byte[] var3 = var2.field1445.getResponse();
                        if (var3 != null && var3.length > 0) {
                            this.field1419 = 2;
                            return;
                        }
                    }
                }

                this.method932();
                this.field1419 = 101;
                return;
            }

            var2 = (class172) var1.next();
        } while (var2.field1445 == null || var2.field1445.isDone());

    }

    void method934(JSONArray var1, UrlRequester var2) throws JSONException {
        if (var1 != null) {
            for (int var3 = 0; var3 < var1.length(); ++var3) {
                try {
                    JSONObject var4 = var1.getJSONObject(var3);
                    class172 var5 = new class172(this);
                    var5.field1445 = var2.request(new URL(var4.getString("src")));
                    var5.field1444 = UserComparator8.method686(var4, "placement");
                    this.field1424.add(var5);
                } catch (MalformedURLException var6) {
                    ;
                }
            }

        }
    }

    void method935(JSONArray var1) throws JSONException {
        if (var1 != null) {
            for (int var2 = 0; var2 < var1.length(); ++var2) {
                JSONObject var3 = var1.getJSONObject(var2);
                class173 var4 = new class173(this);
                var4.field1447 = var3.getString("text");
                String var7 = var3.getString("align_x");
                byte var6;
                if (var7.equals("centre")) {
                    var6 = 1;
                } else if (!var7.equals("bottom") && !var7.equals("right")) {
                    var6 = 0;
                } else {
                    var6 = 2;
                }

                var4.field1449 = var6;
                String var10 = var3.getString("align_y");
                byte var9;
                if (var10.equals("centre")) {
                    var9 = 1;
                } else if (!var10.equals("bottom") && !var10.equals("right")) {
                    var9 = 0;
                } else {
                    var9 = 2;
                }

                var4.field1450 = var9;
                var4.field1446 = var3.getInt("font");
                var4.field1448 = UserComparator8.method686(var3, "placement");
                this.field1425.add(var4);
            }

        }
    }

    void method936(JSONObject var1) throws JSONException {
        if (var1 != null) {
            this.field1422 = UserComparator8.method686(var1, "clickbounds");
            this.field1421 = var1.getString("endpoint");
            String[] var2 = JSONObject.getNames(var1);

            for (int var3 = 0; var3 < var1.length(); ++var3) {
                if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
                    try {
                        int var4 = var1.getInt(var2[var3]);
                        this.field1423.add(new class174(this, var2[var3], var4));
                    } catch (Exception var8) {
                        try {
                            String var5 = var1.getString(var2[var3]);
                            if (var5.equals("true")) {
                                this.field1423.add(new class174(this, var2[var3], 1));
                            } else if (var5.equals("false")) {
                                this.field1423.add(new class174(this, var2[var3], 0));
                            } else {
                                this.field1423.add(new class165(this, var2[var3], var5));
                            }
                        } catch (Exception var7) {
                            ;
                        }
                    }
                }
            }

        }
    }

    void method941(JSONObject var1) throws JSONException {
        String[] var2 = JSONObject.getNames(var1);

        for (int var3 = 0; var3 < var1.length(); ++var3) {
            try {
                int var4 = var1.getInt(var2[var3]);
                this.field1426.put(var2[var3], var4);
            } catch (Exception var8) {
                try {
                    String var5 = var1.getString(var2[var3]);
                    if (var5.equals("true")) {
                        this.field1426.put(var2[var3], 1);
                    } else if (var5.equals("false")) {
                        this.field1426.put(var2[var3], 0);
                    } else {
                        this.field1417.put(var2[var3], var5);
                    }
                } catch (Exception var7) {
                    ;
                }
            }
        }

    }

    void method937(class437 var1, UrlRequester var2) {
        JSONObject var3;
        try {
            var3 = var1.method2292();
            var3 = var3.getJSONObject("message");
        } catch (Exception var9) {
            this.method932();
            this.field1419 = 102;
            return;
        }

        try {
            this.method934(var3.getJSONArray("images"), var2);
        } catch (Exception var8) {
            this.field1424.clear();
        }

        try {
            this.method935(var3.getJSONArray("labels"));
        } catch (Exception var7) {
            this.field1425.clear();
        }

        try {
            this.method936(var3.getJSONObject("behaviour"));
        } catch (Exception var6) {
            this.field1421 = null;
            this.field1422[0] = 0.0F;
            this.field1422[1] = 0.0F;
            this.field1422[2] = 1.0F;
            this.field1422[3] = 1.0F;
            this.field1423.clear();
        }

        try {
            this.method941(var3.getJSONObject("meta"));
        } catch (Exception var5) {
            this.field1426.clear();
            this.field1417.clear();
        }

    }

    public boolean method938(String var1, UrlRequester var2) {
        try {
            this.method937(new class437(var1.getBytes()), var2);
            this.field1419 = this.field1424.size() > 0 ? 1 : 2;
        } catch (UnsupportedEncodingException var4) {
            this.field1419 = 102;
        }

        return this.field1419 < 100;
    }

    static void Widget_runOnTargetLeave() {
        if (Client.isSpellSelected) {
            Widget var0 = SoundSystem.getWidgetChild(Clips.selectedSpellWidget, Client.selectedSpellChildIndex);
            if (var0 != null && var0.onTargetLeave != null) {
                ScriptEvent var1 = new ScriptEvent();
                var1.widget = var0;
                var1.args = var0.onTargetLeave;
                HealthBarUpdate.runScriptEvent(var1);
            }

            Client.selectedSpellItemId = -1;
            Client.isSpellSelected = false;
            class144.invalidateWidget(var0);
        }
    }

    static final void method944(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (Client.field437) {
            Client.alternativeScrollbarWidth = 32;
        } else {
            Client.alternativeScrollbarWidth = 0;
        }

        Client.field437 = false;
        int var7;
        if (MouseHandler.MouseHandler_currentButton == 1
                || !class473.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
            if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
                var0.scrollY -= 4;
                class144.invalidateWidget(var0);
            } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
                var0.scrollY += 4;
                class144.invalidateWidget(var0);
            } else if (var5 >= var1 - Client.alternativeScrollbarWidth
                    && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16
                    && var6 < var3 + var2 - 16) {
                var7 = var3 * (var3 - 32) / var4;
                if (var7 < 8) {
                    var7 = 8;
                }

                int var8 = var6 - var2 - 16 - var7 / 2;
                int var9 = var3 - 32 - var7;
                var0.scrollY = var8 * (var4 - var3) / var9;
                class144.invalidateWidget(var0);
                Client.field437 = true;
            }
        }

        if (Client.mouseWheelRotation != 0) {
            var7 = var0.width;
            if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
                var0.scrollY += Client.mouseWheelRotation * 45;
                class144.invalidateWidget(var0);
            }
        }

    }
}
