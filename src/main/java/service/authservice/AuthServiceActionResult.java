package service.authservice;

import service.userservice.UserService;

public interface AuthServiceActionResult {
    public abstract UserService getUser();
}
