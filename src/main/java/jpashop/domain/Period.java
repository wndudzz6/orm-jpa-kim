package jpashop.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period() {}

    public Period(LocalDateTime endDate, LocalDateTime startDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

}
