package XmlEncoder;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExemploXMLEncoder {
  private static final String FILENAME = "ficheiroDeDadosEmXML.xml";

  public static void main(String[] args) {
    try {
      // Create a list of String objects ...
      final List<String> list = new ArrayList<String>();
      list.add(new String("Manuel Jaquim"));
      list.add(new String("Maria Albertina"));
      

      System.out.println("Vou escrever a lista para o ficheiro: " + FILENAME + ": " + list);

      // serializar para XML
      final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
          new FileOutputStream(FILENAME)));
      encoder.writeObject(list);
      encoder.close();

      // Deserializar de XML
      final XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
      final List<String> listFromFile = (List<String>) decoder.readObject();
      decoder.close();

      System.out.println("Lista Lida: " + listFromFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}