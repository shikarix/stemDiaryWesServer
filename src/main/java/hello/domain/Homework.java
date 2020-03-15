package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private GregorianCalendar date;
    private String href;
    private String def;
    private int teacherId;

}
