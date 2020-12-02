package com.mobiquity.domains.builders;

import com.mobiquity.domains.entity.User;

public class UserBuilder {

    public String _name = "Eren Degerli";
    public String _username = "Eren";
    public String _email = "erencdegerli@gmail.com";
    public String _phone = "(775)976-6794 x41206";
    public String _website = "www.conrad.com";

    public UserBuilder withUsername(String username) {
        _username = username;
        return this;
    }

    public UserBuilder withEmail(String email) {
        _email = email;
        return this;
    }

    public User build() {
        return new User() {{
            this.name = _name;
            this.username = _username;
            this.email = _email;
            this.phone = _phone;
            this.website = _website;
        }};
    }
}
