import java.util.Scanner;

class ExercicioDois {
    public static void resolve() {
        System.out.println("Resultado Exercicio Dois:");
        System.err.println("--------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite um número em decimal: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o número da base que deseja converter: ");
        System.out.println("1 - Binário");
        System.out.println("2 - Octal");
        System.out.println("3 - Hexadecimal");
        System.out.printf("Sua escolha: ");
        int option = Integer.parseInt(scanner.nextLine());

        String result = "";
        switch (option) {
            case 1:
                result = NumberConverter.toBinary(number, false);
                break;
            case 2:
                result = NumberConverter.toOctal(number, false);
                break;
            case 3:
                result = NumberConverter.toHexadecimal(number, false);
                break;
        }

        System.out.printf("A conversão do número %d é: '%s'\r\n", number, result);

        scanner.close();
    }
}