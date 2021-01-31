package outofbandcode;

public enum OOBCodeOperation {
    PASSWORD_RESET(1),
    RECOVER_EMAIL(2),
    VERIFY_EMAIL(3),
    VERIFY_BEFORE_CHANGE_EMAIL(4),
    SIGN_IN_WITH_EMAIL_LINK(5),
    ERROR(6);

    OOBCodeOperation() {
        this(6);
    }

    OOBCodeOperation(int operation) {
    }
}
