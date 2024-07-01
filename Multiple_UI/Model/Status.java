package Multiple_UI.Model;

public enum Status {
    Pending,
    Doing,
    Done,
    Cancelled;

    public static boolean isTerminal(Status status) {
        return status == Status.Cancelled || status == Status.Done;
    }
}
