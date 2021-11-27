import java.util.*;
//question 1
class book<T,S>{
	private T title;
	private S isbn;
	private S barcode;
	public T getTitle() {
		return title;
	}
	public void setTitle(T title) {
		this.title = title;
	}
	public S getIsbn() {
		return isbn;
	}
	public void setIsbn(S isbn) {
		this.isbn = isbn;
	}
	public S getBarcode() {
		return barcode;
	}
	public void setBarcode(S barcode) {
		this.barcode = barcode;
	}
	public book(T ti,S isbn,S bar) {
		this.setBarcode(bar);
		this.setIsbn(isbn);
		this.setTitle(ti);
	}
}

class sorter implements Comparator<book<String,Long>>{
	public int compare(book<String,Long>a,book<String,Long>b) {
		if(a.getTitle().compareToIgnoreCase(b.getTitle())!=0) {
			return a.getTitle().compareToIgnoreCase(b.getTitle());
		}else {
			if(a.getIsbn()-b.getIsbn()!=0) {
				return (int) (a.getIsbn()-b.getIsbn());
			}else {
				return (int) (a.getBarcode()-b.getBarcode());
			}
		}
	}
}

public class A4_2020326_q1 {
	public static boolean unique(ArrayList<Object>array,long bar) {
		for(int i=0;i<array.size();i++) {
			book<String,Long>b=(book<String,Long>)array.get(i);
			if(bar==b.getBarcode()) {
				return false;
			}
		}
		return true;
	}
	public static boolean after(ArrayList<Object>books,int a,int b) {
		book<String,Long>at=(book<String,Long>)books.get(a);
		book<String,Long>bt=(book<String,Long>)books.get(b);
		if(at.getTitle().compareToIgnoreCase(bt.getTitle())>0) {
			return true;
		}else if (at.getTitle().compareToIgnoreCase(bt.getTitle())<0) {
			return false;
		}else {
			if(at.getIsbn()>bt.getIsbn()) {
				return true;
			}else if (at.getIsbn()<bt.getIsbn()) {
				return false;
			}else {
				if(at.getBarcode()>bt.getBarcode()) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
	public static int[]slot(ArrayList<Object>array,long id,int n,int k,int nk){
		int[]ans=new int[2];
		int j=0;
		for(int i=0;i<array.size();i++) {
			book<String,Long>b=(book<String,Long>)array.get(i);
			if(id==b.getBarcode()) {
				j=i+1;
				break;
			}
		}
		if(j%nk==0) {
			ans[1]=nk;
		}else {
			ans[1]=j%nk;
		}
		do {
			ans[0]++;
			j=j-nk;
		}while(j>0);
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<Object>books=new ArrayList<>();
		System.out.println("enter the number of books");
		int n=Integer.parseInt(scan.nextLine());
		System.out.println("enter the number of racks");
		int r=Integer.parseInt(scan.nextLine());
		for(int i=0;i<n;i++) {
			System.out.println("for "+(i+1)+"book");
			System.out.println("enter title");
			String title=scan.nextLine();
			System.out.println("enter ISBN number");
			long isbn=Long.parseLong(scan.nextLine());
//			boolean flag=false;
//			long bar = 0;
//			while(flag!=true) {
//				System.out.println("enter barcode");
//				bar=Long.parseLong(scan.nextLine());
//				if(!unique(books, bar)) {
//					System.out.println("error:the barcode isn't unique please try again");
//				}else {
//					flag=true;
//				}
//			}
			System.out.println("enter bar code");
			long bar=Long.parseLong(scan.nextLine());
			if(!unique(books, bar)) {
				System.out.println("error:the barcode isn't unique please try again");
				i--;
				continue;
			}
			book<String,Long>b=new book<String, Long>(title, isbn, bar);
			books.add(b);
		}
//		Collections.sort(books, new sorter());
//		Collections.sort(books, new sorter());
		for(int i=0;i<books.size()-1;i++) {
			for(int j=0;j<books.size()-i-1;j++) {
				if(after(books, j, j+1)) {
					Collections.swap(books, j, j+1);
				}
			}
		}
		while (true) {
			System.out.println("enter 0 to find the slot of a book, enter 1 to exit the test case");
			int choicer=Integer.parseInt(scan.nextLine());
			if(choicer==0) {
				System.out.println("enter barcode of book whose slot you want");
				long barrer=Long.parseLong(scan.nextLine());
				int[]arr=slot(books, barrer, n, r, n/r);
				System.out.println("the rack number is "+arr[0]+" and the slot number is "+arr[1]);
			}else if (choicer==1) {
				break;
			}else {
				System.out.println("error:incorrect input please try again");
			}
		}
		System.out.println("end of test case");
		scan.close();
	}
}
