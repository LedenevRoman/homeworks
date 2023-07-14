package summary_1407.task;

import java.time.ZonedDateTime;
import java.util.List;

public interface ChecksProvider {

    List<Check> getChecks(ZonedDateTime from, ZonedDateTime to);
}
