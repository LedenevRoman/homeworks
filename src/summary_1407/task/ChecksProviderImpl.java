package summary_1407.task;

import summary_1407.task.other.OtherCheckProvider;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ChecksProviderImpl implements ChecksProvider {
    private final OtherCheckProvider otherCheckProvider = new OtherCheckProvider();

    @Override
    public List<Check> getChecks(ZonedDateTime from, ZonedDateTime to) {
        return otherCheckProvider.getChecks(from, to).stream()
                .map(otherCheck -> new Check(otherCheck.getArticle(), otherCheck.getCount(),
                        new BigDecimal(otherCheck.getOverallPrice())))
                .collect(Collectors.toList());
    }
}
