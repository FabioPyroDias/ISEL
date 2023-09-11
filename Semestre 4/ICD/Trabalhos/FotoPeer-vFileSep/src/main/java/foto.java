

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;




/**
 * @author Engº Porfírio Filipe
 * 
 */
@SuppressWarnings("serial")
public class foto implements Serializable {
	String path = null;  	// caminho
	String mime = null;	 	// tipo
	byte[] content = null;	// conteudo
	public static final String contexto= "src"+ File.separator + "main"+ File.separator + "webapp"; // "WebContent";

	/**
	 * construtor por omissao
	 */
	public foto() {
	}

	/**
	 * @param p caminho
	 * @param m tipo
	 */
	public foto(final String p, final String m) {
		path = p;
		mime = m;
		load();
	}

	/**
	 * carrega a foto a partir do ficheiro 
	 * @return sucesso
	 */
	public boolean load() {
		if (path != null) {
			File fi = new File(path);
			if (fi.exists())
				try {
					content = Files.readAllBytes(fi.toPath());
					return true;
				} catch (final IOException e) {
					// e.printStackTrace();
					System.err.println("Falhou a abertura do ficheiro com o nome '" + path+ "'!");
					return false;
				}
			else
				System.err.println("Não encontrou o fihciero com o nome '" + path+ "'!");
		}
		return false;
	}

	/**
	 * cópia
	 */
	
	public void copia(foto f) {
		path = f.path;
		mime = f.mime;
		content = f.content;
	}
	/**
	 * Guarda o ficheiro indicado em argumento
	 * Fazendo backup/rename se o ficheiro existir
	 * @return sucesso
	 */
	
	public boolean save(String dataFile) {
		if(dataFile==null)
			dataFile = path;
		String bkFile = dataFile + new Date().getTime();
		final File file = new File(dataFile);
		if (file.exists()) {
			if (!file.renameTo(new File(bkFile))) {
				System.err.println("Falhou a alteração do nome '" + dataFile
						+ "' do ficheiro para '" + bkFile + "'!");
				return false;
			} //else {
				// System.out.println("Ficheiro de backup gerado '" + bkFile+
				// "'!");
				//}
		}
		
		try {
			File f = new File(dataFile);
			Path path = Paths.get(f.getAbsolutePath());
			Files.write(path, content);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @return existe
	 */
	public boolean isOk() {
		return path != null;
	}

	/**
	 * @return mime
	 */
	public String getMime() {
		return mime;
	}

	/**
	 * @return caminho
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return conteudo
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * 
	 */
	public void setContent(byte[] c) {
		content = c;
	}

	/**
	 * conversão para string na base 64
	 * 
	 * @return conteudo
	 */

	public String getStrContent() {
		if (getContent() != null)
			return myBase64.encode(getContent());
		return null;
	}
	
	/**
	 * conversão de base 64 para string
	 * @param content
	 */
	
	public void setStrContent(String content) {
		if (content != null)
			setContent(myBase64.decode(content));
	}


	/**
	 * 
	 */
	 public void show() {
		System.out.println(" Foto:");
		if (path != null) {
			System.out.println("  Path = " + path);
			System.out.println("  Mime = " + mime);
		}
		if (content == null)
			System.out.println("Não existe conteudo em memória!");
		else {
			System.out.println("Conteudo em memória! ("+content.length+")");
			new ImageDemo(content);
		}
	} 

	/**
	 * seria a foto para um ficheiro
	 */
	public boolean seriar(FileOutputStream fileOut) {
		try
	      {
	         ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
	         outputStream.writeObject(this);
	         outputStream.close();
	         return true;
	      }catch(IOException e)
	      {
	          e.printStackTrace();
	      }
		return false;
	}
	
	public void seriar(Socket socket) throws IOException {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				socket.getOutputStream());) {
			outputStream.writeObject(this);
		}
	}
	/**
	 * 
	 */
	public boolean deseriar (FileInputStream fileIn) {
	      try
	      {
	         ObjectInputStream inputStream = new ObjectInputStream(fileIn);
	         copia((foto)inputStream.readObject());
	         inputStream.close();
	         return true;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         c.printStackTrace();
	      }
	      return false;
	}
	/**
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public void deseriar (Socket socket) throws ClassNotFoundException, IOException {
	      try
	      (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());)
	      {
	         copia((foto)inputStream.readObject());
	         
	      }
	}
	
	public void clientTCP(String host, int port) throws UnknownHostException,
			IOException {
		try (Socket socket = new Socket(host, port);) {

			seriar(socket);

		}
	}

	public void serverTCP(int port) throws IOException, ClassNotFoundException {
		try (

		ServerSocket serverSocket = new ServerSocket(port);
				Socket socket = serverSocket.accept();)

		{
			deseriar(socket);
		}
	}
	/**
	 * 
	 */
	
    public static String download(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException
    {
        URL imageUrl = new URL(sourceUrl);
        
    	String strPath=imageUrl.getFile();
    
    	if(strPath.lastIndexOf('?')==-1)
    		strPath=strPath.substring(strPath.lastIndexOf('/'));
    	else
    		strPath=strPath.substring(strPath.lastIndexOf('/'),strPath.lastIndexOf('?'));
        
    	try (
    			InputStream imageReader = new BufferedInputStream(imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                        new FileOutputStream(targetDirectory + File.separator + strPath));
    		)
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
            return targetDirectory + File.separator + strPath;
        }
    }
    
    private static void exemplo1() {
    	
    	foto f10 = new foto(contexto+ File.separator + "fotos"+ File.separator + "isel.jpg", "jpg");
    	f10.show();
    	
    	String xml = f10.getStrContent(); // obtem o conteudo em base64;
		System.out.println("Texto em base 64: "+xml.length());
		
		foto f3= new foto();
		f3.setStrContent(xml);  // define a nova foto a partir de string em base64;
		f3.save(contexto+ File.separator + "down"+ File.separator + "isel.jpg");  // guarda no ficheiro	
    }
    
    private static void exemplo2() {
    	try {
    		// http://www.patrimoniocultural.gov.pt/static//img/monumeu_dgpc.jpg
    		// 
    		String fich=download("https://isel.pt/media/assets/default/images/logo-isel.png",contexto+ File.separator + "down");
			//download("http://www.cm-lisboa.pt/typo3temp/pics/6d92da7172.jpg",contexto+"\\down");
    		foto f2 = new foto(fich,"");
    		f2.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static void exemplo3() {
    	/* Teste do servidor seriação */
		 
		foto f10 = new foto();
		
		try {
			f10.serverTCP(5025);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		f10.save(foto.contexto+ File.separator + "down"+ File.separator + "isel.png");
		f10.show();
    }
    
    private static void exemplo4() {
    	/* teste cliente seriação */
		
		foto f10 = new foto(foto.contexto+ File.separator + "up"+ File.separator + "isel.png", "png");
		
		try {
			f10.clientTCP("localHost", 5025);
		} catch (IOException e) {
			e.printStackTrace();
		} 
				
    }
    
    private static void exemplo5() {
    	// visualizar a imagem
    	//foto f10 = new foto(contexto+"\\fotos\\isel.jpg", "jpg");
    	foto f10 = new foto(contexto+ File.separator + "fotos"+ File.separator + "chocolates.jpg", "jpg");
    	f10.show();
    }
    
	public static void menu() {
		char op;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println();
			System.out.println("*** Menu da Foto ***");
			System.out
					.println("1 - Testar conversão base64.");
			System.out
					.println("2 – Descarrega foto de URL.");
			System.out
					.println("3 – Lança servidor para receber foto.");
			System.out.println("4 – Lança cliente para enviar foto.");
			
			System.out.println("5 – Visualizar foto.");
			
			System.out.println("0 - Terminar!");
			String str = sc.nextLine();
			if (str != null && str.length() > 0)
				op = str.charAt(0);
			else
				op = ' ';
			switch (op) {
			case '1':
				exemplo1();
				break;
			case '2':
				exemplo2();
				break;
			case '3':
				exemplo3();
				break;
			case '4':
				exemplo4();
				break;
			case '5':
				exemplo5();
				break;
			case '0': break;
			default:
				System.out.println("Opção inválida, esolha uma opção do menu.");
			}
		} while (op != '0');
		sc.close();
		System.out.println("Terminou a execução.");
		System.exit(0);
	}
    
	
	public static void main(final String[] args) {
			   
		menu();
	
	}	
}
