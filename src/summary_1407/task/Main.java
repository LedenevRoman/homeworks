package summary_1407.task;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        ChecksProvider checksProvider = (from, to) -> {
            if (from.isAfter(to)) {
                return Collections.emptyList();
            }
            return List.of(new Check("Milk", 1, new BigDecimal(2)),
                    new Check("Bread", 2, new BigDecimal(1)),
                    new Check("Potato", 3, new BigDecimal("0.5")),
                    new Check("Milk", 3, new BigDecimal(2)));
        };*/

        ChecksProvider checksProvider = new ChecksProviderImpl();

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(checksProvider);
        ReportResult reportResult = reportGenerator.generateReport(LocalDate.parse("2023-06-10").atStartOfDay(ZoneId.of("Europe/Berlin")),
                LocalDate.parse("2023-06-02").atStartOfDay(ZoneId.of("Europe/Berlin")));

        System.out.println(reportResult);
    }
}
