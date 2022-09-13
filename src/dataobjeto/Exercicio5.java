/*Crie um arquivo roupas.bin e armazene:
-Nome do produto;
-Tamanho (P/M/G/U);
-Quantidade;
-Preço.
Leia este arquivo e imprima no console*/
package dataobjeto;

import java.io.*;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        try {
            incluirProduto();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
        }
    }

    public static void incluirProduto() throws IOException {
        File f = new File("C:\\Users\\pedro\\Documents\\workspace\\camii-java-io\\peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        /*OutputStream os = new FileOutputStream(f.getPath());
        DataOutputStream dos = new DataOutputStream(os);*/
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.print("Nome da peça: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho da peça (P/M/G/U): ");
        char tamanho = (char) System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preco = scan.nextDouble();
        dos.writeDouble(preco);

        dos.close();
        scan.close();
    }

    public static void lerProduto(String arquivo) {

    }
}
