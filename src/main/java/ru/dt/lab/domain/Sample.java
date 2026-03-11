package ru.dt.lab.domain;

import java.time.Instant;

public final class Sample {

    private void validateString(String value, int maxLength, String fieldName) {
        if (value == null || value.isEmpty() || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " недействителен :(");
        }
    }

        // Уникальный номер образца. Программа назначает сама.
        private final long id;

        // Название образца. Нельзя пустое. Желательно до 128 символов.
        private String name;

        // Тип образца (например: "water", "soil", "solution"). Нельзя пустое. До 64 символов.
        private String type;

        // Где лежит/хранится (например: "Shelf-A3", "Fridge-2"). Нельзя пустое. До 64 символов.
        private String location;

        // Статус: ACTIVE или ARCHIVED.
        // Если ARCHIVED — нельзя добавлять новые измерения (можно только смотреть).
        private SampleHoldStatus status;

        // Владелец (логин пользователя). На ранних этапах можно хранить "SYSTEM".
        // Не должен быть пустым.
        private String ownerUsername;

        // Когда создан. Программа ставит автоматически.
        private final Instant createdAt;

        // Когда последний раз изменяли (например location/name/status). Программа обновляет автоматически.
        private Instant updatedAt;

        public Sample(long id, String name, String type, String location, SampleHoldStatus status, String ownerUsername, Instant createdAt,Instant updatedAt){
            this.id = id;
            setName(name);
            setType(type);
            setLocation(location);
            setStatus(status);
            setOwnerUsername(ownerUsername);
            this.createdAt = createdAt;
            setUpdatedAt(updatedAt);
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            validateString(name, 128, "Name");
            this.name = name;
            this.updatedAt = Instant.now();
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            validateString(type, 64, "Type");
            this.type = type;
            this.updatedAt = Instant.now();
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            validateString(location, 64, "Location");
            this.location = location;
            this.updatedAt = Instant.now();
        }

        public SampleHoldStatus getStatus() {
            return status;
        }

        public void setStatus(SampleHoldStatus status) {
            this.status = status;
            this.updatedAt = Instant.now();
        }

        public String getOwnerUsername() {
            return ownerUsername;
        }

        public void setOwnerUsername(String ownerUsername) {
            validateString(ownerUsername, 64, "ownerUsername");
            this.ownerUsername = ownerUsername;
            this.updatedAt = Instant.now();
        }

        public Instant getCreatedAt() {
            return createdAt;
        }

        public Instant getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Instant updatedAt) {
                this.updatedAt = updatedAt;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            Sample sample = (Sample) o;
            return id == sample.id;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(id);
        }
}
