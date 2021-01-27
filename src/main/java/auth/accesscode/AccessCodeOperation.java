package auth.accesscode;

public enum AccessCodeOperation {
    PASSWORD_RESET(1),
    RECOVER_EMAIL(2),
    VERIFY_EMAIL(3),
    VERIFY_BEFORE_CHANGE_EMAIL(4),
    SIGN_IN_WITH_EMAIL_LINK(5),
    ERROR(6);

    AccessCodeOperation() {
        this(6);
    }

    AccessCodeOperation(int operation) {
    }
}
