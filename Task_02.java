package java_sem_2;

import java.io.FileWriter;

public class Task_02 {
    
//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

    public static void main(String[] args){
        int[] arr = new int[] {2, 3, 4, 1, 5, 3, 9, 3, 13, 33, 5, 11, 5, 1, 8, 15, 24, 10};
        StringBuilder sb= new StringBuilder(); 
        int temp =0;
        for (int j = 0; j < arr.length-1; j++) {                        //Повторяем сортировку пока все элемены не будут отсортированы
            for (int i = 0; i < arr.length-1; i++) {                    //Перемещаем самый большой элемент в конец
                if (arr[i]>arr[i+1]) {                                  //Сравниваем два значения массива, если первое больше второго, меняем их местами
                    temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
                sb.append(arr[i]);                                      //Записываем в строкбилдер меньшее значение
                sb.append(", ");
            }
            sb.append(arr[arr.length-1]);                               //Записываем в строкбилдер последниее значение
            sb.append("\n");                                        //по завершению прохода переходим на новую строку
        }
        String text = sb.toString();                                    //Формируем строку для записи в файл            
        try{                                                            //Записываем в файл
            FileWriter file = new FileWriter("log.txt", true);
            file.write(text);
            file.write("\n");                                       //Разделяем повторное выполнение программы пустой строкой
            file.close();
        }
        catch (Exception e){
            System.out.println("Что-то пошло не так");
        }  
    }
}