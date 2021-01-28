package entity.user;

import entity.beta.appentity.AppEntityMetadata;

public interface UserEntityMetadata extends AppEntityMetadata {
    long getCreationTimestamp();
    long getLastSignInTimestamp();
    long getLastUsedTimestamp();
}
