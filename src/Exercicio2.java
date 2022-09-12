import java.io.*;
import java.util.Scanner;

/*Abra o teclado para escrever 3 álbuns que você recomendaria
e armazene em recomendacoes.txt
 */
public class Exercicio2 {
    public static void main(String[] args){
        try{
            lerTecladoEscreverDocumento();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
        }
    }

    public static void lerTecladoEscreverDocumento() throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite três recomendações de álbuns: ");
        pw.flush();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        File f = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = scanner.nextLine();
        } while(!line.equalsIgnoreCase("fim"));

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());
        //pw.flush();
        pw.close();
        scanner.close();
        bw.close();

    }
}
