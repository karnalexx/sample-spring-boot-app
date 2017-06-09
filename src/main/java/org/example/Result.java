package org.example;

public class Result {

    private long id;
    private String name;
    private int officialTextCount;
    private int englishTextCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOfficialTextCount() {
        return officialTextCount;
    }

    public void setOfficialTextCount(int officialTextCount) {
        this.officialTextCount = officialTextCount;
    }

    public int getEnglishTextCount() {
        return englishTextCount;
    }

    public void setEnglishTextCount(int englishTextCount) {
        this.englishTextCount = englishTextCount;
    }
}
