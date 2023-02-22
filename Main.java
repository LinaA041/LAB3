
import java.util.Scanner;
public class Main {

    public static   Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        circularList system = new circularList();

        int option = 5; //

        while (option!=0) {

            System.out.println("¡Bienvenido al sistema de turnos!\nDigite el numero de la opción la que desea:");
            System.out.println("1.Dar turno\n2.Mostrar turno actual\n3.Pasar turno\n4.Seguir\n0.Salir");
            option = sc.nextInt();

            if (option == 1) {
                system.darTurno();
            } else if (option == 2) {

                int actual = system.getCurrentNum();

                if (actual == -1) {

                    System.out.println("Nadie ha tomado un turno.");

                } else {
                    System.out.println("El turno actual es " +actual);
                }

            } else if (option == 3) {

                system.passTurn();
                System.out.println("Se ha avanzado al siguiente turno.");
            } else if (option == 4) {

                System.out.println("Digite el numero del paciente que ya ha sido atendido");
                int num = sc.nextInt();

                system.delete(num);
                System.out.println(" Se ha avanzado al siguiente turno");
                /*system.printAll();*/
            } else if(option==0){
                System.out.println("Gracias por usar nuestro sistema de turnos, adios");

            } else {
                System.out.println("Ingrese una option valida");
            }
        }


    }

}