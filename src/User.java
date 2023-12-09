import java.time.LocalDate;

public class User {
    private String name;
    private String family;
    private String otchestvo;
    private LocalDate bornDate;
    private int telefon;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFamily() {
        return family;
    }

    public String getParam(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(family);
        stringBuilder.append("><");
        stringBuilder.append(name);
        stringBuilder.append("><");
        stringBuilder.append(otchestvo);
        stringBuilder.append("><");
        stringBuilder.append(bornDate);
        stringBuilder.append("><");
        stringBuilder.append(telefon);
        stringBuilder.append("><");
        stringBuilder.append(gender);
        stringBuilder.append(">");

        return stringBuilder.toString();
    }
}
