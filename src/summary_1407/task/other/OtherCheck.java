package summary_1407.task.other;

public class OtherCheck {
    private final String article;
    private final int count;
    private final int overallPrice;
    private final String category;

    public OtherCheck(String article, int count, int overallPrice, String category) {
        this.article = article;
        this.count = count;
        this.overallPrice = overallPrice;
        this.category = category;
    }

    public String getArticle() {
        return article;
    }

    public int getCount() {
        return count;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "OtherCheck{" +
                "article='" + article + '\'' +
                ", count=" + count +
                ", overallPrice=" + overallPrice +
                ", category='" + category + '\'' +
                '}';
    }
}
