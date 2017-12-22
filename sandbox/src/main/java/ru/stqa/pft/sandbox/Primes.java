package ru.stqa.pft.sandbox;

public class Primes {

  // int i = 2 - инициализаци
  // i < n - где счетчик должен оставновиться
  // i += 1(i++) - что происходит с переменной счетчика на каждой итерации переменной

  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0){
      i++;
    }
    return i == n;
  }


  public static boolean isPrime(long n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeFast(int n) {
    for (int i = 2; i < n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeFastTwo(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}



