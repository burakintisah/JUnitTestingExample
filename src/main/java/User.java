public class User {

    private String name, surname, city, symptoms;
    private Integer age;
    private Double fever;

    private boolean showAlert = false;

    public User(Object [] expectedDemographicInfo) {
        try {
            name = (String) expectedDemographicInfo[0];
            surname = (String)  expectedDemographicInfo[1];
            city = (String) expectedDemographicInfo[2];

            int _age = (Integer) expectedDemographicInfo[3];

            if (_age < 3 || _age == Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
            age = _age;
            symptoms = (String) expectedDemographicInfo[4];
            fever = (Double) expectedDemographicInfo[5];

        }catch (ClassCastException err){
            throw err;
        }
    }

    public boolean checkAlert () {
        if (fever > 38.5) {
            showAlert = true;
        }
        return showAlert;
    }
}
