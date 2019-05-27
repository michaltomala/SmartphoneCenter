package smartphones.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String name;

    @Min(value = 100)
    private int price;

    @NotEmpty
    @Column(unique = true)
    private String ceneoUrl;

    @OneToOne(optional = false , cascade = CascadeType.REMOVE)
    @JsonBackReference
    private PhoneDetails phoneDetails;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    @JsonBackReference
    private Brand brand;

    @ManyToMany(mappedBy = "phones")
    private List<User> users;

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getCeneoUrl() {
        return ceneoUrl;
    }

    public void setCeneoUrl(String ceneoUrl) {
        this.ceneoUrl = ceneoUrl;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
