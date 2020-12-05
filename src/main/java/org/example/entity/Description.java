package org.example.entity;

import org.example.entity.enums.DescriptionType;

public class Description {
    private String descriptionName;
    private DescriptionType descriptionType;

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public DescriptionType getDescriptionType() {
        return descriptionType;
    }

    public void setDescriptionType(DescriptionType descriptionType) {
        this.descriptionType = descriptionType;
    }

    public static final class DescriptionBuilder {
        private String descriptionName;
        private DescriptionType descriptionType;

        private DescriptionBuilder() {
        }

        public static DescriptionBuilder aDescription() {
            return new DescriptionBuilder();
        }

        public DescriptionBuilder descriptionName(String descriptionName) {
            this.descriptionName = descriptionName;
            return this;
        }

        public DescriptionBuilder descriptionType(DescriptionType descriptionType) {
            this.descriptionType = descriptionType;
            return this;
        }

        public Description build() {
            Description description = new Description();
            description.setDescriptionName(descriptionName);
            description.setDescriptionType(descriptionType);
            return description;
        }
    }
}
