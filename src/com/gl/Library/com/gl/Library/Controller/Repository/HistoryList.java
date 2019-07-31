package com.gl.Library.com.gl.Library.Controller.Repository;

import com.gl.Library.com.gl.Library.Class.Enum.BookCategory;
import com.gl.Library.com.gl.Library.Class.Enum.BookSituation;
import com.gl.Library.com.gl.Library.Class.Object.History;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HistoryList {
    // Create variable
    private List<History> histories = new ArrayList<>();

    // Getter & Setter
    public List<History> getHistories() {

        return histories;
    }

    public void setHistories(List<History> histories) {

        this.histories = histories;
    }

    // Example history data
    public void DataHistoryList(HistoryList histories) {
        histories.getHistories().add(new History(UUID.randomUUID(), "Miku", "Umi", "Captain America",
                BookCategory.Comic, "A0002", "Stan Lee", BookSituation.Borrow,
                LocalDate.now(), LocalDate.now().plusDays(7)));
        histories.getHistories().add(new History(UUID.randomUUID(), "Nino", "Honoka", "Black Widow",
                BookCategory.Novel, "B0002", "Stan Lee", BookSituation.Borrow,
                LocalDate.now().minusDays(9), LocalDate.now().minusDays(1)));
        histories.getHistories().add(new History(UUID.randomUUID(), "Ichika", "Maki", "Thor",
                BookCategory.Comic, "A0003", "Stan Lee", BookSituation.Borrow,
                LocalDate.now().minusDays(2), LocalDate.now().plusDays(5)));
        histories.getHistories().add(new History(UUID.randomUUID(), "Yotsuba", "Eli", "Arthur",
                BookCategory.Magazine, "C0002", "Stan Lee", BookSituation.Borrow,
                LocalDate.now(), LocalDate.now().plusDays(7)));
        histories.getHistories().add(new History(UUID.randomUUID(), "Itsuki", "Honoka", "Doctor Strange",
                BookCategory.Newspaper, "D0001", "Stan Lee", BookSituation.Borrow,
                LocalDate.of(2019, 7, 4), LocalDate.of(2019, 7, 4).plusDays(7)));

    }

}
