package java_sem_2;


//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
//используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".

public class Task_01 {
    public static void main(String[] args){
        String request=("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        String start_phrase ="select * from students WHERE name = ";    // Начало итоговой строки

        StringBuilder name= new StringBuilder();
        StringBuilder country= new StringBuilder();
        StringBuilder city= new StringBuilder();
        StringBuilder age= new StringBuilder();
        StringBuilder sb= new StringBuilder();        
        String[] world = request.split(",");                      // Разделение запроса на элементы

        for (int i =9; i<world[0].length()-1; i++) {                    // Переписывание из элемены в переменную имя
            name.append(world[0].charAt(i));
        }
        for (int i =12; i<world[1].length()-1; i++) {                   // Переписывание из элемены в переменную страну
            country.append(world[1].charAt(i));
        }
        for (int i =9; i<world[2].length()-1; i++) {                    // Переписывание из элемены в переменную город
            city.append(world[2].charAt(i));
        }
        for (int i =8; i<world[3].length()-2; i++) {                    // Переписывание из элемены в переменную год
            age.append(world[3].charAt(i));
        }
        boolean flag = "null".equals(age.toString());                   // Преобразование значения строки null в Булевое
     
        sb.append(start_phrase);                                        // Формирование итоговой строки
        sb.append(name);
        sb.append(" AND ");
        sb.append(country);
        sb.append(" AND ");
        sb.append(city);
        if (flag == false){
            sb.append(" AND ");
            sb.append(age);
        }
        System.out.println(sb);

    }
}
