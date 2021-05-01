package lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PrimaryScreen {

	static String directory;
	public File folderName;

	public PrimaryScreen() {
		directory = System.getProperty("user.dir");
		folderName = new File(directory, "/UserStoredFiles");
		if (!folderName.exists())
			folderName.mkdirs();
		System.out.println("Directory : " + folderName.getAbsolutePath());
	}

	private static final String mainMenu = "\nMAIN MENU - Select any of the following : \n"
			+ "1. List files in directory \n" + "2. Add, Delete or Search \n" + "3. Exit Program \n";

	private static final String secondMenu = "Select any of the following : \n" + "1. Add a file \n"
			+ "2. Delete a file \n" + "3. Search a file \n" + "4. Go Back to Main Menu";

	@SuppressWarnings("resource")
	void showPrimaryMenu() {
		System.out.println(mainMenu);
		try {
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				showFiles();
				showPrimaryMenu();
			}
			case 2: {
				showSecondaryMenu();
			}
			case 3: {
				System.out.println("Application closed now !!!");
				System.exit(0);
			}
			default:
				System.out.println("You have selected INVALID OPTION\n" + "\nPlease Enter 1, 2, or 3");
				showPrimaryMenu();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("You have selected INVALID OPTION\n" + "\nPlease Enter 1, 2, or 3");
			showPrimaryMenu();
		}
	}

	void showFiles() {
		if (folderName.list().length == 0) {
			System.out.println("The folder is empty\n");
		} else {
			String[] list = folderName.list();
			System.out.println("Files present in the directory - " + folderName + " : \n");
			Arrays.sort(list);
			for (String str : list) {
				System.out.println(str);
			}
			// System.out.println("Press any key to go back to Main Menu");
			// showPrimaryMenu();
		}
	}

	@SuppressWarnings("resource")
	void showSecondaryMenu() {
		System.out.println(secondMenu);
		try {
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Please enter file name you would like to Add : \n");
				String filename = scanner.next().trim().toLowerCase();
				addFile(filename);
				break;

			}
			case 2: {
				System.out.println("Please enter file name you would like to Delete : \n");
				String filename = scanner.next().trim();
				deleteFile(filename);
				break;
			}
			case 3: {
				System.out.println("Please enter file name you would like to Search : \n");
				String filename = scanner.next().trim();
				searchFile(filename);
				break;
			}
			case 4: {
				System.out.println("************ Welcome back to Main Menu ************\n");
				showPrimaryMenu();
				break;
			}
			default:
				System.out.println("You have selected INVALID OPTION\n" + "\nPlease Enter 1, 2, 3, or 4\n");
			}
			showSecondaryMenu();
		} catch (Exception e) {
			System.out.println("You have selected INVALID OPTION\n" + "\nPlease Enter 1, 2, 3, or 4\n");
			showSecondaryMenu();
		}
	}

	private void searchFile(String filename) {
		String[] list = folderName.list();
		for (String string : list) {
			if (filename.equals(string)) {
				System.out.println("Your file : " + filename + " found in the directory " + folderName);
				return;
			}
		}
		System.out.println("Sorry but your file doesn't exist");
	}

	private void deleteFile(String filename) {
		File filepath = new File(folderName + "/" + filename);
		String[] list = folderName.list();
		for (String string : list) {
			if (filename.equals(string) && filepath.delete()) {
				System.out.println("Your file " + filename + " is deleted from " + folderName);
				return;
			}
		}
		System.out.println("Sorry but your file doesn't exist");
	}

	private void addFile(String filename) throws IOException {
		File filepath = new File(folderName + "/" + filename);
		String[] list = folderName.list();
		for (String string : list) {
			if (filename.equalsIgnoreCase(string)) {
				System.out.println("The File you are trying to Add " + filename + "already exists at " + folderName);
				return;
			}
		}
		filepath.createNewFile();
		System.out.println("Your file " + filename + " added to " + folderName);

	}

}
