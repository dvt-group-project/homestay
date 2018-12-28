package com.thinkpad.homestay.formatter;

import com.thinkpad.homestay.models.UserRole;
import com.thinkpad.homestay.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class UserRoleFormatter implements Formatter<Optional<UserRole>> {
    private UserRoleService userRoleService;

    @Autowired
    public UserRoleFormatter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    public UserRoleFormatter() {
    }

    @Override
    public Optional<UserRole> parse(String text, Locale locale) throws ParseException {
        return userRoleService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Optional<UserRole> object, Locale locale) {
        return null;
    }
}
