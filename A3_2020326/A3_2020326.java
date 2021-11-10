import java.util.*;

class matrix{
	protected int id;
	protected String stored_as;
	protected ArrayList<String> types;
	protected int rows;
	protected int cols;
	public String getStored_as() {
		return stored_as;
	}
	public void setStored_as(String stored_as) {
		this.stored_as = stored_as;
	}
	public void setrows(int r) {
		this.rows=r;
	}
	public int getrows() {
		return this.rows;
	}
	public void setcol(int ncol) {
		this.cols=ncol;
	}
	public int getcol() {
		return this.cols;
	}
	public void setid(int newid) {
		this.id=newid;
	}
	public int getid() {
		return this.id;
	}
	public ArrayList<String> gettype() {
		return this.types;
	}
	public void addtype(String newtype) {
		this.types.add(newtype);
	}
	public void removetype(String typer) {
		this.types.remove(typer);
	}
	public void settype(ArrayList<String> ntype) {
		this.types=ntype;
	}
}
class rectangular extends matrix{
	private int[][]matrix;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public rectangular(int id,int[][]arr,int c,int r,ArrayList<String>types) {
		this.setcol(c);
		this.setid(id);
		this.setMatrix(arr);
		this.setrows(r);
		this.setStored_as("rectangular");
		this.settype(types);
	}
}
class row extends matrix{
	private int[]row;

	public int[] getRow() {
		return row;
	}

	public void setRow(int[] row) {
		this.row = row;
	}
	public row(int id,ArrayList<String>types,int r,int[]arr) {
		this.setStored_as("row");
		this.setcol(r);
		this.setid(id);
		this.setRow(arr);
		this.setrows(1);
		this.settype(types);
	}
}
class column extends matrix{
	private int[]colum;

	public int[] getColum() {
		return colum;
	}

	public void setColum(int[] colum) {
		this.colum = colum;
	}
	
	public column(int id,ArrayList<String>types,int c,int[]arr) {
		this.setStored_as("column");
		this.setcol(1);
		this.setrows(c);
		this.setid(id);
		this.setColum(arr);
		this.settype(types);
	}
}
class square extends matrix{
	private int[][]matrix;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix.clone();
	}
	public int determinant() {
		int ans=-1;			
		int[][]mat=this.getMatrix();
		if(this.getcol()==1) {
			ans=this.getMatrix()[0][0];
		}else if (this.getcol()==2) {
			ans=mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
		}else if (this.getcol()==3) {
			ans = mat[0][0]*(mat[1][1]*mat[2][2] - mat[1][2]*mat[2][1]) - mat[0][1]*(mat[1][0]*mat[2][2] - mat[2][0]*mat[1][2]) + mat[0][2]*(mat[1][0]*mat[2][1] - mat[1][1]*mat[2][0]);
		}
		return ans;
	}
	public square(int id,ArrayList<String> types,int size,int[][]arr) {
		this.setcol(size);
		this.setid(id);
		this.setMatrix(arr);
		this.setrows(size);
		this.setStored_as("square");
		this.settype(types);
	}
}
class symmetric extends matrix{
	private int[]array;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	public symmetric(int id,int size,ArrayList<String>types,int[]array) {
		this.setcol(size);
		this.setrows(size);
		this.setid(id);
		this.setArray(array);
		this.setStored_as("symmetric");
		this.settype(types);
	}
}
class skew_symmetric extends matrix{
	private int[]array;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	public skew_symmetric(int id,int size,ArrayList<String>types,int[]array) {
		this.setArray(array);
		this.setcol(size);
		this.setid(id);
		this.setrows(size);
		this.setStored_as("skew_symmetric");
		this.settype(types);
	}
}
class upper_triangular extends matrix{
	private int[]up_mat;

	public int[] getUp_mat() {
		return up_mat;
	}

	public void setUp_mat(int[] up_mat) {
		this.up_mat = up_mat;
	}
	
	public upper_triangular(int id,int size,int[]arr,ArrayList<String> types) {
		this.setcol(size);
		this.setid(id);
		this.setrows(size);
		this.setStored_as("upper_triangular");
		this.settype(types);
		this.setUp_mat(arr);
	}
}
class lower_triangular extends matrix{
	private int[]low_mat;

	public int[] getLow_mat() {
		return low_mat;
	}
	public void setLow_mat(int[] low_mat) {
		this.low_mat = low_mat.clone();
	}
	public lower_triangular(int id,int[]arr,int size,ArrayList<String> types) {
		this.setid(id);
		this.setcol(size);
		this.setrows(size);
		this.setLow_mat(arr);
		this.setStored_as("lower_triangular");
		this.settype(types);
	}
}
class singular extends matrix{
	private int[][]matrix;
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public singular(int id,int size,ArrayList<String>types,int[][]arr) {
		this.setStored_as("singular");
		this.setcol(size);
		this.setid(id);
		this.setMatrix(arr);
		this.setrows(size);
		this.settype(types);
	}
}
class diagonal extends matrix{
	private int[]diagonal;
	public int[] getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(int[] diagonal) {
		this.diagonal = diagonal.clone();
	}
	public diagonal(int[]d,int size,int id,ArrayList<String>types) {
		this.setcol(size);
		this.setDiagonal(d);
		this.setid(id);
		this.setrows(size);
		this.setStored_as("diagonal");
		this.settype(types);
	}
}
class scalar extends matrix{
	private int diagonal;
	public int getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}
	public scalar(int id,ArrayList<String>type,int data,int size) {
		this.setcol(size);
		this.setDiagonal(data);
		this.setid(id);
		this.setrows(size);
		this.settype(type);
		this.setStored_as("scalar");
	}
}
class identity extends matrix{
	public identity(ArrayList<String>types,int id,int size) {
		this.setid(id);
		this.settype(types);
		this.setStored_as("identity");
		this.setcol(size);
		this.setrows(size);
	}
}
class singleton extends matrix{
	private int element;
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public singleton(ArrayList<String> types,int id,int data) {
		this.setcol(1);
		this.setrows(1);
		this.setid(id);
		this.settype(types);
		this.setElement(data);
		this.setStored_as("singleton");
	}
}
class ones extends matrix{
	public ones(int r,int c,int id,ArrayList<String> s) {
		this.setcol(c);
		this.setid(id);
		this.setrows(r);
		this.settype(s);
		this.setStored_as("ones");
	}
}
class null_mat extends matrix{
	public null_mat(int r,int c,int id,ArrayList<String> s) {
		this.setcol(c);
		this.setid(id);
		this.setrows(r);
		this.settype(s);
		this.setStored_as("null");
	}
}
public class A3_2020326 {
	public static double[][] inv(int[][]matrix) {
		int n=matrix.length;
		double [][]ans=new double[n][n];
		double t=determinant(matrix);
		if(n==1) {
			ans[0][0]=1/matrix[0][0];
		}else if (n==2) {
			ans[0][0] = (matrix[1][1]/t);
			ans[1][1] = (matrix[0][0]/t);
			ans[1][0] = (-matrix[0][1]/t);
			ans[0][1] = (-matrix[1][0]/t);
		}else if (n==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					ans[i][j]=((matrix[(j+1)%3][(i+1)%3]*matrix[(j+2)%3][(i+2)%3])-(matrix[(j+1)%3][(i+2)%3]*matrix[(j+2)%3][(i+1)%3])/t);
				}
			}
		}
		return ans;
	}
	public static double determinant(int[][]mat) {
		double ans=-1;			
		if(mat.length==1) {
			ans=mat[0][0];
		}else if (mat.length==2) {
			ans=mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
		}else if (mat.length==3) {
			ans = mat[0][0]*(mat[1][1]*mat[2][2] - mat[1][2]*mat[2][1]) - mat[0][1]*(mat[1][0]*mat[2][2] - mat[2][0]*mat[1][2]) + mat[0][2]*(mat[1][0]*mat[2][1] - mat[1][1]*mat[2][0]);
		}
		return ans;
	}
	public static int[][]converter(matrix m){
		String p=m.getStored_as();
		int[][]ans=null;
		if(p.equalsIgnoreCase("rectangular")) {
			rectangular r=(rectangular)m;
			ans=new int[r.getrows()][r.getcol()];
			ans=r.getMatrix().clone();
		}else if (p.equalsIgnoreCase("row")) {
			row r=(row)m;
			ans=new int[r.getrows()][r.getcol()];
			for(int i=0;i<r.getcol();i++) {
				ans[0][i]=r.getRow()[i];
			}
		}else if (p.equalsIgnoreCase("column")) {
			column c=(column)m;
			ans=new int[c.getrows()][c.getcol()];
			for(int i=0;i<c.getrows();i++) {
				ans[i][0]=c.getColum()[i];
			}
		}else if (p.equalsIgnoreCase("square")) {
			square s=(square)m;
			ans=new int[s.getrows()][s.getcol()];
			for(int i=0;i<s.getrows();i++) {
				for(int j=0;j<s.getcol();j++) {
					ans[i][j]=s.getMatrix()[i][j];
				}
			}
		}else if (p.equalsIgnoreCase("symmetric")) {
			symmetric s=(symmetric)m;
			int k=0;
			ans=new int[s.getrows()][s.getcol()];
			for(int i=0;i<s.getrows();i++) {
				for(int j=0;j<=i;j++) {
					ans[i][j]=s.getArray()[k++];
					ans[j][i]=ans[i][j];
				}
			}
		}else if (p.equalsIgnoreCase("skew_symmetric")) {
			skew_symmetric s=(skew_symmetric)m;
			int k=0;
			ans=new int[s.getrows()][s.getcol()];
			for(int i=0;i<s.getrows();i++) {
				for(int j=0;j<i;j++) {
					ans[i][j]=s.getArray()[k++];
					ans[j][i] = -ans[i][j];
				}
			}
		}else if (p.equalsIgnoreCase("upper_triangular")) {
			upper_triangular u=(upper_triangular)m;
			int k=0;
			ans=new int[u.getrows()][u.getcol()];
			for(int i=0;i<u.getrows();i++) {
				for(int j=0;j<=i;j++) {
					ans[i][j]=u.getUp_mat()[k++];
				}
			}
		}else if (p.equalsIgnoreCase("lower_triangular")) {
			lower_triangular l=(lower_triangular)m;
			int k=0;
			ans=new int[l.getrows()][l.getcol()];
			for(int i=0;i<l.getrows();i++) {
				for(int j=i;j<l.getcol();j++) {
					ans[i][j]=l.getLow_mat()[k++];
				}
			}
		}else if (p.equalsIgnoreCase("singular")) {
			singular s=(singular)m;
			ans=s.getMatrix();
		}else if (p.equalsIgnoreCase("diagonal")) {
			diagonal d=(diagonal)m;
			ans=new int[d.getrows()][d.getcol()];
			for(int i=0;i<d.getrows();i++) {
				ans[i][i]=d.getDiagonal()[i];
			}
		}else if (p.equalsIgnoreCase("scalar")) {
			scalar s=(scalar)m;
			ans=new int[s.getrows()][s.getcol()];
			for(int i=0;i<ans.length;i++) {
				ans[i][i]=s.getDiagonal();
			}
		}else if (p.equalsIgnoreCase("identity")) {
			identity i=(identity)m;
			ans=new int[i.getrows()][i.getcol()];
			for(int j=0;j<ans.length;j++) {
				ans[j][j]=1;
			}
		}else if (p.equalsIgnoreCase("singleton")) {
			ans=new int[1][1];
			singleton s=(singleton)m;
			ans[0][0]=s.getElement();
		}else if (p.equalsIgnoreCase("ones")) {
			ones o=(ones)m;
			ans=new int[o.getrows()][o.getcol()];
			for(int i=0;i<ans.length;i++) {
				for(int j=0;j<ans[0].length;j++) {
					ans[i][j]=1;
				}
			}
		}else if (p.equalsIgnoreCase("null")) {
			null_mat n=(null_mat)m;
			ans=new int[n.getrows()][n.getcol()];
		}
		return ans;
	}
	
	public static int[][]inverse(int[][]matrix){
		int n=matrix.length;
		int ans[][]=new int[n][n];
		double t=determinant(matrix);
		if(n==1) {
			ans[0][0]=1/matrix[0][0];
		}else if (n==2) {
			ans[0][0] = (int) (matrix[1][1]/t);
			ans[1][1] = (int) (matrix[0][0]/t);
			ans[1][0] = (int) (-matrix[0][1]/t);
			ans[0][1] = (int) (-matrix[1][0]/t);
		}else if (n==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					ans[i][j]=(int) ((matrix[(j+1)%3][(i+1)%3]*matrix[(j+2)%3][(i+2)%3])-(matrix[(j+1)%3][(i+2)%3]*matrix[(j+2)%3][(i+1)%3])/t);
				}
			}
		}
		return ans;
	}
	public static double[][]mult(int[][]one,double[][]two){
		if(one[0].length!=two.length) {
			System.out.println("error: incorrect dimension of matrices");
			return null;
		}
		double[][]ans=new double[one.length][two[0].length];
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=0;
				for(int k=0;k<two.length;k++) {
					ans[i][j]+=one[i][k]*two[k][j];
				}
			}
		}
		return ans;
	}
	public static double[][]mult(double[][]one,int[][]two){
		if(one[0].length!=two.length) {
			System.out.println("error: incorrect dimension of matrices");
			return null;
		}
		double[][]ans=new double[one.length][two[0].length];
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=0;
				for(int k=0;k<two.length;k++) {
					ans[i][j]+=one[i][k]*two[k][j];
				}
			}
		}
		return ans;
	}
	public static int[][]mult(int[][]one,int[][]two){
		if(one[0].length!=two.length) {
			System.out.println("error: incorrect dimension of matrices");
			return null;
		}
		int[][]ans=new int[one.length][two[0].length];
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=0;
				for(int k=0;k<two.length;k++) {
					ans[i][j]+=one[i][k]*two[k][j];
				}
			}
		}
		return ans;
	}
	
	public static boolean[]checker(int[][]matrix){
		boolean[]is=new boolean[15];
		for(int i=0;i<is.length;i++) {
			is[i]=false;
		}
		is[0]=true;
		if(matrix.length==1) {
			is[1]=true;
		}
		if(matrix[0].length==1) {
			is[2]=true;
		}
		if(matrix.length==matrix[0].length) {
			is[3]=true;
			is[4]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					if(matrix[i][j]!=matrix[j][i]) {
						is[4]=false;
						break;
					}
				}
				if(is[4]=false) {
					break;
				}
			}
			is[5]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=i+1;j<matrix[0].length;j++) {
					if(matrix[i][j]+matrix[j][i]!=0) {
						is[5]=false;
						break;
					}
				}
				if(is[5]==false) {
					break;
				}
			}
			is[6]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=i+1;j<matrix[0].length;j++) {
					if(matrix[i][j]!=0) {
						is[6]=false;
						break;
					}
				}
				if(is[6]==false) {
					break;
				}
			}
			is[7]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<i;j++) {
					if(matrix[i][j]!=0) {
						is[7]=false;
						break;
					}
				}
				if(is[7]==false) {
					break;
				}
			}
			if(determinant(matrix)==0) {
				is[8]=true;
			}
			is[9]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					if(i!=j&&matrix[i][j]!=0) {
						is[9]=false;
						break;
					}
				}
				if(!is[9]) {
					break;
				}
			}
			is[10]=true;
			int anst=matrix[0][0];
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					if(i!=j&&matrix[i][j]!=0) {
						is[10]=false;
						break;
					}
				}
				if(matrix[i][i]!=anst) {
					is[10]=false;
					break;
				}
				if(!is[10]) {
					break;
				}
			}	
			is[11]=true;
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					if(i!=j&&matrix[i][j]!=0) {
						is[11]=false;
						break;
					}
				}
				if(matrix[i][i]!=1) {
					is[11]=false;
					break;
				}
				if(!is[11]) {
					break;
				}
			}
		}
		if(matrix.length==1&&matrix[0].length==1) {
			is[12]=true;
		}
		is[13]=true;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]!=1) {
					is[13]=false;
					break;
				}
			}
			if(!is[13]) {
				break;
			}
		}
		is[14]=true;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]!=0) {
					is[14]=false;
					break;
				}
			}
			if(!is[14]) {
				break;
			}
		}
		return is;
	}
	
	public static int storeas(boolean[]is) {
		if(is[14]==true) {
			return 14;
		}
		if(is[13]==true) {
			return 13;
		}
		if(is[12]) {
			return 12;
		}
		if(is[1]) {
			return 1;
		}
		if(is[2]) {
			return 2;
		}
		if(is[3]) {
			if(is[11]) {
				return 11;
			}
			if(is[10]) {
				return 10;
			}
			if(is[9]) {
				return 9;
			}
			for(int i=4;i<9;i++) {
				if(is[i]) {
					return i;
				}
			}
			return 3;
		}
		return 0;
	}
	
	public static double[]eigenvalue(int[][]matrix){
		int a=matrix[0][0];
		int b=matrix[0][1];
		int c=matrix[1][0];
		int d=matrix[1][1];
		double ans[]=new double[2];
		ans[0]=((a+d)+Math.sqrt(Math.pow(a-d,2) + 4*b*c))/2;
		ans[1]=((a+d)-Math.sqrt(Math.pow(a-d,2) + 4*b*c))/2;
		return ans;
	}
	public static void eigenvector(int[][]matrix,double[]val){
		double ei1=val[0];
		double ei2=val[1];
		if(matrix[0][0]-ei1==0) {
			System.out.println("eigenvector 1: 0, 0");
		}else {
			double a1=-matrix[0][1]/(matrix[0][0]-ei1);
			System.out.println("eigenvector 1: 1, "+a1);
		}
		if(matrix[0][0]-ei2==0) {
			System.out.println("eigenvector 2: 0,0");
		}else {
			double a2=-matrix[0][1]/(matrix[0][0]-ei2);
			System.out.println("eigenvector 2: 1, "+a2);
		}
	}
	public static void main(String[] args) {
		int[][]def_rect= new int[][]{{1,2,3},{4,5,6}};
		int[]def_row= new int[]{1,2,3};
		int[]def_col= new int[]{1,2,3};
		int[][]def_square= new int[][]{{1,2},{3,4}};
		int[]def_symm= new int[]{1,2,3};//{{1,2},{2,3}};
		int[]def_skew= new int[]{0,2,0};//{{0,2},{-2,0}};
		int[]def_upp= new int[]{1,2,3};//{{1,2},{0,3}};
		int[]def_low= new int[]{1,2,3};//{{1,0},{2,3}};
		int[][]def_singular= new int[][]{{1,2},{1,2}};
		int[]def_diag= new int[] {1,2,3};
		int def_scalar=2;
		int def_singleton=2;
		String[]typerd=new String[]{"rectangular","row","column","square","symmetric","skew_symmetric","upper_triangular","lower_triangular","singular","diagonal","scalar","identity","singleton","ones","null"};
		int ids=0;
		HashMap<Integer, matrix>matlist=new HashMap<>();
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n"
					+ "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n"
					+ "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n"
					+ "4. Display all the matrix-type labels of a requested matrix.\n"
					+ "5. Perform addition, subtraction, multiplication & division.\n"
					+ "6. Perform element-wise operations.\n"
					+ "7. Transpose matrices.\n"
					+ "8. Inverse matrices.\n"
					+ "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n"
					+ "10. Compute determinants.\n"
					+ "11. Use singleton matrices as scalars, if requested.\n"
					+ "12. Compute A+AT for a matrix A.\n"
					+ "13. Compute Eigen vectors and values.\n"
					+ "14. Solve sets of linear equations using matrices.\n"
					+ "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n"
					+ "16. Exit");
			int n=Integer.parseInt(scan.nextLine());
			if(n==1) {
				System.out.println("enter number of rows in matrix");
				int rows=Integer.parseInt(scan.nextLine());
				System.out.println("enter number of columns in matrix");
				int cols=Integer.parseInt(scan.nextLine());
				int matrix[][]=new int[rows][cols];
				for(int i=0;i<rows;i++) {
					for(int j=0;j<cols;j++) {
						System.out.println("enter "+(j+1)+" element of "+(i+1)+ "row");
						matrix[i][j]=Integer.parseInt(scan.nextLine());
					}
				}
				boolean []is=checker(matrix);
				int as=storeas(is);
				ArrayList<String>et=new ArrayList<>();
				for(int i=0;i<15;i++) {
					if(is[i]) {
						et.add(typerd[i]);
					}
				}
				matrix temp=null;
				if(as==0) {
					temp=new rectangular(ids, matrix, cols, rows,et);
					matlist.put(ids++, temp);
				}else if (as==1) {
					int[]ro=new int[cols];
					for(int i=0;i<matrix[0].length;i++) {
						ro[i]=matrix[0][i];
					}
					temp=new row(ids, et, cols, ro);
					matlist.put(ids++, temp);
				}else if (as==2) {
					int[]co=new int[rows];
					for(int i=0;i<matrix.length;i++) {
						co[i]=matrix[i][0];
					}
					temp=new column(ids, et, rows, co);
					matlist.put(ids++, temp);
				}else if (as==3) {
					temp=new square(ids, et, cols, matrix);
					matlist.put(ids++, temp);
				}else if (as==4) {
					int l=rows*(rows+1)/2;
					int []array=new int[l];
					int k=0;
					for(int i=0;i<matrix.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matrix[i][j];
						}
					}
					temp=new symmetric(ids, cols, et, array);
					matlist.put(ids++, temp);
				}else if (as==5) {
					int l=rows*(rows+1)/2;
					int[]array=new int[l];
					int k=0;
					for(int i=0;i<matrix.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matrix[i][j];
						}
					}
					temp=new skew_symmetric(ids, cols, et, array);
					matlist.put(ids++, temp);
				}else if (as==6) {
					int l=rows*(rows+1)/2;
					int[]array=new int[l];
					int k=0;
					for(int i=0;i<matrix.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matrix[i][j];
						}
					}
					temp=new upper_triangular(ids, cols, array, et);
					matlist.put(ids++, temp);
				}else if (as==7) {
					int l=rows*(rows+1)/2;
					int[]array=new int[l];
					int k=0;
					for(int i=0;i<matrix.length;i++) {
						for(int j=i;j<matrix[0].length;j++) {
							array[k++]=matrix[i][j];
						}
					}
					temp=new lower_triangular(ids, array, cols, et);
					matlist.put(ids++, temp);
				}else if (as==8) {
					temp=new singular(ids, cols, et, matrix);
					matlist.put(ids++, temp);
				}else if (as==9) {
					int[]array=new int[rows];
					for(int i=0;i<matrix.length;i++) {
						array[i]=matrix[i][i];
					}
					temp=new diagonal(array, cols, ids, et);
					matlist.put(ids++, temp);
				}else if (as==10) {
					temp=new scalar(ids, et, matrix[0][0], cols);
					matlist.put(ids++, temp);
				}else if (as==11) {
					temp=new identity(et, ids, cols);
					matlist.put(ids++, temp);
				}else if (as==12) {
					temp=new singleton(et, ids, matrix[0][0]);
					matlist.put(ids++, temp);
				}else if (as==13) {
					temp=new ones(rows, cols, ids, et);
					matlist.put(ids++, temp);
				}else if (as==14) {
					temp=new null_mat(rows, cols, ids, et);
					matlist.put(ids++, temp);
				}
				System.out.println("the matrix has been stored with id "+(ids-1));
			}else if (n==2) {
				System.out.println("enter the number of type of matrix you want");
				System.out.println("1. Rectangular Matrix\n"
						+ "2. Row Matrix\n"
						+ "3. Column Matrix\n"
						+ "4. Square Matrix\n"
						+ "5. Symmetric Matrix\n"
						+ "6. Skew-symmetric Matrix\n"
						+ "7. Upper-triangular Matrix\n"
						+ "8. Lower-triangular Matrix\n"
						+ "9. Singular Matrix\n"
						+ "10. Diagonal Matrix\n"
						+ "11. Scalar Matrix\n"
						+ "12. Identity Matrix\n"
						+ "13. Singleton Matrix\n"
						+ "14. Ones Matrix\n"
						+ "15. Null Matrix");
				int choice=Integer.parseInt(scan.nextLine());
				matrix temp=null;
				if(choice==1) {
					ArrayList<String>et=new ArrayList<>();
					et.add("rectangular");
					temp=new rectangular(ids, def_rect, def_rect[0].length, def_rect.length, et);
					matlist.put(ids++, temp);
				}else if (choice==2) {
					ArrayList<String>et=new ArrayList<>();
					et.add("rectangular");
					et.add("row");
					temp=new row(ids, et, def_row.length, def_row);
					matlist.put(ids++, temp);
				}else if (choice==3) {
					ArrayList<String>et=new ArrayList<>();
					et.add("rectangular");
					et.add(typerd[2]);
					temp=new column(ids, et, def_col.length, def_col);
					matlist.put(ids++, temp);
				}else if (choice==4) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					temp=new square(ids, et, def_square.length, def_square);
					matlist.put(ids++, temp);
				}else if (choice==5) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[4]);
					temp=new symmetric(ids,2, et, def_symm);
					matlist.put(ids++, temp);
				}else if (choice==6) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[5]);
					temp=new skew_symmetric(ids,2, et, def_skew);
					matlist.put(ids++, temp);
				}else if (choice==7) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[6]);
					temp=new upper_triangular(ids, 2, def_upp, et);
					matlist.put(ids++, temp);
				}else if (choice==8) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[7]);
					temp=new lower_triangular(ids, def_low, 2, et);
					matlist.put(ids++, temp);
				}else if (choice==9) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[8]);
					temp=new singular(ids, 2, et, def_singular);
					matlist.put(ids++, temp);
				}else if (choice==10) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[4]);
					et.add(typerd[6]);
					et.add(typerd[7]);
					et.add(typerd[9]);
					temp=new diagonal(def_diag, 2, ids, et);
					matlist.put(ids++, temp);
				}else if (choice==11) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[4]);
					et.add(typerd[6]);
					et.add(typerd[7]);
					et.add(typerd[9]);
					et.add(typerd[10]);
					temp=new scalar(ids, et, def_scalar, 2);
					matlist.put(ids++, temp);
				}else if (choice==12) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[3]);
					et.add(typerd[4]);
					et.add(typerd[6]);
					et.add(typerd[7]);
					et.add(typerd[9]);
					et.add(typerd[10]);
					et.add(typerd[11]);
					temp=new identity(et, ids, 2);
					matlist.put(ids++, temp);
				}else if (choice==13) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[1]);
					et.add(typerd[2]);
					et.add(typerd[3]);
					et.add(typerd[4]);
					et.add(typerd[6]);
					et.add(typerd[7]);
					et.add(typerd[9]);
					et.add(typerd[10]);
					et.add(typerd[12]);
					temp=new singleton(et, ids, def_singleton);
					matlist.put(ids++, temp);
				}else if (choice==14) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[13]);
					temp=new ones(2, 3, ids, et);
					matlist.put(ids++, temp);
				}else if (choice==15) {
					ArrayList<String>et=new ArrayList<>();
					et.add(typerd[0]);
					et.add(typerd[15]);
					temp=new null_mat(2, 3, ids, et);
					matlist.put(ids++, temp);
				}
				System.out.println("the id of input matrix was "+(ids-1));
			}else if (n==3) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				int tempr=te.getrows();
				int tempc=te.getcol();
				int matr[][]=new int[tempr][tempc];
				for(int i=0;i<tempr;i++) {
					for(int j=0;j<tempc;j++) {
						System.out.println("enter "+(j+1)+" element of "+(i+1)+ "row");
						matr[i][j]=Integer.parseInt(scan.nextLine());
					}
				}
				boolean []is=checker(matr);
				int as=storeas(is);
				if(!te.getStored_as().equalsIgnoreCase(typerd[as])) {
					System.out.println("error matrix type will change");
					continue;
				}
				ArrayList<String>et=new ArrayList<>();
				for(int i=0;i<15;i++) {
					if(is[i]) {
						et.add(typerd[i]);
					}
				}
				if(as==0) {
					te=new rectangular(inpid, def_singular, tempc, tempr, et);
				}else if (as==1) {
					int[]ro=new int[tempc];
					for(int i=0;i<matr[0].length;i++) {
						ro[i]=matr[0][i];
					}
					te=new row(inpid, et, tempr, ro);
				}else if (as==2) {
					int[]co=new int[tempr];
					for(int i=0;i<matr.length;i++) {
						co[i]=matr[i][0];
					}
					te=new column(inpid, et, tempc, co);
				}else if (as==3) {
					te=new square(inpid, et, as, matr);
				}else if (as==4) {
					int l=tempr*(tempr+1)/2;
					int []array=new int[l];
					int k=0;
					for(int i=0;i<matr.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matr[i][j];
						}
					}
					te=new symmetric(inpid, k, et, array);
				}else if (as==5) {
					int l=tempr*(tempr+1)/2;
					int []array=new int[l];
					int k=0;
					for(int i=0;i<matr.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matr[i][j];
						}
					}
					te=new skew_symmetric(inpid, k, et, array);
				}else if (as==6) {
					int l=tempr*(tempr+1)/2;
					int []array=new int[l];
					int k=0;
					for(int i=0;i<matr.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matr[i][j];
						}
					}
					te=new upper_triangular(inpid, k, array, et);
				}else if (as==7) {
					int l=tempr*(tempr+1)/2;
					int []array=new int[l];
					int k=0;
					for(int i=0;i<matr.length;i++) {
						for(int j=0;j<=i;j++) {
							array[k++]=matr[i][j];
						}
					}
					te=new lower_triangular(inpid, array, tempc, et);
				}else if (as==8) {
					te=new singular(inpid, as, et, matr);
				}else if (as==9) {
					int[]array=new int[tempr];
					for(int i=0;i<matr.length;i++) {
						array[i]=matr[i][i];
					}
					te=new diagonal(def_diag, as, inpid, et);
				}else if (as==10) {
					te=new scalar(inpid, et, matr[0][0], tempc);
				}else if (as==11) {
					te=new identity(et, inpid, tempc);
				}else if (as==12) {
					te=new singleton(et, inpid, matr[0][0]);
				}else if (as==13) {
					te=new ones(tempr, tempc, inpid, et);
				}else if (as==14) {
					te=new null_mat(tempr, tempc, inpid, et);
				}
			}else if (n==4) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				ArrayList<String>er=te.gettype();
				for(int i=0;i<er.size();i++) {
					System.out.println(er.get(i)+ " matrix ");
				}
			}else if (n==5) {
				System.out.println("enter id of first matrix");
				int first=Integer.parseInt(scan.nextLine());
				System.out.println("enter id of second matrix");
				int second=Integer.parseInt(scan.nextLine());
				matrix on=matlist.get(first);
				matrix tw=matlist.get(second);
				int[][]onet=converter(on);
				int[][]twont=converter(tw);
				System.out.println("enter 0 for addition, 1 for subtraction, 2 for multiplication, 3 for division");
				int cho=Integer.parseInt(scan.nextLine());
				int tempero[][]=new int[on.getrows()][on.getcol()];
				if(cho==0) {
					if(on.getcol()!=tw.getcol()||on.getrows()!=tw.getrows()) {
						System.out.println("matrices have different dimensions: please try again and choose different matrices");
						continue;
					}
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]+twont[i][j];
							System.out.print(tempero[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==1) {
					if(on.getcol()!=tw.getcol()||on.getrows()!=tw.getrows()) {
						System.out.println("matrices have different dimensions: please try again and choose different matrices");
						continue;
					}
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]-twont[i][j];
							System.out.print(tempero[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==2) {
					int[][]out=mult(onet, twont);
					if(out==null) {
						continue;
					}
					for(int i=0;i<out.length;i++) {
						for(int j=0;j<out[0].length;j++) {
							System.out.print(out[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==3) {
					if(tw.gettype().contains("singular")) {
						System.out.println("error matrix has no inverse");
						continue;
					}
					double[][]out=inv(twont);
					double[][]ans=mult(onet, out);
					if(ans==null) {
						continue;
					}
					for(int i=0;i<ans.length;i++) {
						for(int j=0;j<ans[0].length;j++) {
							System.out.print(ans[i][j]+" ");
						}
						System.out.println();
					}
				}else {
					System.out.println("error: incorrect choice input");
				}
			}else if (n==6) {
				System.out.println("enter id of first matrix");
				int first=Integer.parseInt(scan.nextLine());
				System.out.println("enter id of second matrix");
				int second=Integer.parseInt(scan.nextLine());
				matrix on=matlist.get(first);
				matrix tw=matlist.get(second);
				int[][]onet=converter(on);
				int[][]twont=converter(tw);
				if(on.getcol()!=tw.getcol()||on.getrows()!=tw.getrows()) {
					System.out.println("matrices have different dimensions: please try again and choose different matrices");
					continue;
				}
				System.out.println("enter 0 for addition, 1 for subtraction, 2 for multiplication, 3 for division");
				int cho=Integer.parseInt(scan.nextLine());
				int tempero[][]=new int[on.getrows()][on.getcol()];
				if(cho==0) {
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]+twont[i][j];
						}
					}
				}else if (cho==1) {
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]-twont[i][j];
						}
					}
				}else if (cho==2) {
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]*twont[i][j];
						}
					}
				}else if (cho==3) {
					for(int i=0;i<onet.length;i++) {
						for(int j=0;j<onet[0].length;j++) {
							tempero[i][j]=onet[i][j]/twont[i][j];
						}
					}
				}else {
					System.out.println("error: incorrect choice input");
				}
				for(int i=0;i<tempero.length;i++) {
					for(int j=0;j<tempero[0].length;j++) {
						System.out.print(tempero[i][j]+" ");
					}
					System.out.println();
				}
			}else if (n==7) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				int[][]ma=converter(te);
				int ne[][]=new int[te.getcol()][te.getrows()];
				for(int i=0;i<ma.length;i++) {
					for(int j=0;j<ma[0].length;j++) {
						ne[j][i]=ma[i][j];
					}
				}
				System.out.println("the transposed matrix is:");
				for(int i=0;i<ne.length;i++) {
					for(int j=0;j<ne[0].length;j++) {
						System.out.print(ne[i][j]+" ");
					}
					System.out.println();
				}
			}else if (n==8) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(te.gettype().contains("singular")) {
					System.out.println("error matrix doesnt have inverse");
					continue;
				}
				int[][]m=converter(te);
				double[][]inv=inv(m);//inverse(m);
				double[][]ne=new double[inv[0].length][inv.length];
				for(int i=0;i<inv.length;i++) {
					for(int j=0;j<inv[0].length;j++) {
						ne[j][i]=inv[i][j];
					}
				}
				for(int i=0;i<ne.length;i++) {
					for(int j=0;j<ne[0].length;j++) {
						System.out.print(ne[i][j]+" ");
					}
					System.out.println();
				}
			}else if (n==9) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				int[][]mat=converter(te);
				System.out.println("enter 0 for row-wise mean, 1 for column wise mean, 2 for mean of all elements");
				int mea=Integer.parseInt(scan.nextLine());
				if(mea==0) {
					int roww[]=new int[te.getcol()];
					for(int i=0;i<mat.length;i++) {
						for(int j=0;j<mat[0].length;j++) {
							roww[i]+=mat[i][j];
						}
						roww[i]=roww[i]/mat[0].length;
					}
					for(int i=0;i<roww.length;i++) {
						System.out.print(roww[i]+" ");
					}
				}else if (mea==1) {
					int coll[]=new int[te.getrows()];
					for(int j=0;j<mat[0].length;j++) {
						for(int i=0;i<mat.length;i++) {
							coll[j]+=mat[i][j];
						}
						coll[j]/=mat.length;
					}
					for(int i=0;i<coll.length;i++) {
						System.out.print(coll[i]+" ");
					}
				}else if (mea==2) {
					int ans=0;
					int de=0;
					for(int i=0;i<mat.length;i++) {
						for(int j=0;j<mat[0].length;j++) {
							ans+=mat[i][j];
							de++;
						}
					}
					ans/=de;
					System.out.println(ans);
				}
			}else if (n==10) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(!te.gettype().contains("square")) {
					System.out.println("error matrix is not square matrix:\ntry again");
					continue;
				}
				int[][]matr=converter(te);
				double ans=determinant(matr);
				System.out.println("the determinant is: "+ans);
			}else if (n==11) {
				System.out.println("please enter id of the matrix:");
				int matri=Integer.parseInt(scan.nextLine());
				matrix pl=matlist.get(matri);
				System.out.println("please enter the id of the singleton matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(!te.gettype().contains("singleton")) {
					System.out.println("error matrix is not singleton matrix:\ntry again");
					continue;
				}
				int data=((singleton)te).getElement();
				System.out.println("enter 0 for addition, 1 for subtraction, 2 for multiplication, 3 for division");
				int cho=Integer.parseInt(scan.nextLine());
				int[][]temper=converter(pl);
				if(cho==0) {
					for(int i=0;i<temper.length;i++) {
						for(int j=0;j<temper[0].length;j++) {
							temper[i][j]+=data;
							System.out.print(temper[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==1) {
					for(int i=0;i<temper.length;i++) {
						for(int j=0;j<temper[0].length;j++) {
							temper[i][j]-=data;
							System.out.print(temper[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==2) {
					for(int i=0;i<temper.length;i++) {
						for(int j=0;j<temper[0].length;j++) {
							temper[i][j]*=data;
							System.out.print(temper[i][j]+" ");
						}
						System.out.println();
					}
				}else if (cho==3) {
					for(int i=0;i<temper.length;i++) {
						for(int j=0;j<temper[0].length;j++) {
							temper[i][j]/=data;
							System.out.print(temper[i][j]+" ");
						}
						System.out.println();
					}
				}
			}else if (n==12) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(!te.gettype().contains("square")) {
					System.out.println("error matrix is not square matrix:\ntry again");
					continue;
				}
				int[][]ma=converter(te);
				int ne[][]=new int[te.getcol()][te.getrows()];
				for(int i=0;i<ma.length;i++) {
					for(int j=0;j<ma[0].length;j++) {
						ne[j][i]=ma[i][j];
					}
				}
				for(int i=0;i<ne.length;i++) {
					for(int j=0;j<ne[0].length;j++) {
						ne[i][j]+=ma[i][j];
					}
				}
				System.out.println("the sum is:");
				for(int i=0;i<ne.length;i++) {
					for(int j=0;j<ne[0].length;j++) {
						System.out.print(ne[i][j]+" ");
					}
					System.out.println();
				}
			}else if (n==13) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(!te.gettype().contains("square")) {
					System.out.println("error matrix is not square matrix:\ntry again");
					continue;
				}
				System.out.println("enter 0 for eigenvalue, enter 1 for eigenvector");
				int incho=Integer.parseInt(scan.nextLine());
				if(incho==0) {
					double[]ans=eigenvalue(converter(te));
					System.out.println("the eigenvalues are "+ans[0]+" "+ans[1]);
				}else if (incho==1) {
					int[][]ma=converter(te);
					double[]ans=eigenvalue(ma);
					eigenvector(ma, ans);
				}else {
					System.out.println("incorrect choice please enter again");
				}
			}else if (n==14) {
				System.out.println("please enter the id of the matrix");
				int inpid=Integer.parseInt(scan.nextLine());
				matrix te=matlist.get(inpid);
				if(!te.gettype().contains("square")) {
					System.out.println("error matrix is not square matrix:\ntry again");
					continue;
				}
				System.out.println("please enter id of column matrix");
				int inpid2= Integer.parseInt(scan.nextLine());
				matrix te2=matlist.get(inpid2);
				if(!te2.gettype().contains("column")) {
					System.out.println("error: matrix is not a column matrix");
					continue;
				}
				int[][]mat1=converter(te);
				int[][]mat=converter(te2);
				double[][]watcha=inv(mat1);
				double[][]ne=new double[watcha[0].length][watcha.length];
				for(int i=0;i<watcha.length;i++) {
					for(int j=0;j<watcha[0].length;j++) {
						ne[j][i]=watcha[i][j];
					}
				}
				double[][]mat2=mult(ne, mat);
				if(mat2==null) {
					continue;
				}
				for(int i=0;i<mat2.length;i++) {
					for(int j=0;j<mat2[0].length;j++) {
						System.out.println(mat2[i][j]);
					}
				}
			}else if (n==15) {
				System.out.println("enter requested matrix");
				System.out.println("1. Rectangular Matrix\r\n"
						+ "2. Row Matrix\r\n"
						+ "3. Column Matrix\r\n"
						+ "4. Square Matrix\r\n"
						+ "5. Symmetric Matrix\r\n"
						+ "6. Skew-symmetric Matrix\r\n"
						+ "7. Upper-triangular Matrix\r\n"
						+ "8. Lower-triangular Matrix\r\n"
						+ "9. Singular Matrix\r\n"
						+ "10. Diagonal Matrix\r\n"
						+ "11. Scalar Matrix\r\n"
						+ "12. Identity Matrix\r\n"
						+ "13. Singleton Matrix\r\n"
						+ "14. Ones Matrix\r\n"
						+ "15. Null Matrix");
				int cho=Integer.parseInt(scan.nextLine());
				for(matrix m:matlist.values()) {
					ArrayList<String>et=m.gettype();
					if(et.contains(typerd[cho-1])) {
						System.out.println("matrix with id: "+m.getid());
						int [][]ma=converter(m);
						for(int i=0;i<ma.length;i++) {
							for(int j=0;j<ma[0].length;j++) {
								System.out.print(ma[i][j]+" ");
							}
							System.out.println();
						}
						System.out.println();
					}
				}
			}else if (n==16) {
				break;
			}else {
				System.out.println("error: incorrect input please try again");
			}
		}
		System.out.println("\nend of test case\n");
		scan.close();
	}
}

