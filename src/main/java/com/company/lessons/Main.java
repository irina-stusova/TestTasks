package com.company.lessons;

import com.company.lessons.lesson1.*;
import com.company.lessons.lesson10.FileProperties;
import com.company.lessons.lesson11.*;
import com.company.lessons.lesson2.*;
import com.company.lessons.lesson3.*;
import com.company.lessons.lesson5.*;
import com.company.lessons.lesson6.*;
import com.company.lessons.lesson9.HashMapLearn;
import com.company.lessons.lesson9.HashSetLearn;
import com.company.lessons.lesson9.PairwiseSumAndrii;
import com.company.lessons.lesson9.Patter;
import com.company.lessons.utils.ArrayUtils;
import com.company.lessons.utils.FileUtils;
import com.company.lessons.utils.ListUtils;

import java.io.IOException;
import java.util.*;
import java.lang.StringBuffer;

import static com.company.lessons.lesson5.UniversityEnum.Courses.ENGINEERING;
import static com.company.lessons.lesson5.UniversityEnum.Courses.ENGLISH;
import static com.company.lessons.lesson5.UniversityEnum.Courses.PORTUGUES;
import static com.company.lessons.lesson5.UniversityEnum.Faculties.AUTOMATION;
import static com.company.lessons.lesson5.UniversityEnum.Faculties.LINGUISTIC;
import static com.company.lessons.lesson5.UniversityEnum.Groups.GROUP1;
import static com.company.lessons.lesson5.UniversityEnum.Groups.GROUP2;
import static com.company.lessons.lesson5.UniversityEnum.Groups.GROUP3;
import static com.company.lessons.lesson6.Book.CoverTypes.CREATIVE;
import static com.company.lessons.lesson6.Book.CoverTypes.HARD;
import static com.company.lessons.lesson6.Book.CoverTypes.SOFT;
import static com.company.lessons.lesson8.SortMapByValue.*;
//import java.util.Random;
//import java.util.Date;

//import static com.company.lessons.lesson5.UniversityEnum.Courses.*;
//import static com.company.lessons.lesson5.UniversityEnum.Faculties.*;
//import static com.company.lessons.lesson5.UniversityEnum.Groups.*;
//import static com.company.lessons.lesson6.Book.CoverTypes.*;
//import static com.company.lessons.lesson8.*;


public class Main {
    public static void lesson1() {
        Months month1 = new Months();
        month1.getListMonths();
        month1.printMonths("Jenuary");
    }

    public static void lesson2() {
        com.company.lessons.lesson2.Person person1 = new com.company.lessons.lesson2.Person("Jim", "Webber");
        person1.getFirstName();
        person1.setFirstName("Test1");
        person1.getLastName();
        person1.setLastName("Test2");

        Company company1 = new Company();
        ArrayList<com.company.lessons.lesson2.Person> personsList = company1.getPersonsList();
//        personsList.clear();
//        personsList.add(person1);
        company1.printCompanySize(personsList);

        String nameInput = "Ira";
        String lastNameInput = "Webber";
        System.out.println(String.format("Does the Name '%s' exist in the Company? %s", nameInput, company1.firstNameIsPresent(nameInput)));
        System.out.println(String.format("Does the Surname '%s' exist in the Company? %s", lastNameInput, company1.lastNameIsPresent(lastNameInput)));
    }

    public static void lesson3() {
        Long l1 = 100L;
        long l2 = 100;

        com.company.lessons.lesson3.Person person2 = new com.company.lessons.lesson3.Person();

        Student student1 = new Student();
        student1.setFirstName("Irina");
        student1.setPatronymic("Valerievna");
        student1.setLastName("Stusova");
        student1.setBirthDate(399168000L);
        student1.setAddress("Address1");
        student1.setPhone("0683483008");
        student1.setId(1L);
        student1.setFaculty("Automation and Informatics");
        student1.setCourse("Quality Management");
        student1.setGroup("Group1");

        Student student2 = new Student();
        student2.setFirstName("Anna");
        student2.setPatronymic("Sergeevna");
        student2.setLastName("Zharkova");
        student2.setBirthDate(424656000L);
        student2.setAddress("Address2");
        student2.setPhone("0500000000");
        student2.setId(2L);
        student2.setFaculty("Constructions");
        student2.setCourse("Real Estate Estimation");
        student2.setGroup("Group2");

        Student student3 = new Student();
        student3.setFirstName("Nadezhda");
        student3.setPatronymic("Alekseevna");
        student3.setLastName("Nikolaeva");
        student3.setBirthDate(436492800L);
        student3.setAddress("Address3");
        student3.setPhone("0600000000");
        student3.setId(3L);
        student3.setFaculty("Constructions");
        student3.setCourse("Real Estate Estimation");
        student3.setGroup("Group2");


        Student student4 = new Student();
        student4.setFirstName("Olga");
        student4.setPatronymic("Melkonovna");
        student4.setLastName("Andonyan");
        student4.setBirthDate(454723200L);
        student4.setAddress("Address4");
        student4.setPhone("0700000000");
        student4.setId(4L);
        student4.setFaculty("Automation and Informatics");
        student4.setCourse("Quality Management");
        student4.setGroup("Group1");


        // Date date = new Date();
        // System.out.println(date.getTime());

        ArrayList<Student> studentsList = new ArrayList();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);

        University university1 = new University();
        university1.setUniversityName("DSTU");
        university1.setStudentsList(studentsList);

        ArrayList<Student> getStudentsListForFaculty = university1.getStudentsListForFaculty("Automation and Informatics");
        university1.printList(getStudentsListForFaculty);

        System.out.println();

        ArrayList<Student> getStudentsBornAfterDate = university1.getStudentsBornAfterDate(436492800L);
        university1.printList(getStudentsBornAfterDate);

        System.out.println();

        ArrayList<Student> getStudentsListForGroup = university1.getStudentsListForGroup("Group2");
        university1.printList(getStudentsListForGroup);

    }

    public static void lesson5() {
        StudentEnum studentEnum1 = new StudentEnum();
        studentEnum1.setFirstName("Irina");
        studentEnum1.setPatronymic("Valerievna");
        studentEnum1.setLastName("Stusova");
        studentEnum1.setBirthDate(399168000L);
        studentEnum1.setAddress("Address1");
        studentEnum1.setPhone("0683483008");
        studentEnum1.setId(1L);
        studentEnum1.setFaculty(AUTOMATION);
        studentEnum1.setCourse(ENGINEERING);
        studentEnum1.setGroup(GROUP1);

        StudentEnum studentEnum2 = new StudentEnum();
        studentEnum2.setFirstName("Anna");
        studentEnum2.setPatronymic("Sergeevna");
        studentEnum2.setLastName("Zharkova");
        studentEnum2.setBirthDate(424656000L);
        studentEnum2.setAddress("Address2");
        studentEnum2.setPhone("0500000000");
        studentEnum2.setId(2L);
        studentEnum2.setFaculty(LINGUISTIC);
        studentEnum2.setCourse(PORTUGUES);
        studentEnum2.setGroup(GROUP2);


        StudentEnum studentEnum3 = new StudentEnum();
        studentEnum3.setFirstName("Nadezhda");
        studentEnum3.setPatronymic("Alekseevna");
        studentEnum3.setLastName("Nikolaeva");
        studentEnum3.setBirthDate(436492800L);
        studentEnum3.setAddress("Address3");
        studentEnum3.setPhone("0600000000");
        studentEnum3.setId(3L);
        studentEnum3.setFaculty(AUTOMATION);
        studentEnum3.setCourse(ENGINEERING);
        studentEnum3.setGroup(GROUP3);


        StudentEnum studentEnum4 = new StudentEnum();
        studentEnum4.setFirstName("Olga");
        studentEnum4.setPatronymic("Melkonovna");
        studentEnum4.setLastName("Andonyan");
        studentEnum4.setBirthDate(454723200L);
        studentEnum4.setAddress("Address4");
        studentEnum4.setPhone("0700000000");
        studentEnum4.setId(4L);
        studentEnum4.setFaculty(LINGUISTIC);
        studentEnum4.setCourse(ENGLISH);
        studentEnum4.setGroup(GROUP1);


        ArrayList<StudentEnum> studentsList5 = new ArrayList();
        studentsList5.add(studentEnum1);
        studentsList5.add(studentEnum2);
        studentsList5.add(studentEnum3);
        studentsList5.add(studentEnum4);

        UniversityEnum university2 = new UniversityEnum();
        university2.setUniversityEnumName("Best University");
        university2.setStudentsEnumList(studentsList5);


        System.out.println(Arrays.toString(UniversityEnum.Faculties.values()));
        System.out.println(Arrays.toString(UniversityEnum.Courses.values()));
        System.out.println(Arrays.toString(UniversityEnum.Groups.values()));

        System.out.println();

        ArrayList<StudentEnum> getStudentsListForFaculty2 = university2.getStudentsListForFaculty(AUTOMATION);
        university2.printList(getStudentsListForFaculty2);

        System.out.println();

        ArrayList<StudentEnum> getStudentsListForCourse = university2.getStudentsListForCourse(PORTUGUES);
        university2.printList(getStudentsListForCourse);

        System.out.println();

        ArrayList<StudentEnum> getStudentsListForGroup2 = university2.getStudentsListForGroup(GROUP1);
        university2.printList(getStudentsListForGroup2);

    }

    public static void lesson6() {
        Shop shop1 = new Shop("Yakaboo");

        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList.add(new Book("Core Java", "Horstmann", "Williams", 2016L, 864L, 500.45D, HARD));
        bookArrayList.add(new Book("Java7", "Habibullin", "BHV", 2012L, 759L, 450.67D, SOFT));
        bookArrayList.add(new Book("All about Java", "Unknown", "Publishing House", 2013L, 156L, 210.67D, CREATIVE));
        shop1.setBooksList(bookArrayList);


        System.out.println("The list after removal:");
        ArrayList<Book> removeBook = shop1.removeBook("All about Java", "Unknown");
        shop1.printList(removeBook);

        System.out.println();

        System.out.println("The list after adding:");
        ArrayList<Book> addBook = shop1.addBook("NewBook", "Habibullin", "NewPublishingHouse", 2018L, 147L, 7.77D, SOFT);
        shop1.printList(addBook);

        System.out.println();

        System.out.println("The book of particular Author:");
        ArrayList<Book> getBooksOfAuthor = shop1.getBooksOfAuthor("Horstmann");
        shop1.printList(getBooksOfAuthor);

        System.out.println();

        System.out.println("The books issued between:");
        ArrayList<Book> getBooksIssuedBetween = shop1.getBooksIssuedBetween(2013L, 2017L);
        shop1.printList(getBooksIssuedBetween);

        System.out.println();
        System.out.println("The book of particular Publishing House:");
        ArrayList<Book> getBooksOfPublishingHouse = shop1.getBooksOfPublishingHouse("Williams");
        shop1.printList(getBooksOfPublishingHouse);
    }

    public static void lesson7() {
        StringBuffer str1 = new StringBuffer("Write once, run anywhere");
        System.out.println(str1);

        //Задание 1: распечатать строку в обратном порядке
        //Вариант 1:

        str1.reverse();
        System.out.println(str1.toString());

        //Вариант 2:
        String str12 = new String("Write once, run anywhere");
        char[] stringAsArray = str12.toCharArray();
        char swipe;
        int i, j;
        for (i = 0, j = stringAsArray.length - 1; i < stringAsArray.length / 2; i++, j--) {
            swipe = stringAsArray[i];
            stringAsArray[i] = stringAsArray[j];
            stringAsArray[j] = swipe;
        }
        System.out.println(new String(stringAsArray));


        //Задание 2: посчитать количество вхождений какого-то символа в строку (символ задается отдельной переменной)
        //Вариант 1:
        String str2 = new String("Write once, run anywhere");
        char letter = 'e';
        int count = 0;
        for (char c : str2.toCharArray()) {
            if (c == letter) count++;
        }
        System.out.println(count);

//        //Вариант 2:
//
//    public static void numberOfEntries(String letter) {
//        String str22 = " word word";
//        int numberOfEntries = str22.split(letter).length - 1;
//        System.out.println("numberOfEntries = " + numberOfEntries);
//    }


        //Задание 3: посчитать количество уникальных символов
        String str3 = "Write once, run anywhere";
        HashSet<Character> set = new HashSet<>();
        for (char c : str3.toCharArray()) {
            set.add(c);
        }
        System.out.println(set.size());

    }

    public static void lesson8() {

        //Задание 1.
//        StringLearn string1 = new StringLearn();
//        string1.replaceLetter(4, 'A');

//        //Задание 2. Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
        String task2 = "В недрах тундры выдры в гетрах тырят в ведра ядра кедров. Выдрав с выдры в тундре гетры, вытру выдрой ядра кедров";
//        String[] words = task2.split("\\s*(\\s|,|\\.)\\s*");
//
//        HashSet<String> task2AsSet = new HashSet<>();
//        for (String s : words) {
//            task2AsSet.add(s);
//        }
//        String[] setAsArray = task2AsSet.toArray(new String[task2AsSet.size()]);
////Here - how to know the number of counters needed not running task2AsSet.size()?
//
//        int count1 = 0;
//        int count2 = 0;
//        int count3 = 0;
//        int count4 = 0;
//        int count5 = 0;
//        int count6 = 0;
//        int count7 = 0;
//        int count8 = 0;
//        int count9 = 0;
//        int count10 = 0;
//        int count11 = 0;
//        int count12 = 0;
//        int count13 = 0;
//        int count14 = 0;
//        int count15 = 0;
//        int count16 = 0;
//
//        for(int i=0, j=0; i<words.length; i++) {
//            if (words[i].equals(setAsArray[j])) count1++;
//            else if (words[i].equals(setAsArray[j+1])) count2++;
//            else if (words[i].equals(setAsArray[j+2])) count3++;
//            else if (words[i].equals(setAsArray[j+3])) count4++;
//            else if (words[i].equals(setAsArray[j+4])) count5++;
//            else if (words[i].equals(setAsArray[j+5])) count6++;
//            else if (words[i].equals(setAsArray[j+6])) count7++;
//            else if (words[i].equals(setAsArray[j+7])) count8++;
//            else if (words[i].equals(setAsArray[j+8])) count9++;
//            else if (words[i].equals(setAsArray[j+9])) count10++;
//            else if (words[i].equals(setAsArray[j+10])) count11++;
//            else if (words[i].equals(setAsArray[j+11])) count12++;
//            else if (words[i].equals(setAsArray[j+12])) count13++;
//            else if (words[i].equals(setAsArray[j+13])) count14++;
//            else if (words[i].equals(setAsArray[j+14])) count15++;
//            else if (words[i].equals(setAsArray[j+15])) count16++;
//        }
//        System.out.println(String.format("Count of '%s': %d", setAsArray[0], count1));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[1], count2));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[2], count3));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[3], count4));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[4], count5));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[5], count6));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[6], count7));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[7], count8));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[8], count9));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[9], count10));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[10], count11));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[11], count12));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[12], count13));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[13], count14));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[14], count15));
//        System.out.println(String.format("Count of '%s': %d", setAsArray[15], count16));

//Задание 3. В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
        //  task2 = "В недрах тундры выдры в гетрах тырят в ведра ядра кедров. Выдрав с выдры в тундре гетры, вытру выдрой ядра кедров";

        //Создаю mapUnique для хранения уникальных символов из строки (ключ) и их количеств (значение)
        Map<Character, Integer> mapUnique = new HashMap<>();

        for (int i = 0; i < task2.length(); i++) {
            if (mapUnique.get(task2.charAt(i)) != null) {
                int temp = mapUnique.get(task2.charAt(i));
                mapUnique.put(task2.charAt(i), ++temp);
            } else {
                mapUnique.put(task2.charAt(i), 1);
            }
        }

//        System.out.println("Before sorting:");
//        printMap(mapUnique);

//        System.out.println("After sorting ASC:");
//        Map<Character, Integer> sortedMapAsc = sortByComparator(mapUnique, ASC);
//        printPartOfMap(sortedMapAsc, 7);


        System.out.println("After sorting DESC:");
        Map<Character, Integer> sortedMapDesc = sortByComparator(mapUnique, DESC);
        // printMap(sortedMapDesc);
        printPartOfMap(sortedMapDesc, 5);


    }

    public static void lesson9() {

        //Задание 1. Задана строка с текстом на английском языке. Выделить все различные слова.
        //Слова, отличающиеся только регистром букв, считать одинаковыми.
        //Использовать класс HashSet.


        HashSetLearn hsl = new HashSetLearn();
        HashSetLearn.printUniqueWords(hsl.getUniqueWords());

        //    Задание 2. Задана строка с текстом на английском языке. Выделить все различные слова.
        //    Для каждого слова подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными. Использовать класс HashMap.

        HashMapLearn hml = new HashMapLearn();
        hml.printUniqueWordsAndCounts(hml.getUniqueWordsAndCounts(), false);


        //Задание 3. Дано стихотворение в виде строки.
        // Занести стихотворение в список (разделитель символ абзаца \n).
        // Провести сортировку по возрастанию длин строк.

        Patter p = new Patter();
        p.printListOfStringsSorted(p.getListOfStringsSorted());

        //Задание 4. С использованием множества выполнить попарное суммирование произвольного
        // конечного ряда чисел по следующим правилам: на первом этапе суммируются попарно
        // рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т. д. до тех пор,
        // пока не останется одно число.

        //Вариант Андрея:
        PairwiseSumAndrii pws = new PairwiseSumAndrii();
        List<Integer> list = new ArrayList<>(pws.generateRandomSet(10_000_000));
        long start;
        long stop;
        start = new Date().getTime();
        System.out.println(pws.getSumOrdinar(list));
        stop = new Date().getTime();
        System.out.println("Stream loop: " + (stop - start));


        start = new Date().getTime();
        System.out.println(pws.getSumOrdinar(list));
        stop = new Date().getTime();
        System.out.println("Ordinar loop: " + (stop - start));

    }

    public static void lesson10() {
        FileProperties fileProperties = new FileProperties();
        System.out.println(fileProperties.readPropFile().getProperty("prop.1"));
        List<String> list = fileProperties.readFileAsList();
        fileProperties.writeToFile(list);
        System.out.println(list);
    }

    public static void lesson11() throws IOException {

        System.out.println("//Задание 1. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.\n");

        SwapWords swapWords = new SwapWords();
        List<String> fileAsList = FileUtils.readFileAsList("src\\main\\resources\\lessons\\lesson11\\TextOriginal.txt");
        String[][] listAsArray = ListUtils.convertListToArray(fileAsList, "(\\s|,|\\.|\\?)");
        String[][] arrayWithSwappedWords = swapWords.getArrayWithSwappedWords(listAsArray, 0, 2);
        ArrayUtils.printArray(arrayWithSwappedWords);
        List<String> list = ArrayUtils.convertArrayToList(arrayWithSwappedWords);
        FileUtils.writeListToFile(list, "src\\main\\resources\\lessons\\lesson11\\TextModified.txt");


        System.out.println("\n//Задание 2. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.\n");

        RandomInts randomInts = new RandomInts();
        List<String> randomList = randomInts.generateRandomList(10);
        FileUtils.writeListToFile(randomList, "src\\main\\resources\\lessons\\lesson11\\InRandomIntegers.txt");
        List<Integer> integerList = FileUtils.readIntsFromFile("src\\main\\resources\\lessons\\lesson11\\InRandomIntegers.txt");
        List<String> sortedList = randomInts.getSortedList(integerList);
        ListUtils.printList(sortedList, " ");
        FileUtils.writeListToFile(sortedList, "src\\main\\resources\\lessons\\lesson11\\OutRandomIntegers.txt");

        //Задание 3. Прочитать текст Java-программы (какого-то класса)
        //и записать в другой файл в обратном порядке символы каждой строки.

        JavaFileReversed jfr = new JavaFileReversed();
        List<String> fileAsList3 = FileUtils.readFileAsList("src\\main\\java\\com\\company\\lessons\\lesson8\\StringLearn.java");
        String[][] listAsArray3 = ListUtils.convertListToArray(fileAsList3, "");
        List<String> listWithTextReversed = jfr.getTextReversed(listAsArray3);
        FileUtils.writeListToFile(listWithTextReversed, "src\\main\\resources\\lessons\\lesson11\\JavaFileTextReversed.txt");


        System.out.println("\n//Задание 4. Считать стихотворение украинского/английского/русского автора");
        System.out.println("//и в каждом слове длиннее двух символов все строчные символы заменить прописными.\n");

        CaseChange caseChange = new CaseChange();
        List<String> fileAsList4 = FileUtils.readFileAsList("src\\main\\resources\\lessons\\lesson11\\Damasio.txt");
        String[][] listAsArray4 = ListUtils.convertListToArray(fileAsList4, "(\\s|,|\\.|\\?)");
        List<String> arrayAsList4 = ArrayUtils.convertArrayToList(listAsArray4);
        List<String> wordsToUpper = caseChange.toUpperCase(arrayAsList4, 3);
        ListUtils.printList(wordsToUpper, " ");
    }

    public static void main(String[] args) throws IOException {
//        lesson1();
//        lesson2();
//        lesson3();
//        lesson5();
//        lesson6();
//        lesson7();
//        lesson8();
        lesson9();
//        lesson10();
//        lesson11();


//        numberOfEntries("word");

//        List<String> list = new ArrayList<>();
//        Set<String> set1 = new HashSet<>();
//        Map<String, String> map = new HashMap();

//        Book newBook = new Book("Core Java", "Horstmann", "Williams", 2016L, 864L, 500.45D, HARD);
//        Book newBook2 = new Book("Core Java", "Horstmann", "Williams", 2016L, 864L, 500.45D, HARD);

    }
}
