public class hello {

	public static void main(String[] args) {




System.out.println( "Addition");
addition();
System.out.println( "Subtraction");
subtraction();
System.out.println( "Multiplication");
multiplication();
System.out.println( "Division");
division();


 }


public static void addition {

int[][] i = new int[2][5];
int j = 1;
int k = 1;

while (j <= 10){

while (k <= 5){

i[1][k] = 3 ;
i[2][k] = 4 ;

k = k + 1 ;

 }

System.out.println( " ", i(1,1), " ", i(1,2), " ", i(1,3), " ", i(1,4), " ", i(1,5));
System.out.println( " +", i(2,1), " +", i(2,2), " +", i(2,3), " +", i(2,4), " +", i(2,5));
System.out.println( " ___ ___ ___ ___ ___");
System.out.println( " ");

j = j + 1 ;
k = 1 ;
 }

 }


public static void subtraction {
int[][] i = new int[2][5];
int j = 1;
int k = 1;
int l;

while (j <= 10){

while (k <= 5){

i[1][k] = 3 ;
i[2][k] = 4 ;

if (i[1][k] < i[2][k]) {
l = i[1][k] ;
i[1][k] = i[2][k] ;
i[2][k] = l ;
 }

k = k + 1 ;

 }

System.out.println( " ", i(1,1), " ", i(1,2), " ", i(1,3), " ", i(1,4), " ", i(1,5));
System.out.println( " -", i(2,1), " -", i(2,2), " -", i(2,3), " -", i(2,4), " -", i(2,5));
System.out.println( " ___ ___ ___ ___ ___");
System.out.println( " ");

j = j + 1 ;
k = 1 ;
 }
 }

public static void multiplication {

int[][] i = new int[2][5];
int j = 1;
int k = 1;

while (j <= 10){

while (k <= 5){

i[1][k] = 3 ;
i[2][k] = 4 ;

k = k + 1 ;

 }

System.out.println( " ", i(1,1), " ", i(1,2), " ", i(1,3), " ", i(1,4), " ", i(1,5));
System.out.println( " *", i(2,1), " *", i(2,2), " *", i(2,3), " *", i(2,4), " *", i(2,5));
System.out.println( " ___ ___ ___ ___ ___");
System.out.println( " ");

j = j + 1 ;
k = 1 ;
 }

 }

public static void division {

int[][] i = new int[2][5];
int j = 1;
int k = 1;

while (j <= 10){

while (k <= 5){

i[1][k] = 3 ;
i[2][k] = 4 ;

if (i[1][k] < i[2][k]) {
l = i[1][k] ;
i[1][k] = i[2][k] ;
i[2][k] = l ;
 }

k = k + 1 ;

 }

System.out.println( i(1,1), "/", i(2,1), " ", i(1,2), "/", i(2,2), " ", i(1,3), "/", i(2,3), " ", i(1,3), "/", i(2,3), " ", i(1,4), "/", i(2,4), " ", i(1,5), "/", i(2,5));
System.out.println( " ");

j = j + 1 ;
k = 1 ;
 }

 }
}
