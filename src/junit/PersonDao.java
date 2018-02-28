package junit;

/**
 * Created by ozc on 2017/4/24.
 */
public class PersonDao {

    @InjectPerson(username = "zhongfucheng",age = 20) private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }
}
