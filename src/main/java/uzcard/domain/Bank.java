package uzcard.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * A Bank.
 */
@Entity
@Table(name = "bank")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "bin")
    private String bin;

    @Column(name = "logo_path")
    private String logoPath;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public UUID getId() {
        return this.id;
    }

    public Bank id(UUID id) {
        this.setId(id);
        return this;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Bank name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBin() {
        return this.bin;
    }

    public Bank bin(String bin) {
        this.setBin(bin);
        return this;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLogoPath() {
        return this.logoPath;
    }

    public Bank logoPath(String logoPath) {
        this.setLogoPath(logoPath);
        return this;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bank)) {
            return false;
        }
        return getId() != null && getId().equals(((Bank) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Bank{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", bin='" + getBin() + "'" +
            ", logoPath='" + getLogoPath() + "'" +
            "}";
    }
}
