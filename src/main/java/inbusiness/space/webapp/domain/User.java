package inbusiness.space.webapp.domain;

//import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldIndex;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A user.
 */
//@Entity
//@Table(name = "user")
//@Document(indexName="user")
public class User extends AbstractAuditingEntity implements Serializable, Comparable<User> {

    //@Id
    private String id;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 1, max = 50)
    //@Column(length = 50, unique = true, nullable = false)
    //@Field(index = FieldIndex.not_analyzed, type= FieldType.String)
    private String login;

    @NotNull
    @Size(min = 60, max = 60)
    //@Column(length = 60)
    //@Field(index = FieldIndex.not_analyzed,  type= FieldType.String)
    private String password;

    @Size(max = 50)
    //@Column(name = "first_name", length = 50)
    //@Field(index = FieldIndex.not_analyzed,  type= FieldType.String)
    private String firstName;

    @Size(max = 50)
    //@Column(name = "last_name", length = 50)
    //@Field(index = FieldIndex.not_analyzed,  type= FieldType.String)
    private String lastName;

    @Email
    @Size(max = 100)
    //@Column(length = 100, unique = true)
    //@Field(index = FieldIndex.not_analyzed, type= FieldType.String)
    private String email;

    //@Column(nullable = false)
    private boolean activated = false;

    @Size(min = 2, max = 5)
    //@Column(name = "lang_key", length = 5)
    //@Field(index = FieldIndex.not_analyzed, type= FieldType.String)
    private String langKey;

    @Size(max = 20)
    //@Column(name = "activation_key", length = 20)
    //@Field(index = FieldIndex.not_analyzed, type= FieldType.String)
    private String activationKey;

    @Size(max = 20)
    //@Column(name = "reset_key", length = 20)
    //@Field(index = FieldIndex.not_analyzed, type= FieldType.String)
    private String resetKey;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    //@Column(name = "reset_date", nullable = true)
    private DateTime resetDate = null;

    //@ManyToMany
//    @JoinTable(
//            name = "JHI_USER_AUTHORITY",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
//    @Field(index = FieldIndex.not_analyzed, type = FieldType.Object)
    private Set<Authority> authorities = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public DateTime getResetDate() {
       return resetDate;
    }

    public void setResetDate(DateTime resetDate) {
       this.resetDate = resetDate;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!login.equals(user.login)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated='" + activated + '\'' +
                ", langKey='" + langKey + '\'' +
                ", activationKey='" + activationKey + '\'' +
                "}";
    }

    @Override
    public int compareTo(User o) {
        return getLogin().compareTo(o.getLogin());
    }
}
