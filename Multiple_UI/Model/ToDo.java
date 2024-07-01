package Multiple_UI.Model;

public class ToDo {
    String text;
    Status status;

    public ToDo(String text) {
        this.text = text;
        this.status = Status.Pending;
    }

    public String getText() {
        return this.text;
    }

    public Status getStatus() {
        return this.status;
    }

    public ToDo next() {
        if (this.status == Status.Cancelled || this.status == Status.Done) {

        } else if (this.status == Status.Pending) {
            this.status = Status.Doing;
        } else {
            this.status = Status.Done;
        }
        return this;
    }

    public ToDo cancel() {
        if (this.status == Status.Cancelled || this.status == Status.Done) {
        } else {
            this.status = Status.Cancelled;
        }
        return this;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
