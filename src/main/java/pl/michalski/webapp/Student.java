package pl.michalski.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  //adnotacja, która sprawia, że ta klasa jest rozumiana jako model tabeli bazy danych
public class Student {

    @Id //adnotacja - ustawia pierwsze pole pod sobą jako ID czyli wartość unikalną w tabeli (klucz prywatny)
    @GeneratedValue(strategy = GenerationType.AUTO) //adnotacja - ustawia pierwsze pole pod sobą jako wartość generowaną,
    // a w nawiasach informacja, ze sposób generowania ma być automatyczny
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
