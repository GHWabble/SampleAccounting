package ru.dt.lab.domain;

import java.time.Instant;

public final class Seal {
    // Уникальный номер пломбы. Программа назначает сама.
    public long id;

    // К какому образцу относится (id образца).
    // Должен ссылаться на реально существующий Sample.

    public long sampleId;

    // Номер пломбы (например "SEAL-9911"). Нельзя пустое. До 64 символов.
    public String sealNumber;

    // Статус пломбы: ACTIVE или BROKEN.
    public SealStatus status;

    // Кто поставил пломбу (логин). На ранних этапах можно "SYSTEM".
    public String ownerUsername;

    // Когда поставили. Программа ставит автоматически.
    public Instant createdAt;

    // Когда изменяли (например, ломали). Программа обновляет автоматически.
    public Instant updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Seal seal = (Seal) o;
        return id == seal.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}