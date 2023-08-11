package com.telrun.rledenev.summary_0714.task.other;

import java.time.ZonedDateTime;
import java.util.List;

public class OtherCheckProvider {

    public List<OtherCheck> getChecks(ZonedDateTime from, ZonedDateTime to) {
        return List.of(new OtherCheck("Milk", 1, 2, "1"),
                new OtherCheck("Bread", 2, 1, "2"),
                new OtherCheck("Potato", 3, 3, "3"),
                new OtherCheck("Milk", 3, 2, "4"));
    }
}
