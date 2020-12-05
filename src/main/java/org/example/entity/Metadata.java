package org.example.entity;

import org.example.entity.enums.MetadataType;

public class Metadata {
    private String metadataName;
    private MetadataType metadataType;

    public String getMetadataName() {
        return metadataName;
    }

    public void setMetadataName(String metadataName) {
        this.metadataName = metadataName;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }

    public void setMetadataType(MetadataType metadataType) {
        this.metadataType = metadataType;
    }

    public static final class MetadataBuilder {
        private String metadataName;
        private MetadataType metadataType;

        private MetadataBuilder() {
        }

        public static MetadataBuilder aMetadata() {
            return new MetadataBuilder();
        }

        public MetadataBuilder metadataName(String metadataName) {
            this.metadataName = metadataName;
            return this;
        }

        public MetadataBuilder metadataType(MetadataType metadataType) {
            this.metadataType = metadataType;
            return this;
        }

        public Metadata build() {
            Metadata metadata = new Metadata();
            metadata.setMetadataName(metadataName);
            metadata.setMetadataType(metadataType);
            return metadata;
        }
    }
}
