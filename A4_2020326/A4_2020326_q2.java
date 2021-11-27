import java.util.*;

//question 2
class matri{
	protected String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

class gray<T>extends matri{
	private int[][] gray;
	private T rows;
	private T cols;
	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public T getCols() {
		return cols;
	}

	public void setCols(T cols) {
		this.cols = cols;
	}

	public int[][] getGray() {
		return gray;
	}

	public void setGray(int[][] matrix) {
		this.gray = matrix;
	}
//	public void print(T[][] ts) {
//		for(int i=0;i<ts.length;i++) {
//			for(int j=0;j<ts[0].length;j++) {
//				System.out.print(ts[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
	public void print() {
		System.out.println("gray");
		for(int i=0;i<this.getGray().length;i++) {
			for(int j=0;j<this.getGray()[0].length;j++) {
				System.out.print(this.getGray()[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void neg() {
		System.out.println("negative gray");
		for(int i=0;i<this.getGray().length;i++) {
			for(int j=0;j<this.getGray()[0].length;j++) {
				System.out.print((255-this.getGray()[i][j])+" ");
			}
			System.out.println();
		}
	}
//	public void neg() {
//		System.out.println("negative gray");
//		for(int i=0;i<(int)this.getRows();i++) {
//			for(int j=0;j<(int)this.getCols();j++) {
//				System.out.print((255-(int)this.getGray()[i][j])+" ");
//			}
//			System.out.println();
//		}
//	}
	public gray(int[][] matrix,T r,T c) {
		this.setCols(c);
		this.setGray(matrix);
		this.setRows(r);
		this.setType("gray");
	}
}
class rgb<T>extends matri{
	private int[][] red;
	private int[][] blue;
	private int[][] green;
	private T rows;
	private T cols;
	public T getRows() {
		return rows;
	}
	public void setRows(T rows) {
		this.rows = rows;
	}
	public T getCols() {
		return cols;
	}
	public void setCols(T cols) {
		this.cols = cols;
	}
	public int[][] getRed() {
		return red;
	}
	public void setRed(int[][] red2) {
		this.red = red2;
	}
	public int[][] getBlue() {
		return blue;
	}
	public void setBlue(int[][] blue2) {
		this.blue = blue2;
	}
	public int[][] getGreen() {
		return green;
	}
	public void setGreen(int[][] green2) {
		this.green = green2;
	}
//	public void display() {
//		System.out.println("red");
//		this.print(getRed());
//		System.out.println("blue");
//		this.print(getBlue());
//		System.out.println("green");
//		this.print(getGreen());
//	}
	public void print() {
		System.out.println("red");
		for(int i=0;i<this.getRed().length;i++) {
			for(int j=0;j<this.getRed()[0].length;j++) {
				System.out.print(this.getRed()[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("green");
		for(int i=0;i<this.getGreen().length;i++) {
			for(int j=0;j<this.getGreen()[0].length;j++) {
				System.out.print(this.getGreen()[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("blue");
		for(int i=0;i<this.getBlue().length;i++) {
			for(int j=0;j<this.getBlue()[0].length;j++) {
				System.out.print(this.getBlue()[i][j]+" ");
			}
			System.out.println();
		}
	}
//	public void print(T[][] ts) {
//		for(int i=0;i<ts.length;i++) {
//			for(int j=0;j<ts[0].length;j++) {
//				System.out.print(ts[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
	public void neg() {
		System.out.println("negative red");
		for(int i=0;i<this.getRed().length;i++) {
			for(int j=0;j<this.getRed()[0].length;j++) {
				System.out.print((255-this.getRed()[i][j])+" ");
			}
			System.out.println();
		}
		System.out.println("negative green");
		for(int i=0;i<this.getGreen().length;i++) {
			for(int j=0;j<this.getGreen()[0].length;j++) {
				System.out.print((255-this.getGreen()[i][j])+" ");
			}
			System.out.println();
		}
		System.out.println("negative blue");
		for(int i=0;i<this.getBlue().length;i++) {
			for(int j=0;j<this.getBlue()[0].length;j++) {
				System.out.print((255-this.getBlue()[i][j])+" ");
			}
			System.out.println();
		}
	}
//	public <E> void neg(E arp) {
//		System.out.println("negative red");
//		for(int i=0;i<(int)this.getRows();i++) {
//			for(int j=0;j<(int)this.getCols();j++) {
//				System.out.print((255-this.getRed()[i][j])+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("negative blue");
//		for(int i=0;i<(int)this.getRows();i++) {
//			for(int j=0;j<(int)this.getCols();j++) {
//				System.out.print((255-this.getBlue()[i][j])+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("negative green");
//		for(int i=0;i<(int)this.getRows();i++) {
//			for(int j=0;j<(int)this.getCols();j++) {
//				System.out.print((255-this.getRed()[i][j])+" ");
//			}
//			System.out.println();
//		}
//	}
	public rgb(int[][] red2,int[][] blue2,int[][] green2,T ro,T co) {
		this.setBlue(blue2);
		this.setGreen(green2);
		this.setRed(red2);
		this.setCols(co);
		this.setRows(ro);
		this.setType("rgb");
	}
}
public class A4_2020326_q2 {
//	public void neg(int[][] matrix) {
//		for(int i=0;i<matrix.length;i++) {
//			for(int j=0;j<matrix[0].length;j++) {
//				System.out.print((255-matrix[i][j])+ " ");
//			}
//			System.out.println();
//		}
//	}
//	public static <T>void neg(T[][]matrix){
//		for(int i=0;i<matrix.length;i++) {
//			for(int j=0;j<matrix[0].length;j++) {
//				System.out.print((255-(int)matrix[i][j])+" ");
//			}
//			System.out.println();
//		}
//	}
	public static <T> void neg(T one) {
		matri m=(matri)one;
		if(checker(m)) {
			gray<Integer>g=(gray<Integer>)one;
			g.neg();
		}else {
			rgb<Integer>regebl=(rgb<Integer>)one;
			regebl.neg();
		}
	}
	public static boolean checker(matri m) {
		return m.getType().equalsIgnoreCase("gray");
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int id=0;
		HashMap<Integer, Object>matrices=new HashMap<>();
		while(true) {
			System.out.println("enter 0 to input matrix,\n1 to create default matrix,\n2 to update matrix,\n3 to display,\n4 to compute negative of matrix,\n5 to end program");
			int n=Integer.parseInt(scan.nextLine());
			if(n==0) {
				System.out.println("enter 0 for grayscale matrix,\n1 for rgb matrix");
				int ch=Integer.parseInt(scan.nextLine());
				if(ch==0) {
					System.out.println("enter the number of rows");
					int rows=Integer.parseInt(scan.nextLine());
					System.out.println("enter the number of columns");
					int cols=Integer.parseInt(scan.nextLine());
					int[][] matrix =new int[rows][cols];
					for(int i=0;i<rows;i++) {
						for(int j=0;j<cols;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							matrix[i][j]=Integer.parseInt(scan.nextLine());
							if(matrix[i][j]<0||matrix[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					gray<Integer> g=new gray<Integer>(matrix, rows, cols);
					System.out.println("matrix has been created with id "+id);
					matrices.put(id++, g);
				}else if (ch==1) {
					System.out.println("enter the number of rows");
					int rows=Integer.parseInt(scan.nextLine());
					System.out.println("enter the number of columns");
					int cols=Integer.parseInt(scan.nextLine());
					System.out.println("enter red matrix");
					int[][]red=new int[rows][cols];
					int[][]blue=new int[rows][cols];
					int[][]green=new int[rows][cols];
					for(int i=0;i<rows;i++) {
						for(int j=0;j<cols;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							red[i][j]=Integer.parseInt(scan.nextLine());
							if(red[i][j]<0||red[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					System.out.println("enter green matrix");
					for(int i=0;i<rows;i++) {
						for(int j=0;j<cols;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							green[i][j]=Integer.parseInt(scan.nextLine());
							if(green[i][j]<0||green[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					System.out.println("enter blue matrix");
					for(int i=0;i<rows;i++) {
						for(int j=0;j<cols;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							blue[i][j]=Integer.parseInt(scan.nextLine());
							if(blue[i][j]<0||blue[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					rgb<Integer>regebl=new rgb<Integer>(red, blue, green, rows, cols);
					System.out.println("matrix has been created with id "+id);
					matrices.put(id++, regebl);
				}else {
					System.out.println("error: incorrect input please try again");
				}
			}else if (n==1) {
				System.out.println("enter 0 for grayscale matrix,\n1 for rgb matrix");
				int ch=Integer.parseInt(scan.nextLine());
				if(ch==0) {
					System.out.println("enter the number of rows");
					int rows=Integer.parseInt(scan.nextLine());
					System.out.println("enter the number of columns");
					int cols=Integer.parseInt(scan.nextLine());
					int[][] matrix =new int[rows][cols];
					gray<Integer>g=new gray<Integer>(matrix, rows, cols);
					System.out.println("matrix has been created with id "+id);
					matrices.put(id++, g);
				}else if (ch==1) {
					System.out.println("enter the number of rows");
					int rows=Integer.parseInt(scan.nextLine());
					System.out.println("enter the number of columns");
					int cols=Integer.parseInt(scan.nextLine());
					int[][]red=new int[rows][cols];
					int[][]blue=new int[rows][cols];
					int[][]green=new int[rows][cols];
					rgb<Integer>regebl=new rgb<Integer>(red, blue, green, rows, cols);
					System.out.println("matrix has been created with id "+id);
					matrices.put(id++, regebl);
				}else {
					System.out.println("error: incorrect input please try again");
				}
			}else if (n==2) {
				System.out.println("please enter id of matrix you want to update");
				int idd=Integer.parseInt(scan.nextLine());
				matri m= (matri) matrices.get(idd);
				if(checker(m)) {
					gray<Integer>g= (gray<Integer>) m;
					int[][] matrix=new int[g.getRows()][g.getCols()];
					for(int i=0;i<matrix.length;i++) {
						for(int j=0;j<matrix[0].length;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							matrix[i][j]=Integer.parseInt(scan.nextLine());
							if(matrix[i][j]<0||matrix[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					g.setGray(matrix);
				}else {
					rgb<Integer>regebl=(rgb<Integer>)m;
					int[][]red=new int[regebl.getRows()][regebl.getCols()];
					int[][]green=new int[regebl.getRows()][regebl.getCols()];
					int[][]blue=new int[regebl.getRows()][regebl.getCols()];
					System.out.println("enter the new red matrix");
					for(int i=0;i<regebl.getRed().length;i++) {
						for(int j=0;j<regebl.getRed()[0].length;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							red[i][j]=Integer.parseInt(scan.nextLine());
							if(red[i][j]<0||red[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					System.out.println("enter the new green matrix");
					for(int i=0;i<regebl.getGreen().length;i++) {
						for(int j=0;j<regebl.getGreen()[0].length;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							green[i][j]=Integer.parseInt(scan.nextLine());
							if(green[i][j]<0||green[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					System.out.println("enter the new blue matrix");
					for(int i=0;i<regebl.getBlue().length;i++) {
						for(int j=0;j<regebl.getBlue()[0].length;j++) {
							System.out.println("enter element of row "+i+" and column "+j);
							blue[i][j]=Integer.parseInt(scan.nextLine());
							if(blue[i][j]<0||blue[i][j]>255) {
								System.out.println("error:value should be between 0 and 255");
								j--;
							}
						}
					}
					regebl.setBlue(blue);
					regebl.setGreen(green);
					regebl.setRed(red);
				}
			}else if (n==3) {
				System.out.println("please enter id of matrix you want to print");
				int idd=Integer.parseInt(scan.nextLine());
				matri m= (matri) matrices.get(idd);
				if(checker(m)) {
					gray<Integer>g=(gray<Integer>)m;
					g.print();
				}else {
					rgb<Integer>regebl=(rgb<Integer>)m;
					regebl.print();
				}
			}else if (n==4) {
				System.out.println("please enter id of matrix you want to find negative of");
				int idd=Integer.parseInt(scan.nextLine());
				matri m= (matri) matrices.get(idd);
				if(checker(m)) {
					gray<Integer>g=(gray<Integer>)m;
					neg(g);
				}else {
					rgb<Integer>regebl=(rgb<Integer>)m;
					neg(regebl);
				}
			}else if(n==5){
				break;
			}else {
				System.out.println("error:incorrect input\ntry again");
			}
		}
		System.out.println("end of test case");
		scan.close();
	}
}

