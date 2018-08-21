public class Ex4 {
    public static void main(String args[]) {
		float peso = Float.parseFloat(args[0]);
		float altura = Float.parseFloat(args[1]);
		float imc = peso/(altura*altura);
		System.out.println("Seu IMC: " + imc);
        }
}   