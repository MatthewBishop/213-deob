public class HealthBar extends Node {

    static IndexedSprite[] scrollBarSprites;

    HealthBarDefinition definition;

    IterableNodeDeque updates = new IterableNodeDeque();

    HealthBar(HealthBarDefinition var1) {
        this.definition = var1;
    }

    void put(int var1, int var2, int var3, int var4) {
        HealthBarUpdate var5 = null;
        int var6 = 0;

        for (HealthBarUpdate var7 = (HealthBarUpdate) this.updates
                .last(); var7 != null; var7 = (HealthBarUpdate) this.updates.previous()) {
            ++var6;
            if (var7.cycle == var1) {
                var7.set(var1, var2, var3, var4);
                return;
            }

            if (var7.cycle <= var1) {
                var5 = var7;
            }
        }

        if (var5 == null) {
            if (var6 < 4) {
                this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
            }

        } else {
            IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5);
            if (var6 >= 4) {
                this.updates.last().remove();
            }

        }
    }

    HealthBarUpdate get(int var1) {
        HealthBarUpdate var2 = (HealthBarUpdate) this.updates.last();
        if (var2 != null && var2.cycle <= var1) {
            for (HealthBarUpdate var3 = (HealthBarUpdate) this.updates.previous(); var3 != null
                    && var3.cycle <= var1; var3 = (HealthBarUpdate) this.updates.previous()) {
                var2.remove();
                var2 = var3;
            }

            if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) {
                return var2;
            } else {
                var2.remove();
                return null;
            }
        } else {
            return null;
        }
    }

    boolean isEmpty() {
        return this.updates.method1971();
    }
}
