package smartphones.demo.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean isFlagship;

    @NotNull
    private boolean isExFlagship;

    @NotNull
    private boolean nfc;

    @OneToOne(mappedBy = "phoneDetails" , cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private Phone phone;


    public PhoneDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFlagship() { return isFlagship; }
    public boolean getIsFlagship() { return isFlagship; }

    public void setFlagship(boolean flagship) {
        isFlagship = flagship;
    }
    public void setIsFlagship(boolean flagship) { isFlagship = flagship; }

    public boolean isExFlagship() {
        return isExFlagship;
    }
    public boolean getIsExFlagship() { return isExFlagship; }

    public void setExFlagship(boolean exFlagship) {
        isExFlagship = exFlagship;
    }
    public void setIsExFlagship(boolean exFlagship) { isExFlagship = exFlagship; }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public boolean isNfc() { return nfc; }
    public boolean getIsNfc() { return nfc; }

    public void setNfc(boolean nfc) { this.nfc = nfc; }
    public void setIsNfc(boolean nfc) { this.nfc = nfc; }
}

