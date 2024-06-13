# Day 32

## Desafio:

	Implemente um sistema de login e registro em Java utilizando conceitos de criptografia para armazenamento seguro de senhas.

**Resultado:**


```java

public class Day032 {

    public static void main(String[] args) {
        Day032 day032 = new Day032();
        day032.validorDeLogin("edvaldo122@gmail", "909012345");

    }

    public static void validorDeLogin(String email, String senha) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(emailRegex) && senha != null && senha.length() > 0) {
            System.out.println("Seu login foi efetuado com sucesso");
        } else {
            System.out.println("Seu login não foi efetuado com sucesso");
        }

    }

}
