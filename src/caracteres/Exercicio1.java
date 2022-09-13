package caracteres;

import java.io.*;

/*Abra o teclado para escrever três filmes que você
/recomendaria e exiba esses filmes no console*/
public class Exercicio1 {
    public static void main(String[] args){
        try {
            receberTecladoImprimirConsole();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
        }
    }

    public static void receberTecladoImprimirConsole() throws IOException {
        System.out.println("Recomende 3 filmes:");

        /*InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        /*OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!(line.isEmpty()));

        bw.flush();

        br.close();
        bw.close();
    }
}
