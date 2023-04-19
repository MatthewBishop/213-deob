public class SpotAnimationDefinition extends DualNode {

    static AbstractArchive SpotAnimationDefinition_archive;

    static AbstractArchive SpotAnimationDefinition_modelArchive;

    public static EvictingDualNodeHashTable SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);

    public static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);

    int id;

    int archive;

    public int sequence = -1;

    short[] recolorFrom;

    short[] recolorTo;

    short[] retextureFrom;

    short[] retextureTo;

    int widthScale = 128;

    int heightScale = 128;

    int orientation = 0;

    int ambient = 0;

    int contrast = 0;

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 1) {
            this.archive = var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.sequence = var1.readUnsignedShort();
        } else if (var2 == 4) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 5) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 6) {
            this.orientation = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.ambient = var1.readUnsignedByte();
        } else if (var2 == 8) {
            this.contrast = var1.readUnsignedByte();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.recolorFrom = new short[var3];
                this.recolorTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.recolorFrom[var4] = (short) var1.readUnsignedShort();
                    this.recolorTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.retextureFrom = new short[var3];
                this.retextureTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.retextureFrom[var4] = (short) var1.readUnsignedShort();
                    this.retextureTo[var4] = (short) var1.readUnsignedShort();
                }
            }
        }

    }

    public final Model getModel(int var1) {
        Model var2 = this.method1042();
        Model var3;
        if (this.sequence != -1 && var1 != -1) {
            var3 = ItemContainer.SequenceDefinition_get(this.sequence).method1130(var2, var1);
        } else {
            var3 = var2.method1312(true);
        }

        if (this.widthScale != 128 || this.heightScale != 128) {
            var3.scale(this.widthScale, this.heightScale, this.widthScale);
        }

        if (this.orientation != 0) {
            if (this.orientation == 90) {
                var3.rotateY90Ccw();
            }

            if (this.orientation == 180) {
                var3.rotateY90Ccw();
                var3.rotateY90Ccw();
            }

            if (this.orientation == 270) {
                var3.rotateY90Ccw();
                var3.rotateY90Ccw();
                var3.rotateY90Ccw();
            }
        }

        return var3;
    }

    public final Model method1042() {
        Model var1 = (Model) SpotAnimationDefinition_cachedModels.get((long) this.id);
        if (var1 == null) {
            ModelData var2 = ModelData.ModelData_get(SpotAnimationDefinition_modelArchive, this.archive, 0);
            if (var2 == null) {
                return null;
            }

            int var3;
            if (this.recolorFrom != null) {
                for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
                    var2.recolor(this.recolorFrom[var3], this.recolorTo[var3]);
                }
            }

            if (this.retextureFrom != null) {
                for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
                    var2.retexture(this.retextureFrom[var3], this.retextureTo[var3]);
                }
            }

            var1 = var2.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
            SpotAnimationDefinition_cachedModels.put(var1, (long) this.id);
        }

        return var1;
    }

    static PacketBufferNode method1044() {
        return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode()
                : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
    }
}
