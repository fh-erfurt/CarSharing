package archive.main.auth.beta.actioncode;

public enum ActionCodeOperation {
    PASSWORD_RESET(1),
    RECOVER_EMAIL(2),
    VERIFY_EMAIL(3),
    VERIFY_BEFORE_CHANGE_EMAIL(4),
    SIGN_IN_WITH_EMAIL_LINK(5),
    ERROR(6);

    ActionCodeOperation() {
        this(6);
    }

    ActionCodeOperation(int operation) {
    }
}
