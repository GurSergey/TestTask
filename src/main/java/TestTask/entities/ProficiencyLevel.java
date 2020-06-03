package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

public class ProficiencyLevel {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private ForeignLanguage language;
}
