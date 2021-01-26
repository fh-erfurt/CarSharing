package entity;

public interface EntityMetadata {
    long getCreationTimestamp();
    long getLastSignInTimestamp();
    long getLastUsedTimestamp();
}
