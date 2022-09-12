import java.io.*;

/*Faça uma cópia do arquivo recomendacoes.txt e adicione
3 recomendações de livros
 */
public class Exercício3 {
    public static void main(String[] args){
        try{
            copiarArquivo();
        } catch(IOException e) {
            System.out.println("Ocorreu um erro");
        }
    }

    public static void copiarArquivo() throws IOException {
        File f = new File("C:\\Users\\pedro\\Documents\\workspace\\camii-java-io\\recomendacoes.txt");
        String nomeArquivo = f.getName();

        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String line = br.readLine();

        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy.txt");
        File fcopy = new File(nomeArquivoCopia);

        BufferedWriter bw = new BufferedWriter(new FileWriter((fcopy.getName())));

        do{
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while (!(line == null));


        System.out.printf("Arquivo \"%s\" copiado com sucesso! " +
                "Tamanho do arquivo: '%d' bytes. \n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! " +
                "Tamanho do arquivo: '%d' bytes. \n", fcopy.getName(), fcopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarInfoAoArquivo(fcopy.getName());

        pw.printf("Tudo certo! Tamanho do arquivo '%d' bytes.", fcopy.length());

        bw.close();
        bw.close();
        pw.close();
    }

    public static void adicionarInfoAoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
        //append true adiciona info sem apagar o que já tinha

        do{
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!(line.equalsIgnoreCase("fim")));

        br.close();
        bw.close();

    }
}
