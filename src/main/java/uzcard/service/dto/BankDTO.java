package uzcard.service.dto;

import uzcard.domain.Bank;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link Bank} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BankDTO implements Serializable {

    private UUID id;

    private String name;

    private String bin;

    private String logoPath;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankDTO)) {
            return false;
        }

        BankDTO bankDTO = (BankDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bankDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", bin='" + getBin() + "'" +
            ", logoPath='" + getLogoPath() + "'" +
            "}";
    }
}
