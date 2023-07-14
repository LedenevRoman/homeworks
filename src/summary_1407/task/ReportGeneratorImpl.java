package summary_1407.task;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {

    private final ChecksProvider checksProvider;

    public ReportGeneratorImpl(ChecksProvider checksProvider) {
        this.checksProvider = checksProvider;
    }

    @Override
    public ReportResult generateReport(ZonedDateTime from, ZonedDateTime to) {
        Map<String, Integer> articleToCount = getChecks(from, to).stream()
                .collect(Collectors.toMap(Check::getArticle, Check::getCount,
                        Integer::sum));

        String mostSoldArticle = articleToCount.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        Map<String, BigDecimal> articleToPrice = getChecks(from, to).stream()
                .collect(Collectors.toMap(Check::getArticle, Check::getOverallPrice,
                        BigDecimal::add));

        return new ReportResult(mostSoldArticle, articleToPrice);
    }

    private List<Check> getChecks(ZonedDateTime from, ZonedDateTime to) {
        return checksProvider.getChecks(from, to);
    }
}
