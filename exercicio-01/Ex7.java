import java.util.Scanner;
public class Ex7 {
    public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome do aluno: ");
		String nome = scan.nextLine();
		float[] vetor = new float[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Digite a nota da M"+(i+1)+": ");
			vetor[i] = scan.nextFloat();
		}
		float media = (vetor[0] + vetor[1] + vetor[2])/3;
			System.out.println("Aluno: " + nome);
			System.out.println("Media: " + media);
		if (media >= 6){
			System.out.println("Situacao: Aprovado");
		} else {
			System.out.println("Situacao: Reprovado");
		}
	}
}  