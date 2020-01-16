package misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserialization {

	public static void main(String[] args) {
		////////////SERIALIZATION
		// Create object
		TestSerialization ts = new TestSerialization(1,2);
		try {
			FileOutputStream fo = new FileOutputStream("Serialization.txt");
			try {
				ObjectOutputStream oos = new ObjectOutputStream(fo);
				oos.writeObject(ts);
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DESERIALIZATION
		
		
		try {
			FileInputStream fo = new FileInputStream("Serialization.txt");
			ObjectInputStream in  = new ObjectInputStream(fo);
			try {
				TestSerialization ts1 = (TestSerialization)(in.readObject());
				System.out.println(ts1.a);
				System.out.println(ts1.b);
				in.close();
				fo.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class TestSerialization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 99999999999L;
	int a;
	transient int b; 
	public TestSerialization(int i, int j) {
		a = i;
		b = j;
	}
}

