package ik.se.gmail.model;

import java.util.Objects;
import java.util.StringJoiner;

public class UserAccount implements Comparable<UserAccount>, Cloneable {

    public String emailAddress;
    public String password;

    public UserAccount(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Override
    public int compareTo(UserAccount o) {
        int emailCmp = emailAddress.compareTo(o.emailAddress);
        return (emailCmp != 0 ? emailCmp : password.compareTo(password));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return emailAddress.equals(that.emailAddress) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, password);
    }

    @Override
    public UserAccount clone() {
        UserAccount clone = null;
        try {
            clone = (UserAccount) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserAccount.class.getSimpleName() + "[", "]")
                .add("emailAddress='" + emailAddress + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
