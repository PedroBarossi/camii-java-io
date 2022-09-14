/*Crie a classe Gato com os atributos nome, idade e cor;
1-Instancie um objeto e serialize;
2-Desserialize este objeto e mostre no console
 */
package dataobjeto;

import java.io.*;

public class Exercicio6 {

    public static void main(String[] args) {
       try {
            //serializar();
            desserializar("C:\\Users\\pedro\\Documents\\workspace\\camii-java-io\\gato");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao serializar");
        } catch (ClassNotFoundException ce) {
            System.out.println("Ocorreu um erro ao desserializar");
        }

    }

    public static void serializar() throws IOException {
        Gato gato = new Gato("Mel", 32, "Branco");

        File f = new File("gato");

        /*OutputStream os = new FileOutputStream(f.getName());
        ObjectOutputStream oos = new ObjectOutputStream(os);*/
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        oos.writeObject(gato);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho: '%d' bytes.", f.getName(), f.length());

        oos.close();
        ps.close();
    }

    public static void desserializar(String arquivo) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Gato objetoGato = (Gato) ois.readObject();

        System.out.printf("\nNome.....................: %s\n", objetoGato.getNome());
        System.out.printf("Idade....................: %d\n", objetoGato.getIdade());
        System.out.printf("Cor......................: %s\n", objetoGato.getCor());
        System.out.println(objetoGato);

        ois.close();

    }
}