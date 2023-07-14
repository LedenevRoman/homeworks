package summary_1407.task;

import java.time.ZonedDateTime;

public interface ReportGenerator {
    ReportResult generateReport(ZonedDateTime from, ZonedDateTime to);
}
