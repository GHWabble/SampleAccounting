package ru.dt.lab.domain;

import java.time.Instant;

public final class CustodyEvent {
    // Уникальный номер события передачи. Программа назначает сама.
    public long id;

    // К какому образцу относится событие (id образца).
    // Должен ссылаться на реально существующий Sample.
    public long sampleId;

    // От кого передали (логин/имя). Нельзя пустое. До 64 символов.
    public String fromUser;

    // Кому передали (логин/имя). Нельзя пустое. До 64 символов.
    public String toUser;

    // Где произошла передача. Нельзя пустое. До 64 символов.
    public String location;

    // Комментарий (можно пусто). До 128 символов.
    public String comment;

    // Когда передали. Если не вводят — текущее время.
    public Instant transferredAt;

    // Кто создал запись (обычно тот же, кто “from”). На ранних этапах можно "SYSTEM".
    public String ownerUsername;

    // Когда запись создана. Программа ставит автоматически.
    public Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CustodyEvent custodyEvent = (CustodyEvent) o;
        return id == custodyEvent.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}