package dev.julioperez.certificate.shared.domain.exception;

public abstract class DomainError extends RuntimeException {
    private final String errorMessage;

    public DomainError(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return errorMessage;
    }
}