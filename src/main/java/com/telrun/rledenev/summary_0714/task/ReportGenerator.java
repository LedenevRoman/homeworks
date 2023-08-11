package com.telrun.rledenev.summary_0714.task;

import java.time.ZonedDateTime;

public interface ReportGenerator {
    ReportResult generateReport(ZonedDateTime from, ZonedDateTime to);
}
