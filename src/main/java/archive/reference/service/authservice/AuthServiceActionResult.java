package archive.reference.service.authservice;

import archive.reference.service.userservice.UserService;

public interface AuthServiceActionResult {
    public abstract UserService getUser();
}
