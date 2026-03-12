package ru.dt.lab.domain;

import java.time.Instant;

public final class CustodyEvent {

    private void validateString(String value, int maxLength, String fieldName) {
        if (value == null || value.isEmpty() || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " недействителен :(");
        }
    }

        // Уникальный номер события передачи. Программа назначает сама.
        private final long id;

        // К какому образцу относится событие (id образца).
        // Должен ссылаться на реально существующий Sample.
        private long sampleId;

        // От кого передали (логин/имя). Нельзя пустое. До 64 символов.
        private String fromUser;

        // Кому передали (логин/имя). Нельзя пустое. До 64 символов.
        private String toUser;

        // Где произошла передача. Нельзя пустое. До 64 символов.
        private String location;

        // Комментарий (можно пусто). До 128 символов.
        private String comment;

        // Когда передали. Если не вводят — текущее время.
        private Instant transferredAt;

        // Кто создал запись (обычно тот же, кто “from”). На ранних этапах можно "SYSTEM".
        private String ownerUsername;

        // Когда запись создана. Программа ставит автоматически.
        private final Instant createdAt;

        public CustodyEvent(long id, long sampleId, String fromUser, String toUser, String location, String comment, Instant transferredAt, String ownerUsername, Instant createdAt){
            this.id = id;
            setSampleId(sampleId);
            setFromUser(fromUser);
            setToUser(toUser);
            setLocation(location);
            setComment(comment);
            setTransferredAt(transferredAt);
            setOwnerUsername(ownerUsername);
            this.createdAt = createdAt;
        }

        public long getId() {
            return this.id;
        }

        public long getSampleId() {
            return sampleId;
        }

        public void setSampleId(long sampleId) {
            this.sampleId = sampleId;
        }

        public String getFromUser() {
            return fromUser;
        }

        public void setFromUser(String fromUser) {
            validateString(fromUser, 64, "fromUser");
                this.fromUser = fromUser;
        }

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            validateString(toUser, 64, "toUser");
                this.toUser = toUser;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            validateString(location, 64, "Location");
                this.location=  location;
        }

        public String getComment() {
            return comment;
        }

    public void setComment(String comment) {
        if (comment != null && comment.length() > 128) {
            throw new IllegalArgumentException("Комментарий слишком длинный (макс. 128 символов) :(");
        }
        this.comment = (comment == null) ? "" : comment;
    }

    public Instant getTransferredAt() {
        return transferredAt;
    }

    public void setTransferredAt(Instant transferredAt) {
                this.transferredAt = transferredAt;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setOwnerUsername(String ownerUsername) {
        validateString(ownerUsername, 64, "ownerUsername");
            this.ownerUsername = ownerUsername;
    }

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