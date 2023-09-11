package classcode.p15Swing.p10Sound;

import javax.swing.ImageIcon;

public class C01ImageManager {

	static public enum Images {
		PUFFERFISH("puffer_fish.png"), PUFFERFISH2("puffer_fish.png");

		String fileName;
		ImageIcon ic = null;
		static private String basePathname = "images/";

		Images(String fileName) {
			this.fileName = fileName;
		};

		public String getPath() {
			return fileName;
		}

		public ImageIcon getImageIcon() {
			if (ic != null)
				return ic;
			String path = basePathname + fileName;
			// getResource - verifica se o recurso existe
			java.net.URL imgURL = C01ImageManager.class.getResource(path);
			if (imgURL == null) {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
			ic = new ImageIcon(imgURL);
			System.out.println("Image: " + path + " loaded");
			return ic;
		}

		void setImageIcon(ImageIcon ic) {
			this.ic = ic;
		}
	}
}
