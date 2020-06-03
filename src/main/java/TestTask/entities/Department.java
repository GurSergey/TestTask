package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Department {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private Date dateCreate;

    @Getter
    @Setter
    private String name;
}
