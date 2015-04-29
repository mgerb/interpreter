public class FORTRANZ {

	public static void main(String[] args) {





addition();

subtraction();

multiplication();

division();


 }


public static void addition() {

int[][] i = new int[2+1][5+1];
int j = 1;
int k = 1;

while (j <= 10){

while (k <= 5){

i[1][k] = (int) (Math.random() * 9 + 1) ;
i[2][k] = (int) (Math.random() * 9 + 1) ;

k = k + 1 ;

 }

System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", " ", i[1][1] , " ", i[1][2] , " ", i[1][3] , " ", i[1][4] , " ", i[1][5]); System.out.println();
System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", "+", i[2][1] , "+", i[2][2] , "+", i[2][3] , "+", i[2][4] , "+", i[2][5]); System.out.println();
System.out.printf("%3s", "___ ___ ___ ___ ___ ___ ___ ___ ___ ___"); System.out.println();

j = j + 1 ;
k = 1 ;
 }

 }


public static void subtraction() {
int[][] i = new int[2+1][5+1];
int j = 1;
int k = 1;
int l;

while (j <= 10){

while (k <= 5){

i[1][k] = (int) (5 + Math.random() * 26) ;
i[2][k] = (int) (1 + Math.random() * 9) ;

if (i[1][k] < i[2][k]) {
l = i[1][k] ;
i[1][k] = i[2][k] ;
i[2][k] = l ;
 }

k = k + 1 ;

 }

System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", " ", i[1][1] , " ", i[1][2] , " ", i[1][3] , " ", i[1][4] , " ", i[1][5]); System.out.println();
System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", "-", i[2][1] , " -", i[2][2] , " -", i[2][3] , "-", i[2][4] , "-", i[2][5]); System.out.println();
System.out.printf("%3s", "___ ___ ___ ___ ___ ___ ___ ___ ___ ___"); System.out.println();

j = j + 1 ;
k = 1 ;
 }
 }

public static void multiplication() {

int[][] i = new int[2+1][5+1];
int j = 1;
int k = 1;

while (j <= 10){

while (k <= 5){

i[1][k] = (int) (Math.random() * 9 + 1) ;
i[2][k] = (int) (Math.random() * 9 + 1) ;

k = k + 1 ;

 }

System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", " ", i[1][1] , " ", i[1][2] , " ", i[1][3] , " ", i[1][4] , " ", i[1][5]); System.out.println();
System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", "*", i[2][1] , "*", i[2][2] , "*", i[2][3] , "*", i[2][4] , "*", i[2][5]); System.out.println();
System.out.printf("%3s", "___ ___ ___ ___ ___ ___ ___ ___ ___ ___"); System.out.println();

j = j + 1 ;
k = 1 ;
 }

 }

public static void division() {

int[][] i = new int[2+1][5+1];
int j = 1;
int k = 1;
int l;

while (j <= 10){

while (k <= 5){

i[1][k] = (int) (5 + Math.random() * 26) ;
i[2][k] = (int) (1 + Math.random() * 9) ;

if (i[1][k] < i[2][k]) {
l = i[1][k] ;
i[1][k] = i[2][k] ;
i[2][k] = l ;
 }

k = k + 1 ;

 }

System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s", i[1][1] , "/", i[2][1] , " ", i[1][2] , "/", i[2][2] , " ", i[1][3] , "/", i[2][3] , " ", i[1][3] , "/", i[2][3] , " ", i[1][4] , "/", i[2][4] , " ", i[1][5] , "/", i[2][5]); System.out.println();


j = j + 1 ;
k = 1 ;
 }

 }
}
