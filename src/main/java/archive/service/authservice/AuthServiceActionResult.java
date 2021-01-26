package archive.service.authservice;

import archive.service.userservice.UserService;

public interface AuthServiceActionResult {
    public abstract UserService getUser();
}
