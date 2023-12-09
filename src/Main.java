import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        add("фамилия имя отчество 09.12.2023 1112223344 m");
        
    }

    public  static String[] readParams(String param) throws IllegalArgumentException{
        String[] resParam = param.split(" ");
        if (resParam.length != 6){
            String mesEr = " (больше 6)";
            if(resParam.length - 6 < 0)  { mesEr = " (меньше 6)"; }
            throw new IllegalArgumentException("неверное количество аргументов" + mesEr);
        }
        return resParam;
    }

    public  static void add(String params){
        User user = new User();
        try {
            String[] userParam = readParams(params);
            user.setFamily(userParam[0]);
            user.setName(userParam[1]);
            user.setOtchestvo(userParam[2]);
            user.setBornDate(convertDate(userParam[3]));
            user.setTelefon(convertTelefon(userParam[4]));
            user.setGender(convertGender(userParam[5]));

            System.out.println(user.getParam());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (DateTimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static LocalDate convertDate(String strDate){
        int[] resDate = new int[3];
        String[] resStr = strDate.split("\\.");
        LocalDate localDate = LocalDate.of(1,1,1);

        if (resStr.length != 3){ throw  new IllegalArgumentException("неверный формат даты"); }

        try {
            for (int i=0; i<3; i++) {
                resDate[i] = Integer.parseInt(resStr[i]);
            }
            localDate = LocalDate.of(resDate[2], resDate[1], resDate[0]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("нельзя преобразовать строку в дату рождения");
        }
        catch (DateTimeException e){
            throw new DateTimeException("неверный диапазон в дате: " + e.getLocalizedMessage());
        }
        return localDate;
    }

    public static int convertTelefon(String strTel){
        int tel = 0;

        if (strTel.length() != 10){
            throw new IllegalArgumentException("неверная длинна телефона");
        }

        try {
            tel = Integer.parseInt(strTel);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("нельзя преобразовать строку в номер телефона");
        }
        return tel;
    }

    public static String convertGender(String strGender){
        String mes = "для задания пола введите m или w";
        if (!strGender.equals("m") && !strGender.equals("w")) {throw new IllegalArgumentException(mes);}

        return strGender;
    }
}