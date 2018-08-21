import java.util.Scanner;
public class Ex6{
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        int[] vetor = new int[10];

        System.out.println("Digite 10 numeros:");
        for (int i = 0; i < 10; i++){
            vetor[i] = scan.nextInt();
        }
        int soma = vetor[0], maior = vetor[0], menor = vetor[0];
		
        for (int i = 1; i < 10; i++){
            soma += vetor[i];
            if (vetor[i] > maior){
                maior = vetor[i];
            } else if(vetor[i] < menor) {
                menor = vetor[i];
			}
        }
        float media = soma / 10;
        System.out.printf("A soma de todos os numeros e %d\nA media de todos os numeros e %.2f\nO maior numero e %d\nO menor numero e %d", soma, media, maior, menor);
    }
}