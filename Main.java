

import java.util.Scanner;


public class Main {


    Scanner input = new Scanner(System.in);
    public String[][] clients = new String[100][2];
    public String[][] mecanics = new String[100][3];
    public String[][] vehicles = new String[100][3];
    public String[][] reparacions = new String[100][3];


    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }


    public void init() {
        int menuItem = 0;
        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Modificar reparació");
            System.out.println("[6] Sortir");
            System.out.println("Sel·lecciona una opció: ");


            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        altaNouClient();
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        altaNouMecanic();
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        introduirNouVehicle();
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        crearFitxaNovaReparacio();
                        break;
                    case 5:
                        System.out.println("Has triat modificar reparació....");
                        modificarReparacio();
                        break;
                    case 6:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            } else {
                System.out.println("Opció no vàlida");
            }
            input.nextLine(); // Limpiar el buffer del scanner
            System.out.println("");


        } while (menuItem != 6);
    }


    private void altaNouClient() {
        System.out.println("Introdueix el DNI del client:");
        String dni = input.next();


        // Validar el formato del DNI
        if (!dni.matches("\\d{8}[A-Za-z]")) {
            System.out.println("El format del DNI no és vàlid. Ha de ser de 8 digits seguits d'una lletra.");
            return;
        }


        // Validar que el DNI no existeixi prèviament
        for (int i = 0; i < clients.length; i++) {
            if (clients[i][0] != null && clients[i][0].equalsIgnoreCase(dni)) {
                System.out.println("Aquest DNI ja existeix. Si us plau, introdueix un altre.");
                return;
            }
        }


        System.out.println("Introdueix el nom del client:");
        String nom = input.next();


        // Validar que el nom del client no estigui buit
        if (nom.trim().isEmpty()) {
            System.out.println("El nom del client no pot ser buit.");
            return;
        }


        // Afegir el nou client
        for (int i = 0; i < clients.length; i++) {
            if (clients[i][0] == null) {
                clients[i][0] = dni;
                clients[i][1] = nom;
                System.out.println("Client afegit amb èxit.");
                return;
            }
        }


        System.out.println("No es poden afegir més clients. S'ha assolit el límit.");
    }
