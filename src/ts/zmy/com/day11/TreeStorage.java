package ts.zmy.com.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ts.zmy.com.day11.TreeNode;

/**
 * 每次手动输入树太麻烦，将它写到本地备用
 * 
 * @author user
 *
 */
public class TreeStorage {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("请输入路径:");
		String filePath = sc.nextLine();
		TreeNode root = createTree();
		writeTree(root, filePath);
	}

	public static TreeNode createTree() {
		int num = sc.nextInt();
		if (num == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(num);
		System.out.println("left");
		treeNode.left = createTree();
		System.out.println("right");
		treeNode.right = createTree();
		return treeNode;
	}

	public static TreeNode readTree(String filePath) throws IOException, FileNotFoundException, ClassNotFoundException {
		File file = new File(filePath);
		System.out.println(file.getCanonicalPath());
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		TreeNode root = (TreeNode) objectInputStream.readObject();
		objectInputStream.close();
		return root;
	}

	public static void writeTree(TreeNode root, String filePath) throws IOException, FileNotFoundException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
		objectOutputStream.writeObject(root);
		System.out.println("serialize success");
		objectOutputStream.close();
	}
}
