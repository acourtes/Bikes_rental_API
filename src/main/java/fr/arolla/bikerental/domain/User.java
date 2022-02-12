package fr.arolla.bikerental.domain;

public record User(Integer userId, String name, Integer accessCardId, boolean hasActivePaymentCard) {
}
