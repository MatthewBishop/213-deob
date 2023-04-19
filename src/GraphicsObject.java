public class GraphicsObject extends Renderable {

    static boolean ClanChat_inClanChat;

    int id;

    int cycleStart;

    int plane;

    int x;

    int y;

    int z;

    SequenceDefinition sequenceDefinition;

    int frame;

    int frameCycle;

    boolean isFinished;

    GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.frame = 0;
        this.frameCycle = 0;
        this.isFinished = false;
        this.id = var1;
        this.plane = var2;
        this.x = var3;
        this.y = var4;
        this.z = var5;
        this.cycleStart = var7 + var6;
        int var8 = ItemContainer.SpotAnimationDefinition_get(this.id).sequence;
        if (var8 != -1) {
            this.isFinished = false;
            this.sequenceDefinition = ItemContainer.SequenceDefinition_get(var8);
        } else {
            this.isFinished = true;
        }

    }

    final void advance(int var1) {
        if (!this.isFinished) {
            this.frameCycle += var1;
            if (!this.sequenceDefinition.isCachedModelIdSet()) {
                while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
                    this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
                    ++this.frame;
                    if (this.frame >= this.sequenceDefinition.frameIds.length) {
                        this.isFinished = true;
                        break;
                    }
                }
            } else {
                this.frame += var1;
                if (this.frame >= this.sequenceDefinition.method1128()) {
                    this.isFinished = true;
                }
            }

        }
    }

    protected final Model getModel() {
        SpotAnimationDefinition var1 = ItemContainer.SpotAnimationDefinition_get(this.id);
        Model var2;
        if (!this.isFinished) {
            var2 = var1.getModel(this.frame);
        } else {
            var2 = var1.getModel(-1);
        }

        return var2 == null ? null : var2;
    }

    public static void method432() {
        if (MouseHandler.MouseHandler_instance != null) {
            MouseHandler var0 = MouseHandler.MouseHandler_instance;
            synchronized (MouseHandler.MouseHandler_instance) {
                MouseHandler.MouseHandler_instance = null;
            }
        }

    }

    static final void method429(long var0) {
        ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var0;
    }

    static final void method433(int var0, int var1) {
        if (var0 < 128) {
            var0 = 128;
        } else if (var0 > 383) {
            var0 = 383;
        }

        if (WorldMapSectionType.cameraPitch < var0) {
            WorldMapSectionType.cameraPitch = (var0 - WorldMapSectionType.cameraPitch) * WorldMapElement.field1503
                    / 1000 + WorldMapSectionType.cameraPitch + Archive.field3467;
            if (WorldMapSectionType.cameraPitch > var0) {
                WorldMapSectionType.cameraPitch = var0;
            }
        } else if (WorldMapSectionType.cameraPitch > var0) {
            WorldMapSectionType.cameraPitch -= (WorldMapSectionType.cameraPitch - var0) * WorldMapElement.field1503
                    / 1000 + Archive.field3467;
            if (WorldMapSectionType.cameraPitch < var0) {
                WorldMapSectionType.cameraPitch = var0;
            }
        }

        var1 &= 2047;
        int var2 = var1 - class125.cameraYaw;
        if (var2 > 1024) {
            var2 -= 2048;
        } else if (var2 < -1024) {
            var2 += 2048;
        }

        if (var2 > 0) {
            class125.cameraYaw = class125.cameraYaw + Archive.field3467 + var2 * WorldMapElement.field1503 / 1000;
            class125.cameraYaw &= 2047;
        } else if (var2 < 0) {
            class125.cameraYaw -= -var2 * WorldMapElement.field1503 / 1000 + Archive.field3467;
            class125.cameraYaw &= 2047;
        }

        int var3 = var1 - class125.cameraYaw;
        if (var3 > 1024) {
            var3 -= 2048;
        } else if (var3 < -1024) {
            var3 += 2048;
        }

        if (var3 < 0 && var2 > 0 || var3 > 0 && var2 < 0) {
            class125.cameraYaw = var1;
        }

    }

    public GraphicsObject() {
    }
}
