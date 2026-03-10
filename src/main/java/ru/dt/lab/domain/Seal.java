package ru.dt.lab.domain;

import java.time.Instant;

public final class Seal {
    // Уникальный номер пломбы. Программа назначает сама.
    private final long id;

    // К какому образцу относится (id образца).
    // Должен ссылаться на реально существующий Sample.
    private long sampleId;

    // Номер пломбы (например "SEAL-9911"). Нельзя пустое. До 64 символов.
    private String sealNumber;

    // Статус пломбы: ACTIVE или BROKEN.
    private SealStatus status;

    // Кто поставил пломбу (логин). На ранних этапах можно "SYSTEM".
    private String ownerUsername;

    // Когда поставили. Программа ставит автоматически.
    private final Instant createdAt;

    // Когда изменяли (например, ломали). Программа обновляет автоматически.
    private Instant updatedAt;

    public Seal(long id, long sampleId, String sealNumber, SealStatus status, String ownerUsername, Instant createdAt,Instant updatedAt){
        this.id = id;
        this.sampleId = sampleId;
        setSealNumber(sealNumber);
        setStatus(status);
        setOwnerUsername(ownerUsername);
        this.createdAt = createdAt;
        setUpdatedAt(updatedAt);
    }

    public long getId() {
        return id;
    }

    public long getSampleId() {
        return sampleId;
    }

    public void setSampleId(long sampleId) {
        this.sampleId = sampleId;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(String sealNumber) {
        if(!sealNumber.isEmpty() && sealNumber.length() < 64) {
            this.sealNumber = sealNumber;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public SealStatus getStatus() {
        return status;
    }

    public void setStatus(SealStatus status) {
        this.status = status;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
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
        Seal seal = (Seal) o;
        return id == seal.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
