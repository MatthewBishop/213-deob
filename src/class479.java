final class class479 implements class474 {

    public void vmethod8274(Object var1, Buffer var2) {
        this.method2443((String) var1, var2);
    }

    public Object vmethod8273(Buffer var1) {
        return var1.readStringCp1252NullTerminated();
    }

    void method2443(String var1, Buffer var2) {
        var2.writeStringCp1252NullTerminated(var1);
    }
}
