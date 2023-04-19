public class WorldMapArchiveLoader {

    String cacheName;

    AbstractArchive archive;

    int percentLoaded = 0;

    boolean loaded = false;

    WorldMapArchiveLoader(AbstractArchive var1) {
        this.archive = var1;
    }

    void reset(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            if (var1 != this.cacheName) {
                this.cacheName = var1;
                this.percentLoaded = 0;
                this.loaded = false;
                this.load();
            }
        }
    }

    int load() {
        if (this.cacheName == null) {
            this.percentLoaded = 100;
            this.loaded = true;
        } else {
            if (this.percentLoaded < 33) {
                if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field2439.name, this.cacheName)) {
                    return this.percentLoaded;
                }

                this.percentLoaded = 33;
            }

            if (this.percentLoaded == 33) {
                if (this.archive.isValidFileName(WorldMapCacheName.field2436.name, this.cacheName)
                        && !this.archive.tryLoadFileByNames(WorldMapCacheName.field2436.name, this.cacheName)) {
                    return this.percentLoaded;
                }

                this.percentLoaded = 66;
            }

            if (this.percentLoaded == 66) {
                if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field2434.name)) {
                    return this.percentLoaded;
                }

                this.percentLoaded = 100;
                this.loaded = true;
            }
        }

        return this.percentLoaded;
    }

    boolean isLoaded() {
        return this.loaded;
    }

    int getPercentLoaded() {
        return this.percentLoaded;
    }
}
