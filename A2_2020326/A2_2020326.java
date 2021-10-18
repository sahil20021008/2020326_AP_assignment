import java.util.*;
import java.text.SimpleDateFormat;

interface user{
	public void view_lecture_materials(HashMap<String, lecture_slide>slides,HashMap<String, lecture_video>vid);
	public void view_assessments(HashMap<Integer, assessment>assess);
	public void view_comments(comments c);
	public void add_comments(comments c,String comment);
}

interface lecture{
	public void view_lecture_materials();
}

class lecture_slide implements lecture{
	private String strDate;
	private String topic;
	private String[]content;
	private instructor i;
	public instructor get_i() {
		return this.i;
	}
	public void set_i(instructor i) {
		this.i=i;
	}
	public String get_strDate() {
		return this.strDate;
	}
	public String get_topic() {
		return this.topic;
	}
	public void set_topic(String t) {
		this.topic=t;
	}
	public String[] get_content() {
		return this.content;
	}
	public void set_content(String[]con) {
		this.content=con.clone();
	}
	public lecture_slide(String topic,String[]content,instructor i) {
		this.content=new String[content.length];
		this.set_content(content);
		this.set_topic(topic);
		this.set_i(i);
		Date date=new Date();
		SimpleDateFormat form=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		form.setTimeZone(TimeZone.getTimeZone("IST"));
		this.strDate=form.format(date);
	}
	@Override
	public void view_lecture_materials() {
		System.out.println("Title:"+this.get_topic());
		for(int alpha=0;alpha<this.get_content().length;alpha++) {
			System.out.println("Slide "+(alpha+1)+":"+this.get_content()[alpha]);
		}
		System.out.println("Number of slides:"+this.get_content().length);
		System.out.println("Date of upload:"+this.get_strDate());
		System.out.println("Uploaded by:"+this.get_i().get_name());
	}
}

class lecture_video implements lecture{
	private String strDate;
	private String topic;
	private String filename;
	private instructor i;
	public instructor get_i() {
		return this.i;
	}
	public void set_i(instructor i) {
		this.i=i;
	}
	public String get_strDate() {
		return this.strDate;
	}
	public String get_topic() {
		return this.topic;
	}
	public void set_topic(String t) {
		this.topic=t;
	}
	public String get_filename() {
		return this.filename;
	}
	public void set_filename(String name) {
		this.filename=name;
	}
	public lecture_video(String name,String topic,instructor i) {
		this.set_filename(name);
		this.set_topic(topic);
		this.set_i(i);
		Date date=new Date();
		SimpleDateFormat form=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		form.setTimeZone(TimeZone.getTimeZone("IST"));
		this.strDate=form.format(date);
	}
	@Override
	public void view_lecture_materials() {
		System.out.println("Title of video:"+this.get_topic());
		System.out.println("Video file:"+this.get_filename());
		System.out.println("Date of upload:"+this.get_strDate());
		System.out.println("Uploaded by:"+this.get_i().get_name());
	}
}

class comment_value{
	private String name;
	private String comment;
	private Date date;
    private SimpleDateFormat form; 
    private String strDate;
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	public String get_comment() {
		return this.comment;
	}
	public void set_comment(String new_comment) {
		this.comment=new_comment;
	}
	public Date get_date() {
		return this.date;
	}
	public String get_str_date() {
		return this.strDate;
	}
	public void set_str_date(SimpleDateFormat form) {
		this.strDate=form.format(this.get_date());
	}
	public comment_value(String name,String comment) {
		this.date=new Date();
		this.set_name(name);
		this.set_comment(comment);
		this.form = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		form.setTimeZone(TimeZone.getTimeZone("IST"));
		this.set_str_date(form);
	}
}

class comments{
	private HashMap<String, comment_value>h;
	public void add_h(String id,comment_value c) {
		h.put(id, c);
	}
	public HashMap<String, comment_value> get_h(){
		return this.h;
	}
	public comments() {
		this.h=new HashMap<>();
	}
	public void view_comments() {
		for(comment_value c:this.get_h().values()) {
			System.out.println(c.get_comment()+" - "+c.get_name());
			System.out.println(c.get_str_date());
			System.out.println();
		}
	}
}

class assessment{
	private String statement;
	private int max_marks;
	private String status;
	private String type;
	private int id;
	private HashMap<Integer, String>h;
	public HashMap<Integer, String> get_h(){
		return this.h;
	}
	public void set_h(int id,String ans) {
		this.h.put(id, ans);
	}
	public int get_id() {
		return this.id;
	}
	public void set_id(int id) {
		this.id=id;
	}
	public String get_type() {
		return this.type;
	}
	public void set_type(String type) {
		this.type=type;
	}
	public String get_status() {
		return this.status;
	}
	public void set_status(String stat) {
		this.status=stat;
	}
	public String get_statement() {
		return this.statement;
	}
	public void set_statement(String q) {
		this.statement=q;
	}
	public int get_max() {
		return this.max_marks;
	}
	public void set_max(int max_mark) {
		this.max_marks=max_mark;
	}
	public assessment(String q,int max,String type,int id) {
		this.set_max(max);
		this.set_statement(q);
		this.h=new HashMap<>();
		this.set_status("OPEN");
		this.set_type(type);
		this.set_id(id);
	}
	public boolean submitted(int key) {
		return this.get_h().containsKey(key);
	}
	public void close_assignment() {
		this.set_status("CLOSED");
	}
	public boolean check_close() {
		return this.get_status().equalsIgnoreCase("closed");
	}
	public boolean is_assignment() {
		return this.get_type().equalsIgnoreCase("assignment");
	}
}

class instructor implements user{
	private String name;
	private int id;
	public int get_id() {
		return this.id;
	}
	public void set_id(int i) {
		this.id=i;
	}
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	
	public instructor(String name,int id) {
		this.set_name(name);
		this.set_id(id);
	}

	@Override
	public void view_assessments(HashMap<Integer, assessment>assess) {
		if(assess.size()==0) {
			System.out.println("no assessments");
		}else {
			for(assessment a:assess.values()) {
				if(a.get_status().equalsIgnoreCase("OPEN")) {
					if(a.get_type().equalsIgnoreCase("assignment")) {
						System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement()+" Max Marks:"+a.get_max());
					}else {
						System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement());
					}
				}
			}
		}
	}

	@Override
	public void view_comments(comments c) {
		c.view_comments();
	}

	@Override
	public void add_comments(comments c,String comment) {
		comment_value co=new comment_value(this.get_name(), comment);
		c.add_h(this.get_name(), co);
	}
	@Override
	public void view_lecture_materials(HashMap<String, lecture_slide>slides,HashMap<String, lecture_video>vid) {
		for(lecture_slide s:slides.values()) {
			s.view_lecture_materials();
		}
		System.out.println();
		for(lecture_video v:vid.values()) {
			v.view_lecture_materials();
		}
	}
}

class stu_marks{
	private int marks;
	private instructor i;
	private assessment assess;
	private String checked;
	public String get_check() {
		return this.checked;
	}
	public void set_check(String c) {
		this.checked=c;
	}
	public boolean is_checked() {
		return this.get_check().equalsIgnoreCase("CHECKED");
	}
	public int get_marks() {
		return this.marks;
	}
	public void set_marks(int i) {
		this.marks=i;
	}
	public instructor get_i() {
		return this.i;
	}
	public void set_i(instructor i) {
		this.i=i;
	}
	public assessment get_a() {
		return this.assess;
	}
	public void set_a(assessment a) {
		this.assess=a;
	}
	public stu_marks(int m,instructor i,assessment a) {
		this.set_a(a);
		this.set_i(i);
		this.set_marks(m);
		this.set_check("UNCHECKED");
	}
}

class student implements user{
	private String name;
	private int id;
	private HashMap<Integer, stu_marks>s;
	public int get_id() {
		return this.id;
	}
	public void set_id(int i) {
		this.id=i;
	}
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	public HashMap<Integer, stu_marks> get_eval(){
		return this.s;
	}
	public void add(int id,stu_marks a) {
		s.put(id, a);
	}
	public student(String name,int id) {
		this.set_name(name);
		this.set_id(id);
		this.s=new HashMap<>();
	}
	
	@Override
	public void view_assessments(HashMap<Integer, assessment>assess) {
		if(assess.size()==0) {
			System.out.println("no assessments");
		}else {
			for(assessment a:assess.values()) {
				if(a.get_status().equalsIgnoreCase("OPEN")) {
					if(a.get_type().equalsIgnoreCase("assignment")) {
						System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement()+" Max Marks:"+a.get_max());
					}else {
						System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement());
					}
				}
			}
		}
	}

	@Override
	public void view_comments(comments c) {
		c.view_comments();
	}

	@Override
	public void add_comments(comments c,String comment) {
		comment_value co=new comment_value(this.get_name(), comment);
		c.add_h(this.get_name(), co);
	}
	@Override
	public void view_lecture_materials(HashMap<String, lecture_slide>slides,HashMap<String, lecture_video>vid) {
		for(lecture_slide s:slides.values()) {
			s.view_lecture_materials();
		}
		System.out.println();
		for(lecture_video v:vid.values()) {
			v.view_lecture_materials();
		}
	}
}

public class A2_2020326 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		HashMap<Integer, instructor>inst=new HashMap<>();
		HashMap<Integer, student>stu=new HashMap<>();
		for(int i=0;i<2;i++) {
			String s="I"+String.valueOf(i);
			instructor it=new instructor(s,i);
			inst.put(i, it);
		}
		for(int i=0;i<3;i++) {
			String s="S"+String.valueOf(i);
			student st=new student(s,i);
			stu.put(i, st);
		}
		HashMap<Integer, assessment>assess=new HashMap<>();
		HashMap<String, lecture_slide>slides=new HashMap<>();
		HashMap<String, lecture_video>vid=new HashMap<>();
		int assess_id=0;
		comments c=new comments();
		user first=new instructor("I0", 0);
		user second=new instructor("I1",1);
		user sfirst=new student("S0", 0);
		user ssecond=new student("S1", 1);
		user sthird=new student("S2", 2);
		HashMap<Integer,user>e1=new HashMap<>();
		HashMap<Integer,user>e2=new HashMap<>();
		e1.put(0, first);
		e1.put(1, second);
		e2.put(0, sfirst);
		e2.put(1, ssecond);
		e2.put(2, sthird);
		while(true) {
			System.out.println("Welcome to Backpack\n"
					+ "1. Enter as instructor\n"
					+ "2. Enter as student\n"
					+ "3. Exit");
			int n=Integer.parseInt(scan.nextLine());
			if(n==1) {
				System.out.println("Instructors:");
				int waka=0;
				for(instructor ing:inst.values()) {
					System.out.println(waka+" - "+ing.get_name());
					waka++;
				}
				System.out.println("Choose id:");
				int ichoice=Integer.parseInt(scan.nextLine());
				instructor in=null;
				in=inst.get(ichoice);
				if(in==null) {
					System.out.println("error: instructor is not correct");
				}
				while(true) {
					System.out.println("Welcome "+in.get_name());
					System.out.println("INSTRUCTOR MENU\n"
							+ "1. Add class material\n"
							+ "2. Add assessments\n"
							+ "3. View lecture materials\n"
							+ "4. View assessments\n"
							+ "5. Grade assessments\n"
							+ "6. Close assessment\n"
							+ "7. View comments\n"
							+ "8. Add comments\n"
							+ "9. Logout");
					int choice=Integer.parseInt(scan.nextLine());
					if(choice==1) {
						System.out.println("1. Add Lecture Slide\n"+"2. Add Lecture Video");
						int innerchoice=Integer.parseInt(scan.nextLine());
						if(innerchoice==1) {
							System.out.println("Enter topic of slides:");
							String topic=scan.nextLine();
							System.out.println("Enter number of slides:");
							int no=Integer.parseInt(scan.nextLine());
							System.out.println("Enter content of slides");
							String[]content=new String[no];
							for(int alpha=0;alpha<no;alpha++) {
								System.out.println("Content of slide "+(alpha+1)+":");
								content[alpha]=scan.nextLine();
							}
							lecture_slide sl=new lecture_slide(topic, content, in);
							slides.put(in.get_name(), sl);
						}else if (innerchoice==2) {
							System.out.println("Enter topic of video:");
							String topic=scan.nextLine();
							System.out.println("Enter filename of video:");
							String filename=scan.nextLine();
							if(filename.substring(filename.length()-4).toLowerCase().contains(".mp4".toLowerCase())) {
								lecture_video vi=new lecture_video(filename, topic, in);
								vid.put(in.get_name(), vi);
							}else {
								System.out.println("error:\nfile is not an .mp4 file");
							}
						}else {
							System.out.println("error:incorrect choice\nPlease try again");
							continue;
						}
					}else if (choice==2) {
						System.out.println("1. Add Assignment\n" + "2. Add Quiz");
						int inchoice=Integer.parseInt(scan.nextLine());
						if(inchoice==1) {
							System.out.println("Enter problem statement:");
							String stater=scan.nextLine();
							System.out.println("Enter max marks:");
							int max=Integer.parseInt(scan.nextLine());
							assessment assn=new assessment(stater, max, "Assignment", assess_id);
							assess.put(assess_id++, assn);
						}else if (inchoice==2) {
							System.out.println("Enter quiz question:");
							String que=scan.nextLine();
							assessment assn=new assessment(que, 1, "Question", assess_id);
							assess.put(assess_id++, assn);
						}else {
							System.out.println("error:\nIncorrect input\nPlease try again");
							continue;
						}
					}else if (choice==3) {
						in.view_lecture_materials(slides, vid);
					}else if (choice==4) {
						in.view_assessments(assess);
					}else if (choice==5) {
						System.out.println("List of assessments");
						in.view_assessments(assess);
						System.out.println("Enter ID of assessment to view submissions:");
						int idd=Integer.parseInt(scan.nextLine());
						System.out.println("Choose ID from these ungraded submissions");
						assessment temper=assess.get(idd);
						for(student ss:stu.values()) {
							for(stu_marks sm:ss.get_eval().values()) {
								if(sm.get_a()==temper) {
									if(!sm.is_checked()) {
										System.out.println(ss.get_id()+". "+ss.get_name());
									}
								}
							}
						}
						int stid=Integer.parseInt(scan.nextLine());
						student tempe=stu.get(stid);
						stu_marks tempere=null;
						for(stu_marks sm:tempe.get_eval().values()) {
							if(sm.get_a()==temper) {
								tempere=sm;
								System.out.println("Submission: "+temper.get_h().get(stid));
								break;
							}
						}
						System.out.println("-------------------------------");
						System.out.println("Max Marks:"+temper.get_max());
						System.out.println("Marks scored:");
						int marka=Integer.parseInt(scan.nextLine());
						tempere.set_marks(marka);
						tempere.set_check("CHECKED");
						tempere.set_i(in);
					}else if (choice==6) {
						System.out.println("List of Open Assignments:");
						for(assessment a:assess.values()) {
							if(a.get_status().equalsIgnoreCase("open")) {
								if(a.get_type().equalsIgnoreCase("assignment")) {
									System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement()+" Max Marks:"+a.get_max());
								}else {
									System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement());
								}
							}
						}
						System.out.println("Enter id of assignment to close:");
						int id=Integer.parseInt(scan.nextLine());
						assessment assn=assess.get(id);
						assn.close_assignment();
					}else if (choice==7) {
						in.view_comments(c);
					}else if (choice==8) {
						System.out.println("Enter comment:");
						String comm=scan.nextLine();
						in.add_comments(c,comm);
					}else if (choice==9) {
						break;
					}else {
						System.out.println("error: You have put incorrect input\nPlease try again");
					}
				}
			}else if (n==2) {
				System.out.println("Students:");
				int waka=0;
				for(student sok:stu.values()) {
					System.out.println(waka+" - "+sok.get_name());
					waka++;
				}
				System.out.println("Choose id:");
				int ichoice=Integer.parseInt(scan.nextLine());
				student in=null;
				in=stu.get(ichoice);
				if(in==null) {
					System.out.println("error: student is not correct");
				}
				while(true) {
					System.out.println("Welcome "+in.get_name());
					System.out.println("STUDENT MENU\n"
							+ "1. View lecture materials\n"
							+ "2. View assessments\n"
							+ "3. Submit assessment\n"
							+ "4. View grades\n"
							+ "5. View comments\n"
							+ "6. Add comments\n"
							+ "7. Logout");
					int choice=Integer.parseInt(scan.nextLine());
					if(choice==1) {
						in.view_lecture_materials(slides, vid);
					}else if (choice==2) {
						in.view_assessments(assess);
					}else if (choice==3) {
						System.out.println("Pending assessments");
						if(assess.size()==0) {
							System.out.println("No pending assignments:");
							continue;
						}else {
							boolean flag=false;
							for(assessment a:assess.values()) {
								if(a.get_status().equalsIgnoreCase("OPEN")&&a.get_h().get(in.get_id())==null) {
									if(a.get_type().equalsIgnoreCase("assignment")) {
										System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement()+" Max Marks:"+a.get_max());
									}else {
										System.out.println("ID: "+a.get_id()+" "+a.get_type()+": "+a.get_statement());
									}
									flag=true;
								}
							}
							if(!flag) {
								System.out.println("No pending assignments:");
								continue;
							}
						}
						System.out.println("Enter ID of assessment:");
						int id=Integer.parseInt(scan.nextLine());
						assessment it=assess.get(id);
						if(it==null) {
							System.out.println("error incorrect id input please try again");
							continue;
						}
						System.out.println("Enter filename of assignment:");
						String ans=scan.nextLine();
						it.set_h(in.get_id(), ans);
						stu_marks sm=new stu_marks(0, null, it);
						in.get_eval().put(it.get_id(), sm);
					}else if (choice==4) {
						System.out.println("Graded submissions");
						for(stu_marks sm:in.get_eval().values()) {
							if(sm.is_checked()) {
								assessment temp=assess.get(sm.get_a().get_id());
								System.out.println("Submission:"+temp.get_h().get(in.get_id()));
								System.out.println("Marks scored:"+sm.get_marks());
								System.out.println("Graded by:"+sm.get_i().get_name());
							}
						}
						System.out.println("----------------------------");
						System.out.println("Ungraded submissions");
						for(stu_marks sm:in.get_eval().values()) {
							if(!sm.is_checked()) {
								assessment temp=assess.get(sm.get_a().get_id());
								System.out.println("Submission:"+temp.get_h().get(in.get_id()));
							}
						}
					}else if (choice==5) {
						in.view_comments(c);
					}else if (choice==6) {
						System.out.println("Enter comment:");
						String comm=scan.nextLine();
						in.add_comments(c,comm);
					}else if (choice==7) {
						break;
					}else {
						System.out.println("error: You have put incorrect input\nPlease try again");
					}
				}
			}else if (n==3) {
				break;
			}else {
				System.out.println("incorrect input\nPlease try again");
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------\n"+"{End of Test Case}");
		scan.close();
	}
}

