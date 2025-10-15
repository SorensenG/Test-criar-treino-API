import com.gymhub.models.Trainings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


//        System.out.println("Bem vindo ao seu programa de treino!");
//        System.out.println("Digite 1 para criar um treino personalizado.");
//        System.out.println("Digite 2 para sair.");
//        System.out.println("Digite 3 para ver os exercicios disponiveis.");
//
//
//        var key = "b5rCo+FkZu7nL+P88O6KWg==nVqxJjMZZ0UEqdJk";
//        var uri = URI.create(
//                "https://api.api-ninjas.com/v1/exercises?name=&muscle=&type=&difficulty="
//        );
//        var req = HttpRequest.newBuilder(uri)
//                .header("X-Api-Key", key)
//                .GET()
//                .build();
//        var client = HttpClient.newHttpClient();
//        var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
//        System.out.println(resp.body());


        System.out.println(2);

//            Exercise.fromPtInputs(
//                    "supino",
//                    "peito",
//                    "força",
//                    "intermediario"
//            );

        System.out.println("-----------------------------------");
        System.out.println("Bem vindo ao GymHub - Seu assistente pessoal de treinos!");
        System.out.println("-----------------------------------");
        System.out.println("Vamos começar criando seu treino personalizado.");
        Trainings train = new Trainings();

        System.out.println("Digite 1 para criar um dia de treino personalizado.");
        System.out.println("Digite 2 para ver os seus dias de treino.");
        System.out.println("Digite 3 para sair.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (true) {
            switch (choice) {
                case 1:
                    Trainings trainings = new Trainings();
                    int counter = 0;
                    while (counter < 1 || counter > 5) {
                        System.out.println("Quantos dias de treino você quer criar? (máximo 5 dias)");
                        counter = scanner.nextInt();
                        scanner.nextLine();
                    }
                    for (int i = 0; i < counter; i++) {
                        System.out.println("Criando o dia de treino " + (i + 1) + ":");
                        System.out.println("Digite o nome do dia de treino (ex: Treino de Peito):");
                        String day = scanner.nextLine();
                        trainings.addTrain(day);
                    }
                    trainings.viewTrainingDays();
                    break;
                case 2:
                    new Trainings().viewTrainingDays();
                    break;

                case 3:
                    System.out.println("Saindo do programa. Até a próxima!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }


    }

}
