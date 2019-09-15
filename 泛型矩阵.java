1、GenericMatrix类

public abstract class GenericMatrix<E extends Number> {

/**
* Abstract method for adding two elements of the matrices
* @param o1
* @param o2
* @return
*/
protected abstract E add(E o1, E o2);

/**
* Abstract method for myltiplying two elements of the matrices
* @param o1
* @param o2
* @return
*/
protected abstract E multiply(E o1, E o2);

/**
* Abstract method for defining zero for the matrix element
* @return
*/
protected abstract E zero();

/**
* add two matrices
* @param matrix1
* @param matrix2
* @return
*/
public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {

if (matrix1.length != matrix2.length
|| matrix1[0].length != matrix2[0].length) {
throw new RuntimeException("The matrices do not have the save size");
}

E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];
for (int i = 0; i < matrix1.length; i++) {
for (int j = 0; j < matrix1[i].length; j++) {
result[i][j] = add(matrix1[i][j], matrix2[i][j]);
}
}
return result;
}

/**
* Myltiply two matrices
* @param matrix1
* @param matrix2
* @return
*/
public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {

if (matrix1[0].length != matrix2.length) {
throw new RuntimeException(
"The matrices do not have compatible size");
}

E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];
for (int i = 0; i < result.length; i++) {
for (int j = 0; j < result[0].length; j++) {
result[i][j] = zero();
for (int k = 0; k < matrix1[i].length; k++) {
result[i][j] = add(result[i][j],
multiply(matrix1[i][k], matrix2[k][j]));
}
}
}
return result;
}

/**
* Print matrices, the operator, and their operation result
* @param m1
* @param m2
* @param m3
* @param op
*/
public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3,
char op) {

for (int i = 0; i < m1.length; i++) {
for (int j = 0; j < m1[0].length; j++) {
System.out.print(" " + m1[i][j]);
}
if (i == m1.length / 2) {
System.out.print(" " + op + " ");
}
else {
System.out.print(" ");
}

for (int j = 0; j < m2.length; j++) {
System.out.print(" " + m2[i][j]);
}
if (i == m1.length / 2) {
System.out.print(" = ");
}
else {
System.out.print(" ");
}
for (int j = 0; j < m3.length; j++) {
System.out.print(m3[i][j] + " ");
}
System.out.println();
}
}
}

2、IntegerMatrix类

public class IntegerMatrix extends GenericMatrix<Integer> {

@Override
protected Integer add(Integer o1, Integer o2) {

// TODO Auto-generated method stub
return o1 + o2;
}

@Override
protected Integer multiply(Integer o1, Integer o2) {

// TODO Auto-generated method stub
return o1 * o2;
}

@Override
protected Integer zero() {

// TODO Auto-generated method stub
return 0;
}

}

3、RationalMatrix类

public class RationalMatrix extends GenericMatrix<Rational> {

@Override
protected Rational add(Rational o1, Rational o2) {

// TODO Auto-generated method stub
return o1.add(o2);
}

@Override
protected Rational multiply(Rational o1, Rational o2) {

// TODO Auto-generated method stub
return o1.multiple(o2);
}

@Override
protected Rational zero() {

// TODO Auto-generated method stub
return new Rational(0, 1);
}

}

4、Rational类

public class Rational extends Number implements Comparable {

private long numerator;// 分子
private long denominator;// 分母

/**
* @param args
*/
public static void main(String[] args) {

// TODO Auto-generated method stub
Rational rational1 = new Rational(1, 10);
Rational rational2 = new Rational(1, -10);
System.out.println(rational1.add(rational2));
System.out.println(rational1.subtract(rational2));
System.out.println(rational1.multiple(rational2));
System.out.println(rational1.divide(rational2));
}

public Rational() {

// TODO Auto-generated constructor stub
this(0, 1);

}

public Rational(long numerator, long denominator) {

long gcd = gcd(numerator, denominator);
this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
this.denominator = Math.abs(denominator) / gcd;
}

public static long gcd(long a, long b) {

long n1 = Math.abs(a);
long n2 = Math.abs(b);
long remainder = n1 % n2;
while (remainder > 0) {
n1 = n2;
n2 = remainder;
remainder = n1 % n2;
}
return n2;
}

public long getNumerator() {

return numerator;
}

public long getDenominator() {

return denominator;
}

public Rational add(Rational secondRational) {

long n = numerator * secondRational.getDenominator() + denominator
* secondRational.getNumerator();
long d = denominator * secondRational.getDenominator();
return new Rational(n, d);
}

public Rational subtract(Rational secondRational) {

long n = numerator * secondRational.getDenominator() - denominator
* secondRational.getNumerator();
long d = denominator * secondRational.getDenominator();
return new Rational(n, d);
}

public Rational multiple(Rational secondRational) {

long n = numerator * secondRational.getNumerator();
long d = denominator * secondRational.getDenominator();
return new Rational(n, d);
}

public Rational divide(Rational secondRational) {

long n = numerator * secondRational.getDenominator();
long d = denominator * secondRational.getNumerator();
return new Rational(n, d);
}

@Override
public boolean equals(Object obj) {

// TODO Auto-generated method stub
if (this.subtract((Rational) obj).getNumerator() == 0) {
return true;
}
else {
return false;
}
}

@Override
public String toString() {

// TODO Auto-generated method stub
if (denominator == 1) {
return String.valueOf(numerator);
}
else {
return numerator + "/" + denominator;
}
}

@Override
public int intValue() {

// TODO Auto-generated method stub
return (int) doubleValue();
}

@Override
public long longValue() {

// TODO Auto-generated method stub
return (long) doubleValue();
}

@Override
public float floatValue() {

// TODO Auto-generated method stub
return (float) doubleValue();
}

@Override
public double doubleValue() {

// TODO Auto-generated method stub
return numerator * 1.0 / denominator;
}

@Override
public int compareTo(Object o) {

// TODO Auto-generated method stub
if (this.subtract((Rational) o).getNumerator() > 0) {
return 1;
}
else if (this.subtract((Rational) o).getNumerator() < 0) {
return -1;
}
else {
return 0;
}
}
}

5、TestIntegerMatrix 类

public class TestIntegerMatrix {

/**
* @param args
*/
public static void main(String[] args) {

// TODO Auto-generated method stub
Integer[][] m1 = new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 },
{ 1, 1, 1 } };
Integer[][] m2 = new Integer[][] { { 1, 1, 1 }, { 2, 2, 2 },
{ 0, 0, 0 } };
IntegerMatrix integerMatrix = new IntegerMatrix();
System.out.println("\nm1 + m2 is ");
IntegerMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');

System.out.println("\nm1 * m2 is ");
IntegerMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2),
'*');
}

}

6、TestRationalMatrix 类

public class TestRationalMatrix {

/**
* @param args
*/
public static void main(String[] args) {

// TODO Auto-generated method stub
Rational[][] m1 = new Rational[3][3];
Rational[][] m2 = new Rational[3][3];
for (int i = 0; i < m1.length; i++) {
for (int j = 0; j < m1[0].length; j++) {
m1[i][j] = new Rational(i + 1, j + 5);
m2[i][j] = new Rational(i + 1, j + 6);
}
}
RationalMatrix rationalMatrix = new RationalMatrix();
System.out.println("\nm1 + m2 is ");
RationalMatrix.printResult(m1, m2, rationalMatrix.addMatrix(m1, m2),
'+');

System.out.println("\nm1 * m2 is ");
RationalMatrix.printResult(m1, m2,
rationalMatrix.multiplyMatrix(m1, m2), '*');
}

}