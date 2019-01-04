package ts.zmy.com.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 每次手动输入树太麻烦，将它写到本地备用
 * @author user
 *
 */
public class TreeStorage {
	public static TreeNode readTree(String filePath) throws IOException, FileNotFoundException, ClassNotFoundException {
		File file =new File(filePath);
		System.out.println(file.getCanonicalPath());
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		TreeNode root = (TreeNode) objectInputStream.readObject();
		objectInputStream.close();
		return root;
	}

	public static void writeTree(TreeNode root,String filePath) throws IOException, FileNotFoundException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
		objectOutputStream.writeObject(root);
		System.out.println("serialize success");
		objectOutputStream.close();
	}
}
