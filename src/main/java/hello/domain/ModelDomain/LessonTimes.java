package hello.domain.ModelDomain;

import java.util.Arrays;

public class LessonTimes {
    public int id = 0;
    public String name = "";
    public String urlToLessonLogo = "";
    public String time = "";
    public String date1 = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlToLessonLogo() {
        return urlToLessonLogo;
    }

    public void setUrlToLessonLogo(String urlToLessonLogo) {
        this.urlToLessonLogo = urlToLessonLogo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LessonTimes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlToLessonLogo='" + urlToLessonLogo + '\'' +
                ", time='" + time + '\'' +
                ", date1='" + date1 + '\'' +
                '}';
    }
}
