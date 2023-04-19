final class class475 implements class474 {

    public static MidiPcmStream midiPcmStream;

    public void vmethod8274(Object var1, Buffer var2) {
        this.method2424((Integer) var1, var2);
    }

    public Object vmethod8273(Buffer var1) {
        return var1.readInt();
    }

    void method2424(Integer var1, Buffer var2) {
        var2.writeInt(var1);
    }
}
