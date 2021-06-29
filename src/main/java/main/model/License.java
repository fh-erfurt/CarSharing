package main.model;

import java.time.LocalDate;

public class License {

    public enum LicenseType {
        A, B, C, D
    }

    private final LicenseType type;
    private final String number;
    private final LocalDate dateIssued;
    private LocalDate expiryDate;

    public License (LicenseType type, String number, LocalDate dateIssued, LocalDate expiryDate) {
        this.type = type;
        this.number = number;
        this.dateIssued = dateIssued;
        this.expiryDate = expiryDate;
    }

    public boolean verify () {
        if (this.dateIssued.isBefore(this.expiryDate) && this.expiryDate.isAfter(LocalDate.now())) {
            return this.type.equals(LicenseType.A) ||
                    this.type.equals(LicenseType.B) ||
                    this.type.equals(LicenseType.C) ||
                    this.type.equals(LicenseType.D);
        }
        return false;
    }

    public LocalDate getExpiryDate () {
        return this.expiryDate;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        License license = (License) o;

        return this.number.equals(license.number);
    }

    @Override
    public int hashCode () {
        return this.number.hashCode();
    }

    public void updateExpiryDate (LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LicenseType getType () {
        return this.type;
    }

    public String getNumber () {
        return this.number;
    }

    public LocalDate getIssuedOn () {
        return this.dateIssued;
    }

}
