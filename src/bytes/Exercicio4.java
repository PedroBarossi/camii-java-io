//Faça uma cópia do arquivo recomendacoes-copy.txt
package bytes;

import java.io.*;

public class Exercicio4 {

    public static void main(String[] args) {
        try {
            copiarArquivo();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
        }
    }

    private static void copiarArquivo() throws IOException {
        File f = new File("C:\\Users\\pedro\\Documents\\workspace\\camii-java-io\\recomendacoes-copy.txt");
        String nomeArquivo = f.getName();

        /*InputStream is = new FileInputStream(nomeArquivo);
        BufferedInputStream bis = new BufferedInputStream(is);*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo));

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copy2.txt");
        File fCopy = new File(nomeArquivoCopy);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopy));

        int line = 0;

        while((line = bis.read()) != -1) { //quando é igual a -1 acabou o arquivo
            bos.write((char) line);
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! " +
                "Tamanho do arquivo: '%d' bytes. \n", fCopy.getName(), fCopy.length());
    }
}
