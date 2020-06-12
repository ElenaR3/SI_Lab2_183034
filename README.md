# SI_Lab2_183034

**Ја добив групата на код: 6**

*Control flow graph* за функција која за дадена листа од агли истите ги претвора во секунди. 

![image](https://user-images.githubusercontent.com/52135455/84435853-c748ca00-ac32-11ea-8378-b59fc6e67c3d.png)

Броевите на јазлите одговараат на соодветните линии код дадени во продолжение:

* 1-	List<Integer> result = new ArrayList<>();
* 2-	for (int i = 0; i < angleList.size(); i++) {
* 3-	int deg = angleList.get(i).getDegreess(); 
       int min = angleList.get(i).getMinutes(); 
 int sec = angleList.get(i).getSeconds();
* 4-	if (deg >= 0 && deg < 360) {
* 5-	if (min < 0 || min > 59)  
* 6-	throw new RuntimeException("The minutes of the angle are not valid!");
* 7-	else {
* 8-	if (sec < 0 || sec > 59)
* 9-	throw new RuntimeException("The seconds of the angle are not valid");
* 10-	else {
* 11-	result.add(deg * 3600 + min * 60 + sec);
* 12-	else if (deg == 360) {
* 13-	if (min == 0 && sec == 0)
* 14-	result.add(deg * 3600 + min * 60 + sec);
* 15-	else {
* 16-	throw new RuntimeException("The angle is greater then the maximum"); 
* 17-	else {
* 18-	throw new RuntimeException("The angle is smaller or greater then the minimum");  
* 19-	return result;
* 20-	} (при exception оди тука)

Притоа, јазолот 1 означува иницијализација на листа која се случува секогаш при повикот на фукцијата. Потоа, ни следува for циклус, којшто е означен со јазол 2, меѓутоа иницијализацијата на I е означена со јазол 2.1, проверката на условот со јазол 2.2, и со 2.3 зголемувањето на бројачот i. Редовите со доделувањето на вредност за степени, минути и секунди се означени со јазол 3, затоа што сите се извршуваат при секоја итерација на циклусот, односно за секој еден агол којшто се прегледува. Со јазол 4 е означена линијата во којашто се проверува валидноста на еден јазол. Тука, доколку е валиден аголот може да се продолжи на линија 5, а доколку не е се вршат проверките во линија 12 за дали аголот можеби има вредност од 360 степени. Доколку, јазолот е помеѓу 0 и 360, ќе се продолжи на линија 5, кадешто се проверува валидноста на минутите. Доколку,истите имаат вредност помала од 0 или поголема од 59, се продолжува на линија 6, кадешто се фрла исклучокот The minutes of the angle are not valid, и се оди на линија 20 што означува завршување преку исклучок. Доколку пак се случи минутите да се валидни, ќе се продолжи на линија 7, 8 каде што ќе се проверат секундите. Ако, секујндите се помали од 0 или број поголем од 59, се продолжува на линија 9, кадешто се фрла исклучокот The seconds of the angle are not valid, по што се завршува на линија 20.  Ако пак и секундите се валиден број, во таков случај на линија 11 се фрши успешно претворање на аголот во секундите и се додава на резултатната листа, што означува измината една итерација на циклусот, така што се преминува на 2.3, што го зголемува бројачот и оди на 2.2 каде повторно се проверува задоволеност на условот. Од друга страна, доколку од линијата 4 се преминало на 12, во линија 13 ќе се провери дали минутите и секундите се исто така 0. Ако тоа е така, во линија 14 се додаваат на резултантната листа, по што повторно се повторува постапката за успешно завршена итерација од циклусот. Меѓутоа, ако од линија 13 се утврди невалидност на минутите или секундите (го прават аголот поголем), ќе се премине на линии 15 и 16 кадешто ќе се фрли исклучокот The angle is greater than the maximum. Крајниот случај е доколку не се исполнат условите аголот да е помеѓу 0 и 360 или еднаков на 360 степени, се преминува на линија 17 и 18 кадешто ќе се фрли исклучокот The angle is smaller or greater than the minimum и пак ќе се премине на линија 20. Линија 19 се извршува само доколку for циклусот заврши без да се фрли ниту еден исклучок за некој агол.

### Цикломатска комплексност 

Може да се пресмета на неколку начини: 
- Бројот на јазли= 22, а бројот на ребра=26. Знаеме дека *цикломатската комплексност= бројот на ребра-бројот на јазли + 2*, па оттука добиваме 26-22+2= 6.
- Ако ги изброиме предикатните јазли (јазлите во кои има разгранување добиваме) дека нивниот број е 5, па оттука *цикломатската комплексност= број на предикатни јазли+1*, 5+1=6.
- Со броење на бројот на региони добиваме исто толку

### Основни тест-случаи според Every statement критериумот

1.	Случај 1: степенот на аголот да е број меѓу 0 и 360, но минутите да се помали од 0 или поголеми од 59.  Пример: degrees=180, minutes= 60 или degrees=180, minutes= -1. Тоа е патеката 1,2.1, 2.2, 3, 4, 5, 6 и 20.
2.	Случај 2: степенот на аголот да е број меѓу 0 и 360, минутите се број меѓу 0 и 59, но секундите се помали од 0 или пголеми од 59. Пример: degrees=180, minutes=30, seconds=-1 или degrees=180, minutes=30, seconds=60. Патеката е 1,2.1, 2.2, 3, 4, 5, 7, 8, 9, 20.
3.	Случај 3: сите услови се исполнети. Пример: degrees=180, minutes=40, seconds=20. Патеката е 1,2.1, 2.2, 3, 4, 5, 7, 10, 11, 2.3, проверка на условот во 2.2, ако е исполнет оди во 3, ако не во 19. 
4.	Случај 4: степенот да е 360, минутите и секундите да се 0. Пример: degrees=360, minutes=0, seconds=0. Патеката е 1,2.1, 2.2, 3, 4, 12, 13, 14, проверка на условот во 2.2, ако е исполнет оди во 3, ако не во 19.
5.	Случај 5: степенот е 360, но минутите или секундите се различни од 0. Пример: degrees=360, minutes= 20, seconds=0. Патеката е 1,2.1, 2.2, 3, 4, 12, 13, 15, 16, крај во 20. 
6.	Случај 6: степенот на аголот е или помал од 1, или поголем од 360. Пример: degrees=400, minutes= 0, seconds=0 или degrees=-1, minutes= 20, seconds=0. Патеката е 1,2.1, 2.2, 3, 4, 12, 17, 18, 20.


Во продолжение е дадена и табелата за тест случаите со Every statement критериумот, која исто така е прикачена и во форма на xlsx датотека.

![image](https://user-images.githubusercontent.com/52135455/84441744-9cfc0a00-ac3c-11ea-91fa-81858d2d4a46.png)

### Тест-случаи според Multiple condition

Разгледани се можностите за сите услови поединечно, со соодветно можни тест случаи. 

![image](https://user-images.githubusercontent.com/52135455/84443244-7ee3d900-ac3f-11ea-94e3-a808a5ce2452.png)

### Unit тестови во Gradle

Направени се со креирање на класа во src/test/java. Имплементирани се два теста и тоа еден според Every Statement критериумот, а другиот според Multiple conditon. Користена библиотека за двата теста е org.junit.jupiter.api.Assertions, при што користени се функциите за тест AssertThrows со AssertTrue, assertEquals и assertThat (за еднаквост на листите). 
