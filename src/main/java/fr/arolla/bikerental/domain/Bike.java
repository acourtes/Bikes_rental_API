package fr.arolla.bikerental.domain;

import java.util.Objects;

public class Bike {
    private final Integer serialId;

    private final boolean isRent;
    public Bike(Integer serialId, boolean isRent) {
        this.serialId = serialId;
        this.isRent = isRent;
    }

    public boolean isRent() {
        return isRent;
    }

    public Integer getSerialId() {
        return serialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return isRent() == bike.isRent() && getSerialId().equals(bike.getSerialId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialId(), isRent());
    }
}
