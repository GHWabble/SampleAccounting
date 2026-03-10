package ru.dt.lab.domain;

import java.time.Instant;

public final class Sample {
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
            if(!name.isEmpty() && name.length() < 128) {
                this.name = name;
            } else{
                throw new IllegalArgumentException();
            }
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            if(!type.isEmpty() && type.length() < 64) {
                this.type = type;
            } else{
                throw new IllegalArgumentException();
            }
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            if(!location.isEmpty() && location.length() < 64) {
                this.location = location;
            }
            else{
                throw new IllegalArgumentException();
            }
        }

        public SampleHoldStatus getStatus() {
            return status;
        }

        public void setStatus(SampleHoldStatus status) {
            if (status == SampleHoldStatus.ACTIVE) {
                this.status = status;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public String getOwnerUsername() {
            return ownerUsername;
        }

        public void setOwnerUsername(String ownerUsername) {
            if (ownerUsername.isEmpty()){
                this.ownerUsername = ownerUsername;
            }
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
