package Entities;

import java.util.Optional;

public class UserStats {
    private Optional visitCount;

    public Optional getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional visitCount) {
        this.visitCount = visitCount;
    }

    public UserStats(Optional visitCount) {
        this.visitCount = visitCount;
    }

    public UserStats() {
    }
}
