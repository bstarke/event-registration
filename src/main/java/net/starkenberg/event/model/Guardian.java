package net.starkenberg.event.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {@Index(name = "email_unique_index", unique = true, columnList = "email")})
public class Guardian implements Serializable {

    private static final long serialVersionUID = 611164987159444117L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String address;
    private String city;
    private String state;
    @NotNull
    private Integer zipCode;
    @NotNull
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guardian")
    private List<Child> children;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName.trim().toLowerCase();
        }
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName.trim().toLowerCase();
        }
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address.trim().toLowerCase();
        }
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city.trim().toLowerCase();
        }
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        if (state != null && !state.isEmpty()) {
            state = state.trim().toLowerCase();
            if (state.startsWith("ar")) {
                this.state = "AR";
            } else if (state.startsWith("misso")) {
                this.state = "MO";
            } else if (state.startsWith("ok")) {
                this.state = "OK";
            } else {
                if (state.length() > 2) {
                    this.state = state.substring(0, 1).toUpperCase();
                } else {
                    this.state = state.toUpperCase();
                }
            }
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email.toLowerCase();
        }
    }

    /**
     * @return the children
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    /**
     * @return the zipCode
     */
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
