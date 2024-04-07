package com.vpbank.common.util;

import com.vpbank.common.exception.BusinessException;
import com.vpbank.common.model.WofMAccount;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Authentications {
    private Authentications() {
    }

    public static Long requireAccountId() {
        return requireAccountId(SecurityContextHolder.getContext().getAuthentication());
    }

    public static Long requireAccountId(Authentication authentication) {
        return requireWofMAccount(authentication).getId();
    }

    public static WofMAccount requireWofMAccount() {
        return requireWofMAccount(SecurityContextHolder.getContext().getAuthentication());
    }

    public static WofMAccount requireWofMAccount(Authentication authentication) {
        var principal = authentication.getPrincipal();
        if (principal instanceof WofMAccount account) {
            return account;
        }
        throw new BusinessException(ErrorCode.FORBIDDEN, "You don't have permission to access this resource. Require logged user");
    }

    public static Optional<WofMAccount> getWofMAccount() {
        return getWofMAccount(SecurityContextHolder.getContext().getAuthentication());
    }

    public static Optional<WofMAccount> getWofMAccount(Authentication authentication) {
        var principal = authentication.getPrincipal();
        return principal instanceof WofMAccount account ? Optional.of(account) : Optional.empty();
    }

    public static Optional<Long> getAccountId() {
        return getAccountId(SecurityContextHolder.getContext().getAuthentication());
    }

    public static Optional<Long> getAccountId(Authentication authentication) {
        var principal = authentication.getPrincipal();
        return principal instanceof WofMAccount account ? Optional.of(account.getId()) : Optional.empty();
    }
}
