import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double diferenca(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        if (b == 0) {
            System.out.println("Operação inválida!!!Houve uma divisão por 0."); 
        }
        
        return a/b;
    }

    public static double fatorial(double s) {
        if (s == (int) s && s >= 0) {
            double result = 1;
            for (int i = 2; i <= s; i++) {
                result *= i;
            }
            return result;
        }
        else {
            double product = 1;
            int n = 1_000_000;
            
            for (int k = 1; k < n; k++) {
                product *= ((double) k / (s + k));
            }
            
            double resultado = (Math.pow(n, s) / s) * product;
            double escala = Math.pow(10, 6);
            
            return Math.round(resultado * escala) / escala;
        }
    }
}
