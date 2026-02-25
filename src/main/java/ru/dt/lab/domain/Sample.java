package ru.dt.lab.domain;

import java.time.Instant;

public final class Sample {
    // Уникальный номер образца. Программа назначает сама.
    public long id;

    // Название образца. Нельзя пустое. Желательно до 128 символов.
    public String name;

    // Тип образца (например: "water", "soil", "solution"). Нельзя пустое. До 64 символов.
    public String type;

    // Где лежит/хранится (например: "Shelf-A3", "Fridge-2"). Нельзя пустое. До 64 символов.
    public String location;

    // Статус: ACTIVE или ARCHIVED.
    // Если ARCHIVED — нельзя добавлять новые измерения (можно только смотреть).
    public SampleHoldStatus status;

    // Владелец (логин пользователя). На ранних этапах можно хранить "SYSTEM".
    // Не должен быть пустым.
    public String ownerUsername;

    // Когда создан. Программа ставит автоматически.
    public Instant createdAt;

    // Когда последний раз изменяли (например location/name/status). Программа обновляет автоматически.
    public Instant updatedAt;

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