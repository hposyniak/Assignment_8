//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009
//    A new class, would be more useful if the questions had actual content

public class Question {

    private String content;
    private Category category;

    public Question(String content, Category category) {
        this.content = content;
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
